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
        System.out.println("Date devis : "+dateDevis);
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

    
}
