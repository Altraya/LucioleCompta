/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import luciolecompta.DateUtil;

/**
 * Manager des factures
 * Permet de faire des opérations en DB sur les factures
 * @author Karakayn
 */
public class FactureManager {
    Connection db;
    public FactureManager(){
        try {
            Class.forName("org.sqlite.JDBC");
            try {
                this.db = DriverManager.getConnection("jdbc:sqlite:luciolecompta.db");
            } catch (SQLException ex) {
                Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    /**
     * Allow you to get all bill for one client specified in entry
     * @param client : The client whose we want the bill
     * @return an observablelist of facture
     */
    public ObservableList<Facture> getClientFactures(Client client){
        Statement stmt = null;
        ObservableList<Facture> bill = FXCollections.observableArrayList();
        
        if(client.getId() == 0)
            System.out.println("Erreur : id du client n'est pas défini");
        else{
            try {
                stmt = db.createStatement();

                System.out.println("Selection des factures du client n°"+client.getId()+" en base de données.");
                ResultSet rs = stmt.executeQuery("SELECT CLIENT.id, sujet, dateDevis, type, prixTotal, dateExecution, datePaiement FROM FACTURE JOIN CLIENT ON (CLIENT.id = FACTURE.idClient) WHERE CLIENT.id = "+client.getId());
                System.out.println(rs.next());
                
                while (rs.next()) {
                    //Need to do this weird think because i cant use rs.getDate() cause it return a timestamp and i can't change this or i always have error / see branch test2
                    //Transformation to date
                    Date dateDevis = DateUtil.getDate(rs.getObject("dateDevis"));
                    Date dateExecution = DateUtil.getDate(rs.getObject("dateExecution"));
                    Date datePaiement = DateUtil.getDate(rs.getObject("datePaiement"));
                    //Check if something is null
                    int prixTotal = 0;
                    if(rs.getString("prixTotal") != null)
                        prixTotal = rs.getInt("prixTotal");
                    String type = "";
                    if(rs.getString("type") != "" || rs.getString("type") != null)
                        type = rs.getString("type");
                    System.out.println("Rs : id : "+rs.getObject("id")+ "\n");
                    System.out.println("sujet : "+rs.getObject("sujet"));
                    System.out.println("dateDevis :"+rs.getObject("dateDevis"));
                    System.out.println("type :"+rs.getString("type"));
                    System.out.println("prixTotal :"+prixTotal);
                    System.out.println("dateExecution : "+rs.getObject("dateExecution"));
                    System.out.println("datePaiement : "+rs.getObject("datePaiement"));

                    Facture fac = new Facture(rs.getInt("id"), rs.getString("sujet"), dateDevis, type, prixTotal, dateExecution, datePaiement);
                    //System.out.println("Dans getClientdata de clientManager | id =" + rs.getInt("id")+ " nom = " + rs.getString("nom") + " Entreprise " +rs.getString("entreprise")+ " Adresse 1 " + rs.getString("adresse1") + "\n");
                    System.out.println("Objet facture crée");
                    bill.add(fac);
                    System.out.println("Objet facture ajouté à la liste");
                }
                System.out.println("Ok.");
                stmt.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.out.println("Exception dans facture manager");
                System.exit(0);
            }
        }
        for(int i = 0; i<bill.size(); i++){
            System.out.println(bill.get(i).toString());
        }
        return bill;
    }
}
