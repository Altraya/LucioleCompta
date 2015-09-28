/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import luciolecompta.Models.Client;
import luciolecompta.Models.ClientManager;

/**
 * FXML Controller class
 *
 * @author Karakayn
 */
public class AddClientController implements Initializable {

    @FXML
    private TextField nomFieldAdd;
    @FXML
    private TextField prenomFieldAdd;
    @FXML
    private TextField adresse1FieldAdd;
    @FXML
    private TextField adresse2FieldAdd;
    @FXML
    private TextField NPAFieldAdd;
    @FXML
    private TextField villeFieldAdd;
    @FXML
    private TextField telephone1FieldAdd;
    @FXML
    private TextField telephone2FieldAdd;
    @FXML
    private TextField emailFieldAdd;
    @FXML
    private TextArea commentaireFieldAdd;
    @FXML
    private TextField entrepriseFieldAdd;

    private Stage dialogStage;
    private Client client;
    private boolean okClicked = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog. The client who will be added
     *
     * @param client
     */
    public void setClient(Client client) {
        System.out.println("Passe dans set client");
        this.client = client;

        //System.out.println(client.toString());
        
        client.setPrenom(prenomFieldAdd.getText());
        client.setNom(nomFieldAdd.getText());
        client.setAdresse1(adresse1FieldAdd.getText());
        client.setAdresse2(adresse2FieldAdd.getText());
        client.setVille(villeFieldAdd.getText());
        client.setNPA(NPAFieldAdd.getText());
        client.setTelephone1(telephone1FieldAdd.getText());
        client.setTelephone2(telephone2FieldAdd.getText());
        client.setEmail(emailFieldAdd.getText());
        client.setCommentaire(commentaireFieldAdd.getText());
        client.setEntreprise(entrepriseFieldAdd.getText());

    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            //The DB action to add client
            ClientManager cm = new ClientManager();
            int id = cm.getMaxId("CLIENT") + 1;
            Client client = new Client(id); //a a new empty client with the good id
            //System.out.println("Client crée avec l'id "+id);
            this.setClient(client);
            cm.addClient(client);
            //System.out.println("Dans handle ok");

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        //Some error message can be here, maybe later, but from now we could create an user with no information
        //maybe just check all criteria?

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Champ invalide");
            alert.setHeaderText("Veuillez entrer une information valide");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
