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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        
        try {
            stmt = db.createStatement();
            
            System.out.println("Selection des factures du client n°"+client.getId()+" en base de données.");
            ResultSet rs = stmt.executeQuery("SELECT id, sujet, dateDevis, type, prixTotal, dateExecution, datePaiement FROM FACTURE");
            while (rs.next()) {
                Date tmpDateDevis = new Date(rs.getString("dateDevis"));
                System.out.println("String : "+rs.getString("dateDevis"));
                System.out.println("Rs : "+rs.getDate("dateDevis")+"\n");
                /*Facture fac = new Facture(rs.getInt("id"), rs.getString("sujet"), rs.getDate("dateDevis"), rs.getString("type"), rs.getInt("total"), rs.getDate("dateExecution"), rs.getDate("datePaiement"));
                //System.out.println("Dans getClientdata de clientManager | id =" + rs.getInt("id")+ " nom = " + rs.getString("nom") + " Entreprise " +rs.getString("entreprise")+ " Adresse 1 " + rs.getString("adresse1") + "\n");
                bill.add(fac);*/
            }
            System.out.println("Ok.");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return bill;
    }
}
