/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Models;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Représente un client
 * @author Karakayn
 */
public class Client {
    
    //initialisation, tout peut etre vide sauf l'id
    private final IntegerProperty id;
    private final StringProperty entreprise;
    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty adresse1;
    private final StringProperty adresse2;
    private final StringProperty NPA; 
    private final StringProperty ville;
    private final StringProperty telephone1;
    private final StringProperty telephone2;
    private final StringProperty email;
    private final StringProperty commentaire;
    
    public Client(int id_client){
        this.id = new SimpleIntegerProperty(id_client);
        this.entreprise = new SimpleStringProperty("");
        this.nom = new SimpleStringProperty("");
        this.prenom = new SimpleStringProperty("");
        this.adresse1 = new SimpleStringProperty("");
        this.adresse2 = new SimpleStringProperty("");
        this.NPA = new SimpleStringProperty("");
        this.ville = new SimpleStringProperty("");
        this.telephone1 = new SimpleStringProperty("");
        this.telephone2 = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.commentaire = new SimpleStringProperty("");
    }
    
    public Client(int id_client, String nom, String prenom, String entreprise){
        this.id = new SimpleIntegerProperty(id_client);
        this.entreprise = new SimpleStringProperty(entreprise);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.adresse1 = new SimpleStringProperty("");
        this.adresse2 = new SimpleStringProperty("");
        this.NPA = new SimpleStringProperty("");
        this.ville = new SimpleStringProperty("");
        this.telephone1 = new SimpleStringProperty("");
        this.telephone2 = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.commentaire = new SimpleStringProperty("");
    }
    
    /*
    * This constructor is used for new client with all attributes 
    */
    public Client(int id_client, String nom, String prenom, String adresse1, String adresse2, String NPA, String ville, String telephone1, String telephone2, String email, String entreprise, String commentaire){
        this.id = new SimpleIntegerProperty(id_client);
        this.entreprise = new SimpleStringProperty(entreprise);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.adresse1 = new SimpleStringProperty(adresse1);
        this.adresse2 = new SimpleStringProperty(adresse2);
        this.NPA = new SimpleStringProperty(NPA);
        this.ville = new SimpleStringProperty(ville);
        this.telephone1 = new SimpleStringProperty(telephone1);
        this.telephone2 = new SimpleStringProperty(telephone2);
        this.email = new SimpleStringProperty(email);
        this.commentaire = new SimpleStringProperty(commentaire);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id.get();
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id.set(id);
    }

    /**
     * @return the entreprise
     */
    public String getEntreprise() {
        return entreprise.get();
    }

    public StringProperty entrepriseProperty(){
        return entreprise;
    }
    
    /**
     * @param entreprise the entreprise to set
     */
    public void setEntreprise(String entreprise) {
        this.entreprise.set(entreprise);
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }
    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom.set(nom);
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty(){
        return prenom;
    }
    
    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    /**
     * @return the adresse1
     */
    public String getAdresse1() {
        return adresse1.get();
    }

    /**
     * @param adresse1 the adresse1 to set
     */
    public void setAdresse1(String adresse1) {
        this.adresse1.set(adresse1);
    }

    /**
     * @return the adresse2
     */
    public String getAdresse2() {
        return adresse2.get();
    }

    /**
     * @param adresse2 the adresse2 to set
     */
    public void setAdresse2(String adresse2) {
        this.adresse2.set(adresse2);
    }

    /**
     * @return the NPA
     */
    public String getNPA() {
        return NPA.get();
    }

    /**
     * @param NPA the NPA to set
     */
    public void setNPA(String NPA) {
        this.NPA.set(NPA);
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville.get();
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville.set(ville);
    }

    /**
     * @return the telephone1
     */
    public String getTelephone1() {
        return telephone1.get();
    }

    /**
     * @param telephone1 the telephone1 to set
     */
    public void setTelephone1(String telephone1) {
        this.telephone1.set(telephone1);
    }

    /**
     * @return the telephone2
     */
    public String getTelephone2() {
        return telephone2.get();
    }

    /**
     * @param telephone2 the telephone2 to set
     */
    public void setTelephone2(String telephone2) {
        this.telephone2.set(telephone2);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email.set(email);
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
    
    @Override
    public String toString(){
        String rez = "Client n°"+this.getId()+"\n";
            rez     += " nom "+this.getNom()+"\n";
            rez     += " prenom "+this.getPrenom()+"\n";
            rez     += " entreprise "+this.getEntreprise()+"\n";
            rez     += " adresse1 "+this.getAdresse1()+"\n";
            rez     += " adresse2 "+this.getAdresse2()+"\n";
            rez     += " ville "+this.getVille()+"\n";
            rez     += " npa "+this.getNPA()+"\n";
            rez     += " telephone1 "+this.getTelephone1()+"\n";
            rez     += " telephone2 "+this.getTelephone2()+"\n";
            rez     += " email "+this.getEmail()+"\n";
            rez     += " commentaire "+this.getCommentaire()+"\n";
               
        return rez;
    }
}
