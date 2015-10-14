/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Models;

/**
 *
 * @author Karakayn
 */
public class Facture {

    private int id;
    //offre ou facture ou bon livraison
    private String type;
    //date du devis
    private Date dateDevis;
    //Flag pour savoir si ca a été payé ou non => false defaut
    private int paye;
    //Flag pour savoir si ca a été confirme ou non => false defaut
    private int confirme;
    //Sujet de la facture : Defaut a null
    private String sujet;
    //date de l'execution du contrat / null
    private Date dateExecution;
    //date du paiement /null
    private Date datePaiement;
    //pourcentage de rabais au total defaut 0
    private int rabaisTotal;
    //type de devis (location, prestation ou vente) 
    private String typeDevis;
    //TVA : 8% par defaut
    private int TVA;
    //type de paiement (liquide, facture, carte) defaut liquide
    private String typePaiement;
    //durée du paiement (à la prise du matériel, 30 jours, 10 jours, au retour) defaut paiement d'avance
    private String dureePaiement;
    //durée de la location
    private String dureeLocation;
    private String commentaire;
    
}
