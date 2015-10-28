/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Models;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * An article
 * @author Karakayn
 */
public class Article {
    
    private final IntegerProperty id;
    private final StringProperty nom;
    private final FloatProperty prix;
    private final IntegerProperty maxEnStock;
    private final StringProperty categorie;
    
    public Article(int id, String nom, float prix, int maxEnStock, String categorie){
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prix = new SimpleFloatProperty(prix);
        this.maxEnStock = new SimpleIntegerProperty(maxEnStock);
        this.categorie = new SimpleStringProperty(categorie);
    }

    /**
     * @return the id
     */
    public IntegerProperty idProperty() {
        return id;
    }
    
    public Integer getId(){
        return id.get();
    }

    /**
     * @return the nom
     */
    public StringProperty nomProperty() {
        return nom;
    }

    public String getNom(){
        return nom.get();
    }
    
    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom.set(nom);
    }

    /**
     * @return the prix
     */
    public FloatProperty prixProperty() {
        return prix;
    }
    
    public float getPrix(){
        return prix.get();
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix.set(prix);
    }

    /**
     * @return the maxEnStock
     */
    public IntegerProperty maxEnStockProperty() {
        return maxEnStock;
    }
    
    public int getMaxEnStock(){
        return maxEnStock.get();
    }

    /**
     * @param maxEnStock the maxEnStock to set
     */
    public void setMaxEnStock(int maxEnStock) {
        this.maxEnStock.set(maxEnStock);
    }

    /**
     * @return the categorie
     */
    public StringProperty categorieProperty() {
        return categorie;
    }
    
    public String getCategorie(){
        return categorie.get();
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(String categorie) {
        this.categorie.set(categorie);
    }
    
}
