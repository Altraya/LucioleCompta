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
    private IntegerProperty paye;
    //Flag pour savoir si ca a été confirme ou non => false defaut
    private IntegerProperty confirme;
    //Sujet de la facture : Defaut a null
    private StringProperty sujet;
    //date de l'execution du contrat / null
    private ObjectProperty<LocalDate> dateExecution;
    //date du paiement /null
    private ObjectProperty<LocalDate> datePaiement;
    //pourcentage de rabais au total defaut 0
    private IntegerProperty rabaisTotal;
    //type de devis (location, prestation ou vente) 
    private StringProperty typeDevis;
    //TVA : 8% par defaut
    private IntegerProperty TVA;
    //type de paiement (liquide, facture, carte) defaut liquide
    private StringProperty typePaiement;
    //durée du paiement (à la prise du matériel, 30 jours, 10 jours, au retour) defaut paiement d'avance
    private StringProperty dureePaiement;
    //durée de la location
    private StringProperty dureeLocation;
    //commentaire potentiel / null
    private final StringProperty commentaire;
    //prix total des articles raccordés a la facture /null si pas encore renseigné
    private IntegerProperty prixTotal;
    
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

    /**
     * @return the paye
     */
    public IntegerProperty getPaye() {
        return paye;
    }

    /**
     * @param paye the paye to set
     */
    public void setPaye(IntegerProperty paye) {
        this.paye = paye;
    }

    /**
     * @return the confirme
     */
    public IntegerProperty getConfirme() {
        return confirme;
    }

    /**
     * @param confirme the confirme to set
     */
    public void setConfirme(IntegerProperty confirme) {
        this.confirme = confirme;
    }

    /**
     * @return the sujet
     */
    public StringProperty getSujet() {
        return sujet;
    }

    /**
     * @param sujet the sujet to set
     */
    public void setSujet(StringProperty sujet) {
        this.sujet = sujet;
    }

    /**
     * @return the dateExecution
     */
    public ObjectProperty<LocalDate> getDateExecution() {
        return dateExecution;
    }

    /**
     * @param dateExecution the dateExecution to set
     */
    public void setDateExecution(ObjectProperty<LocalDate> dateExecution) {
        this.dateExecution = dateExecution;
    }

    /**
     * @return the datePaiement
     */
    public ObjectProperty<LocalDate> getDatePaiement() {
        return datePaiement;
    }

    /**
     * @param datePaiement the datePaiement to set
     */
    public void setDatePaiement(ObjectProperty<LocalDate> datePaiement) {
        this.datePaiement = datePaiement;
    }

    /**
     * @return the rabaisTotal
     */
    public IntegerProperty getRabaisTotal() {
        return rabaisTotal;
    }

    /**
     * @param rabaisTotal the rabaisTotal to set
     */
    public void setRabaisTotal(IntegerProperty rabaisTotal) {
        this.rabaisTotal = rabaisTotal;
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
    public void setTypeDevis(StringProperty typeDevis) {
        this.typeDevis = typeDevis;
    }

    /**
     * @return the TVA
     */
    public IntegerProperty getTVA() {
        return TVA;
    }

    /**
     * @param TVA the TVA to set
     */
    public void setTVA(IntegerProperty TVA) {
        this.TVA = TVA;
    }

    /**
     * @return the typePaiement
     */
    public StringProperty getTypePaiement() {
        return typePaiement;
    }

    /**
     * @param typePaiement the typePaiement to set
     */
    public void setTypePaiement(StringProperty typePaiement) {
        this.typePaiement = typePaiement;
    }

    /**
     * @return the dureePaiement
     */
    public StringProperty getDureePaiement() {
        return dureePaiement;
    }

    /**
     * @param dureePaiement the dureePaiement to set
     */
    public void setDureePaiement(StringProperty dureePaiement) {
        this.dureePaiement = dureePaiement;
    }

    /**
     * @return the dureeLocation
     */
    public StringProperty getDureeLocation() {
        return dureeLocation;
    }

    /**
     * @param dureeLocation the dureeLocation to set
     */
    public void setDureeLocation(StringProperty dureeLocation) {
        this.dureeLocation = dureeLocation;
    }

    /**
     * @return the prixTotal
     */
    public IntegerProperty getPrixTotal() {
        return prixTotal;
    }

    /**
     * @param prixTotal the prixTotal to set
     */
    public void setPrixTotal(IntegerProperty prixTotal) {
        this.prixTotal = prixTotal;
    }

    public StringProperty typeProperty(){
        return type;
    }
    
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type.set(type);
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
