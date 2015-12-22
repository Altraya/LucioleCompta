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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Manager des articles.
 * Permet de faire des opérations en base de données sur les articles.
 * @author Karakayn
 */
public class ArticleManager {
    Connection db;
    
    public ArticleManager(){
  
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
     * select all articles in database
     * @return an observable list of articles
     */
    public ObservableList<Article> getClientData(){
        Statement stmt = null;
        ObservableList<Article> articleData = FXCollections.observableArrayList();
        
        try {
            stmt = db.createStatement();
            
            System.out.println("Selection des articles en base de données.");
            ResultSet rs = stmt.executeQuery("SELECT article.id, article.nom, prix, maxEnStock, article.idCategorie, categorie.nom FROM ARTICLE JOIN CATEGORIE ON idCategorie = categorie.id");
            while (rs.next()) {
                Article article = new Article(rs.getInt("id"), rs.getString("nom"), rs.getFloat("prix"), rs.getInt("maxEnStock"), rs.getString("categorie.nom"));
                articleData.add(article);
            }
            System.out.println("Ok.");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return articleData;
    }
    
    /**
     * Add an article in database
     * @param article : article object :
     * /!\ idCategorie of the table Article is directly the categorie name in this Object /!\
     */
    public void addArticle(Article article){
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            stmt = db.createStatement();
            String sql = "INSERT INTO CLIENT(id, nom, prix, maxEnStock, idCategorie)"
                    + "VALUES("+article.getId()+", '"+article.getNom()+"', '"+article.getPrix()+"', "
                    + "'"+article.getMaxEnStock()+"', '"+article.getCategorie()+")";
            System.out.println("Dans add article");
            stmt.executeUpdate(sql);
            System.out.println("INSERT d'article réussi !");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public void updateArticle(Article a){
        Statement stmt = null;
        try {
            System.out.println("Dans update client");
            Class.forName("org.sqlite.JDBC");
            stmt = db.createStatement();
            String sql = "UPDATE CLIENT "
                    + "SET nom = '"+a.getNom()+"', "
                    + "prix = '"+a.getPrix()+"', "
                    + "maxEnStock = '"+a.getMaxEnStock()+"', "
                    + "idCategorie = '"+a.getCategorie()+"' "
                    + "WHERE id = "+a.getId()+";";
            stmt.executeUpdate(sql);
            System.out.println("UPDATE de l'article réussi !");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    /**
     * Delete an article in database
     * @param idArticle : id of the Article we want to remove
     */
    public void deleteArticle(int idArticle){
        System.out.println("id article a remove= "+idArticle);
        Statement stmt = null;
       
        try {
            stmt = db.createStatement();
            
            System.out.println("Suppression du client n°"+idArticle);
            String sql = "DELETE FROM CLIENT " +
                   "WHERE id = "+idArticle;
            stmt.executeUpdate(sql);
            System.out.println("Ok.");
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
