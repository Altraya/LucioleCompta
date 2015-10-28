/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Models;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A bill object
 * @author Karakayn
 */
public class Facture {

    private final IntegerProperty id;
    //offre ou facture ou bon livraison
    private final StringProperty type;
    //date du devis
    private final ObjectProperty<LocalDate> dateDevis;
    //Flag pour savoir si ca a été payé ou non => false defaut
    private final IntegerProperty paye;
    //Flag pour savoir si ca a été confirme ou non => false defaut
    private final IntegerProperty confirme;
    //Sujet de la facture : Defaut a null
    private final StringProperty sujet;
    //date de l'execution du contrat / null
    private final ObjectProperty<LocalDate> dateExecution;
    //date du paiement /null
    private final ObjectProperty<LocalDate> datePaiement;
    //pourcentage de rabais au total defaut 0
    private final IntegerProperty rabaisTotal;
    //type de devis (location, prestation ou vente) 
    private final StringProperty typeDevis;
    //TVA : 8% par defaut
    private final IntegerProperty TVA;
    //type de paiement (liquide, facture, carte) defaut liquide
    private final StringProperty typePaiement;
    //durée du paiement (à la prise du matériel, 30 jours, 10 jours, au retour) defaut paiement d'avance
    private final StringProperty dureePaiement;
    //durée de la location
    private final StringProperty dureeLocation;
    //commentaire potentiel / null
    private final StringProperty commentaire;
    //prix total des articles raccordés a la facture /null si pas encore renseigné
    private final IntegerProperty prixTotal;
    
    public Facture(int id, String type, Date dateDevis, int paye, int confirme, 
            String sujet, Date dateExecution, Date datePaiement, int rabaisTotal, String typeDevis, 
            int TVA, String typePaiement, String dureePaiement, String dureeLocation, String commentaire,
            int prixTotal){
  
        this.id = new SimpleIntegerProperty(id);
        this.type = new SimpleStringProperty(type);
        this.dateDevis = new SimpleObjectProperty<>(LocalDate.parse(dateDevis.toString()));
        this.paye = new SimpleIntegerProperty(paye);
        this.confirme = new SimpleIntegerProperty(confirme);
        this.sujet = new SimpleStringProperty(sujet);
        this.dateExecution = new SimpleObjectProperty<>(LocalDate.parse(dateExecution.toString())/*of(dateExecution)*/);
        this.datePaiement = new SimpleObjectProperty<>(LocalDate.parse(datePaiement.toString()));
        this.rabaisTotal = new SimpleIntegerProperty(rabaisTotal);
        this.typeDevis = new SimpleStringProperty(typeDevis);
        this.TVA = new SimpleIntegerProperty(TVA);
        this.typePaiement = new SimpleStringProperty(typePaiement);
        this.dureePaiement = new SimpleStringProperty(dureePaiement);
        this.dureeLocation = new SimpleStringProperty(dureeLocation);
        this.commentaire = new SimpleStringProperty(commentaire);
        this.prixTotal = new SimpleIntegerProperty(prixTotal);
    }
    
    //Sert pour crée une facture qui sert dans la vue des clients pour voir les factures associées au client
    public Facture(int id, String nom, Date dateDevis, String type, int total, Date dateExecution, Date datePaiement){
        this.id = new SimpleIntegerProperty(id);
        this.sujet = new SimpleStringProperty(nom);
        this.dateDevis = new SimpleObjectProperty<>(LocalDate.parse(dateDevis.toString()));
        this.type = new SimpleStringProperty(type);
        this.prixTotal = new SimpleIntegerProperty(total);
        this.dateExecution = new SimpleObjectProperty<>(LocalDate.parse(dateExecution.toString())/*of(dateExecution)*/);
        this.datePaiement = new SimpleObjectProperty<>(LocalDate.parse(datePaiement.toString()));
    
        this.paye = null;
        this.confirme = null;
        this.rabaisTotal = null;
        this.typeDevis = null;
        this.TVA = new SimpleIntegerProperty(8);
        this.typePaiement = null;
        this.dureePaiement = null;
        this.dureeLocation = null;
        this.commentaire = null;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id.get();
    }
    
    /**
    * @return the paye
    */
    public IntegerProperty idProperty() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id.set(id);
    }

    /**
     * @return the type
     */
    public String getType() {
        return type.get();
    }
    
    public StringProperty typeProperty(){
        return type;
    }

    /**
     * @return the paye
     */
    public IntegerProperty payeProperty() {
        return paye;
    }
    
    public int getPaye(){
        return paye.get();
    }

    /**
     * @param paye the paye to set
     */
    public void setPaye(int paye) {
        this.paye.set(paye);
    }

    /**
     * @return the confirme
     */
    public IntegerProperty confirmeProperty() {
        return confirme;
    }
    
    public int getConfirme(){
        return confirme.get();
    }

    /**
     * @param confirme the confirme to set
     */
    public void setConfirme(int confirme) {
        this.confirme.set(confirme);
    }

    /**
     * @return the sujet
     */
    public StringProperty sujetProperty() {
        return sujet;
    }
    
    public String getSujet(){
        return sujet.get();
    }

    /**
     * @param sujet the sujet to set
     */
    public void setSujet(String sujet) {
        this.sujet.set(sujet);
    }

    /**
     * @return the dateExecution
     */
    public ObjectProperty<LocalDate> dateExecutionProperty() {
        return dateExecution;
    }
    
    public LocalDate getDateExecution(){
        return dateExecution.get();
    }

    /**
     * @param dateExecution the dateExecution to set
     */
    public void setDateExecution(LocalDate dateExecution) {
        this.dateExecution.set(dateExecution);
    }

    /**
     * @return the datePaiement
     */
    public ObjectProperty<LocalDate> datePaiementProperty() {
        return datePaiement;
    }
    
    public LocalDate getDatePaiement(){
        return datePaiement.get();
    }

    /**
     * @param datePaiement the datePaiement to set
     */
    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement.set(datePaiement);
    }

    /**
     * @return the rabaisTotal
     */
    public IntegerProperty rabaisTotalProperty() {
        return rabaisTotal;
    }
    
    public int getRabaisTotal(){
        return rabaisTotal.get();
    }

    /**
     * @param rabaisTotal the rabaisTotal to set
     */
    public void setRabaisTotal(int rabaisTotal) {
        this.rabaisTotal.set(rabaisTotal);
    }

    /**
     * @return the typeDevis
     */
    public StringProperty getTypeDevis() {
        return typeDevis;
    }

    /**
     * @param typeDevis the typeDevis to set
     */
    public void setTypeDevis(String typeDevis) {
        this.typeDevis.set(typeDevis);
    }

    /**
     * @return the TVA
     */
    public IntegerProperty TVAProperty() {
        return TVA;
    }
    
    public int getTVA(){
        return TVA.get();
    }

    /**
     * @param TVA the TVA to set
     */
    public void setTVA(int TVA) {
        this.TVA.set(TVA);
    }

    /**
     * @return the typePaiement
     */
    public StringProperty typePaiementProperty() {
        return typePaiement;
    }
    
    public String getTypePaiement(){
        return typePaiement.get();
    }

    /**
     * @param typePaiement the typePaiement to set
     */
    public void setTypePaiement(String typePaiement) {
        this.typePaiement.set(typePaiement);
    }

    /**
     * @return the dureePaiement
     */
    public StringProperty dureePaiementProperty() {
        return dureePaiement;
    }
    
    public String getDureePaiement(){
        return dureePaiement.get();
    }

    /**
     * @param dureePaiement the dureePaiement to set
     */
    public void setDureePaiement(String dureePaiement) {
        this.dureePaiement.set(dureePaiement);
    }

    /**
     * @return the dureeLocation
     */
    public StringProperty dureeLocationProperty() {
        return dureeLocation;
    }
    
    public String getDureeLocation(){
        return dureeLocation.get();
    }

    /**
     * @param dureeLocation the dureeLocation to set
     */
    public void setDureeLocation(String dureeLocation) {
        this.dureeLocation.set(dureeLocation);
    }

    /**
     * @return the prixTotal
     */
    public IntegerProperty prixTotalProperty() {
        return prixTotal;
    }
    
    public int getPrixTotal(){
        return prixTotal.get();
    }

    /**
     * @param prixTotal the prixTotal to set
     */
    public void setPrixTotal(int prixTotal) {
        this.prixTotal.set(prixTotal);
    }

    /**
     * @return the devis date
     */
    public LocalDate getDateDevis() {
        return dateDevis.get();
    }

    public ObjectProperty<LocalDate> dateDevisProperty() {
        return dateDevis;
    }
    /**
     * @param dateDevis the dateDevis to set
     */
    public void setdateDevis(LocalDate dateDevis) {
        this.dateDevis.set(dateDevis);
    }
    
    /**
     * @return the commentaire
     */
    public String getCommentaire() {
        return commentaire.get();
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire.set(commentaire);
    }
    
    public StringProperty commentaireProperty(){
        return commentaire;
    }

    @Override
    public String toString(){
        String res = "";
        
            res += "Id = "+id+"\n";
            res += "sujet = "+getSujet()+"\n";
            res += "dateDevis = "+dateDevis+"\n";
            res += "type = "+type+"\n";
            res += "prixTotal = "+getPrixTotal()+"\n";
            res += "dateExecution = "+getDateExecution()+"\n";
            res += "datePaiement = "+getDatePaiement()+"\n";
            res += "paye = "+getPaye()+"\n";
            res += "confirme = "+getConfirme()+"\n";
            res += "rabaisTotal = "+getRabaisTotal()+"\n";
            res += "TVA = "+getTVA()+"\n";
            res += "typePaiement = "+getTypePaiement()+"\n";
            res += "dureePaiement = "+getDureePaiement()+"\n";
            res += "dureeLocation = "+getDureeLocation()+"\n";
            res += "commentaire = "+commentaire+"\n";
            
        return res;
    }
}
