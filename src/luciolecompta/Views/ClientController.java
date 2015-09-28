/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Views;

import java.util.ArrayList;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import luciolecompta.MainApp;
import luciolecompta.MainApp;
import luciolecompta.Models.Client;
import luciolecompta.Models.ClientManager;

/**
 * JavaFX nous oblige à mettre les controllers dans le même package que les
 * views en fxml
 *
 * @author Karakayn
 */
public class ClientController {

    /**
     * List property who contain all value of Client property except id
     */
    ListProperty<String> listProperty = new SimpleListProperty<String>(FXCollections.<String>observableArrayList());

    /**
     * Contain primary informations about client who is display on tableview => nom prenom entreprise
     */
    @FXML
    private TableView<Client> informationsClients;
    @FXML
    private TableColumn<Client, String> nomClientColumn;
    @FXML
    private TableColumn<Client, String> prenomClientColumn;
    @FXML
    private TableColumn<Client, String> entrepriseClientColumn;

    /**
     * All field on the right of the interface
     */
    @FXML
    private TextField idField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField adresse1Field;
    @FXML
    private TextField adresse2Field;
    @FXML
    private TextField NPAField;
    @FXML
    private TextField villeField;
    @FXML
    private TextField telephone1Field;
    @FXML
    private TextField telephone2Field;
    @FXML
    private TextField emailField;
    @FXML
    private TextField commentaireField;
    @FXML
    private TextField entrepriseField;

    // Reference to the main application.
    private MainApp mainApp;
    // Reference to the client manager
    private ClientManager clientManager;

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public ClientController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        nomClientColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prenomClientColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        entrepriseClientColumn.setCellValueFactory(cellData -> cellData.getValue().entrepriseProperty());

        // Clear person details.
        showClientsDetails(null);

        // Listen for selection changes and show the person details when changed.
        informationsClients.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showClientsDetails(newValue));
        
    }

    /**
     * Fills all text fields to show details about the person. If the specified
     * person is null, all text fields are cleared.
     *
     * @param client the person or null
     */
    public void showClientsDetails(Client client) {
        
        if (client != null) {
            
            //System.out.println("Dans Show Client details de addclientcontroller");
            //System.out.println(client.toString());
            // Fill the labels with info from the client object.
            idField.setText(Integer.toString(client.getId()));
            nomField.setText(client.getNom());
            prenomField.setText(client.getPrenom());
            adresse1Field.setText(client.getAdresse1());
            adresse2Field.setText(client.getAdresse2());
            NPAField.setText(client.getNPA());
            villeField.setText(client.getVille());
            telephone1Field.setText(client.getTelephone1());
            telephone2Field.setText(client.getTelephone2());
            emailField.setText(client.getEmail());
            commentaireField.setText(client.getCommentaire());
            entrepriseField.setText(client.getEntreprise());

        } else {
            // Person is null, remove all the text.
            idField.setText("");
            nomField.setText("");
            prenomField.setText("");
            adresse1Field.setText("");
            adresse2Field.setText("");
            NPAField.setText("");
            villeField.setText("");
            telephone1Field.setText("");
            telephone2Field.setText("");
            emailField.setText("");
            commentaireField.setText("");
            entrepriseField.setText("");

        }
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     * @param clientManager
     */
    public void setMainApp(MainApp mainApp, ClientManager clientManager) {
        this.mainApp = mainApp;
        this.clientManager = clientManager;

        // Add observable list data to the table
        ObservableList<Client> test;
        test = clientManager.getClientData();
        //System.out.println("Dans Set main app : test = "+test);
        informationsClients.setItems(clientManager.getClientData());

    }

    /**
     * Called when the user clicks the new button. Open dialog to set attribute for the new client
     */
    @FXML
    private void handleNewClient() {
        
        boolean okClicked = mainApp.showNewClient();
        if (okClicked) {
            //refresh the list / select all in DB
            informationsClients.setItems(clientManager.getClientData());
        }
    }

    @FXML
    private void handleUpdateClient(){
        System.out.println("Handle update client");
        
        //The DB action to add client
        ClientManager cm = new ClientManager();
        
        //create new client with updated informations
        Client client = new Client(Integer.getInteger(idField.getText()), nomField.getText(), prenomField.getText(), adresse1Field.getText(), adresse2Field.getText(), villeField.getText(), NPAField.getText(), telephone1Field.getText(), telephone2Field.getText(), emailField.getText(), entrepriseField.getText(), commentaireField.getText());
        System.out.println("Updateuh");
        System.out.println(client.toString());
        //update client in database
        cm.updateClient(client);
        
        //refresh the list / select all in DB
        informationsClients.setItems(clientManager.getClientData());

    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        //remove the client from the view
        int selectedIndex = informationsClients.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            //remove the client from the database
            ClientManager cManager = new ClientManager();
            cManager.deleteClient(informationsClients.getSelectionModel().getSelectedItem().getId());
            informationsClients.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Erreur : Pas de selection");
            alert.setHeaderText("Aucun client n'a été selectionné");
            alert.setContentText("Veuillez selectionnez un client.");
            alert.showAndWait();
        }
    }
}
