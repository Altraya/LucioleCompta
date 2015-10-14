/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta;

import java.sql.Connection;
import java.sql.DriverManager;
import luciolecompta.Private.DBCreation;
/**
 * Logiciel de comptabilité pour DKPROD
 * @author Karakayn
 */
public class LucioleCompta {

    /**
     * @TODO : A faire : Finir de faire la classe facture et finir la partie facture des clients 
     * Plus tard : Pas oublier de faire une syncro sans avoir besoin de valider l'édition => timer
     * Au final > un controller = une page
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection c = null;
        try {
            /*Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:luciolecompta.db");
            //Creation de la DB
            DBCreation creationManager = new DBCreation();
            //creationManager.createTables(c);
            //Drop des tables
            creationManager.dropTables(c);
            creationManager.createTables(c);
            creationManager.populate(c);
            creationManager.populateFacture(c);
            //creationManager.showTableSQL(c, "CLIENT");
            c.close();*/
            
            //affichage de la page d'accueil
            MainApp mainPage = new MainApp();
            mainPage.main(args);
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        
    }
    
}
