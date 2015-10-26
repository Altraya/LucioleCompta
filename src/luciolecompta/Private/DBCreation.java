/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Private;

import java.sql.*;

/**
 * Script permettant de créer les tables de la base de données.
 *
 * @author Karakayn
 */
public class DBCreation {

    //Creation des tables
    public static void createTables(Connection c) {
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS CLIENT "
                    + "(id              INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " nom             VARCHAR(50),"
                    + " prenom          VARCHAR(50),"
                    + " entreprise      VARCHAR(50),"
                    + " adresse1        VARCHAR(50),"
                    + " adresse2        VARCHAR(50),"
                    + " ville           VARCHAR(50),"
                    + " NPA             VARCHAR(20)," //code postal
                    + " telephone1      VARCHAR(16),"
                    + " telephone2      VARCHAR(16),"
                    + " email           VARCHAR(50),"
                    + "commentaire      TEXT)";
            stmt.executeUpdate(sql);
            System.out.println("Table CLIENT crée avec succès.");

            sql = "CREATE TABLE IF NOT EXISTS ARTICLE "
                    + "(id              INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "nom              VARCHAR(50),"
                    + "prix             INTEGER,"
                    + "maxEnStock       INTEGER"
                    + "idCategorie      INT NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("Table ARTICLE crée avec succès.");

            sql = "CREATE TABLE IF NOT EXISTS FACTURE "
                    + "(id              INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "type             VARCHAR(50)," //offre ou facture ou bon livraison
                    + "dateDevis        DATE," //date du devis
                    + "paye             INTEGER DEFAULT 0," //Flag pour savoir si ca a été payé ou non => false defaut
                    + "confirme         INTEGER DEFAULT 0," //Flag pour savoir si ca a été confirme ou non => false defaut
                    + "sujet            TEXT," // null defaut
                    + "dateExecution    DATE," //date de l'execution du contrat / null
                    + "datePaiement     DATE," //date du paiement /null
                    + "rabaisTotal      INTEGER DEFAULT 0," //pourcentage de rabais au total defaut 0
                    + "typeDevis        TEXT NOT NULL," //type de devis (location, prestation ou vente) 
                    + "TVA              INTEGER DEFAULT 8," //TVA : 8% par defaut
                    + "typePaiement     TEXT DEFAULT 'liquide'," //type de paiement (liquide, facture, carte) defaut liquide
                    + "dureePaiement    TEXT DEFAULT 'en avance'," //durée du paiement (à la prise du matériel, 30 jours, 10 jours, au retour) defaut paiement d'avance
                    + "dureeLocation    TEXT,"
                    + "commentaire      TEXT,"
                    + "prixTotal        INT," //prix total des articles liés a la facture
                    + "idClient         INT)"; //id du client lié a cette facture
            stmt.executeUpdate(sql);
            System.out.println("Table FACTURE crée avec succès.");

            sql = "CREATE TABLE IF NOT EXISTS CATEGORIE"
                    + "(id          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "nom          TEXT NOT NULL,"
                    + "type         TEXT NOT NULL)";  //Type de catégorie (Article, Honoraires, Frais)
            stmt.executeUpdate(sql);
            System.out.println("Table CATEGORIE crée avec succès.");

            sql = "CREATE TABLE IF NOT EXISTS ARTICLES_PAR_CLIENT_PAR_FACTURE"
                    + "(id          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "rendu        INTEGER DEFAULT 0," //si l'article rattaché a été rendu ou non par defaut a false (0)
                    + "idArticle    INTEGER NOT NULL,"
                    + "idClient     INTEGER NOT NULL,"
                    + "idFacture    INTEGER NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("Table ARTICLES_PAR_CLIENT_PAR_FACTURE crée avec succès.");

            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Creation des tables effectuée avec succès.");
    }

    //Suppression des tables
    public static void dropTables(Connection c) {
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            stmt = c.createStatement();
            //Script de suppression des tables

            String sql = "DROP TABLE ARTICLE";
            stmt.executeUpdate(sql);
            System.out.println("La table ARTICLE a été supprimée avec succès.");

            sql = "DROP TABLE CLIENT";
            stmt.executeUpdate(sql);
            System.out.println("La table CLIENT a été supprimée avec succès.");

            sql = "DROP TABLE FACTURE";
            stmt.executeUpdate(sql);
            System.out.println("La table FACTURE a été supprimée avec succès.");

            sql = "DROP TABLE CATEGORIE";
            stmt.executeUpdate(sql);
            System.out.println("La table CATEGORIE a été supprimée avec succès.");

            sql = "DROP TABLE ARTICLES_PAR_CLIENT_PAR_FACTURE";
            stmt.executeUpdate(sql);
            System.out.println("La table ARTICLES_PAR_CLIENT_PAR_FACTURE a été supprimée avec succès.");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Les tables ont été correctement supprimées.");
    }
    
    public static void populate(Connection c) {
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            stmt = c.createStatement();
            String sql = "INSERT INTO CLIENT(id, nom, prenom, entreprise)"
                    + "VALUES(3, 'Crapeau', 'Le Jean-Michel', 'RitoGames Industry'),"
                    + "(4, 'Monk', 'Crapouille', 'Blizzard enternment')";
            stmt.executeUpdate(sql);
            System.out.println("INSERT de client réussi !");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    /**
     * Populate the database with test data
     * @param c : DB connection
     */
    public static void populateFacture(Connection c) {
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            stmt = c.createStatement();
            String sql = "INSERT INTO FACTURE(id, type, dateDevis, paye, confirme, sujet, dateExecution, "
                    + "datePaiement, rabaisTotal, typeDevis, TVA, typePaiement, dureePaiement, dureeLocation, commentaire, idClient)"
                    + "VALUES(null, 'facture', '2015-01-22', 0, 0, 'Concert sur montagne', '2015-12-31', '0000-00-00', 0, 'location', 8, 'liquide', 'en avance', '2 jours', 'ceci est un commentaire', 3),"
                    + "(null, 'facture', '2012-10-02', 0, 0, 'Concert quelque part', '2015-12-22', '2014-12-10', 0, 'location', 8, 'liquide', 'en avance', '15 jours', 'ceci est un commentaire', 4),"
                    + "(null, 'facture', '2012-10-02', 0, 0, 'Concert quelque part2', '2015-12-22', '2014-12-10', 0, 'location', 8, 'liquide', 'en avance', '15 jours', 'ceci est un commentaire', 4)";

            stmt.executeUpdate(sql);
            System.out.println("INSERT de Facture réussi !");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public static void showTableSQL(Connection c, String nomTable) {
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            stmt = c.createStatement();
            System.out.println("Selection de toute la table "+nomTable);
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + nomTable);
            System.out.println("Ok.");
            while (rs.next()) {
                //TODO afficher tout
                System.out.println("RS = "+rs.getString("Nom"));
            }
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
