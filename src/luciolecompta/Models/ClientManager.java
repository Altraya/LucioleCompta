/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Models;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import luciolecompta.Models.Client;

/**
 * Manager des clients.
 * Permet de faire des opérations en base de données sur les clients.
 * @author Karakayn
 */
public class ClientManager {
    Connection db;
    
    public ClientManager(){
  
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
     * select all client in database with id nom prenom entreprise
     * @return an observable list of client
     */
    public ObservableList<Client> getClientData(){
        Statement stmt = null;
        ObservableList<Client> clientData = FXCollections.observableArrayList();
        
        try {
            stmt = db.createStatement();
            
            System.out.println("Selection des clients en base de données.");
            ResultSet rs = stmt.executeQuery("SELECT id, nom, prenom, adresse1, adresse2, ville, NPA, telephone1, telephone2, email, commentaire, entreprise FROM CLIENT");
            System.out.println("Ok.");
            while (rs.next()) {
                Client client = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse1"), rs.getString("adresse2"), rs.getString("ville"), rs.getString("NPA"), rs.getString("telephone1"), rs.getString("telephone2"), rs.getString("email"), rs.getString("entreprise"), rs.getString("commentaire"));
                //System.out.println("Dans getClientdata de clientManager | id =" + rs.getInt("id")+ " nom = " + rs.getString("nom") + " Entreprise " +rs.getString("entreprise")+ " Adresse 1 " + rs.getString("adresse1") + "\n");
                clientData.add(client);
            }
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return clientData;
    }
    
    /**
     * Get the max id of a selected table
     * For example when we add a new client we need to know the last client's id, to create an other one
     * @param tableName : name of the table
     * @return 
     */
    public int getMaxId(String tableName){
        Statement stmt = null;
        int maxId = 0;
        
        try {
            stmt = db.createStatement();
            
            System.out.println("Max des ids de la table "+tableName);
            ResultSet rs = stmt.executeQuery("SELECT max(id) FROM "+tableName);
            System.out.println("Ok.");
            while (rs.next()) {
                maxId = rs.getInt(1);
                System.out.println("Résultat du max = "+maxId);
                
            }
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return maxId;
    }
    
    public void addClient(Client client){
    Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            stmt = db.createStatement();
            String sql = "INSERT INTO CLIENT(id, nom, prenom, adresse1, adresse2, ville, NPA, telephone1, telephone2, email, entreprise, commentaire)"
                    + "VALUES("+client.getId()+", '"+client.getNom()+"', '"+client.getPrenom()+"', '"+client.getAdresse1()+"', '"+client.getAdresse2()+"', '"+client.getVille()+"', '"+client.getNPA()+"', '"+client.getTelephone1()+"', '"+client.getTelephone2()+"', '"+client.getEmail()+"', '"+client.getEntreprise()+"', '"+client.getCommentaire()+"')";
            System.out.println("Dans add client");
            stmt.executeUpdate(sql);
            System.out.println("INSERT de client réussi !");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    /**
     * Delete a client in database
     * @param client : Client we want to remove
     */
    public void deleteClient(int idClient){
        System.out.println("id client = "+idClient);
        Statement stmt = null;
       
        try {
            stmt = db.createStatement();
            
            System.out.println("Suppression du client n°"+idClient);
            String sql = "DELETE FROM CLIENT " +
                   "WHERE id = "+idClient;
            stmt.executeUpdate(sql);
            System.out.println("Ok.");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
