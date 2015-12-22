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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import luciolecompta.Models.Article;
import luciolecompta.Models.ArticleManager;
import luciolecompta.Models.ClientManager;

/**
 * FXML Controller class
 *
 * @author Karakayn
 */
public class AddArticleController implements Initializable {

    @FXML
    private TextField nomFieldAddArticle;
    @FXML
    private TextField prixFieldAddArticle;
    @FXML
    private TextField nbMaxStockFieldAddArticle;
    @FXML
    private TextField categorieFieldAddArticle;

    private Stage dialogStage;
    private Article article;
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
     * Sets the article to be edited in the dialog.
     *
     * @param article : The article who will be set
     */
    public void setArticle(Article article) {
        System.out.println("Passe dans set article");
        this.article = article;
        
        article.setNom(nomFieldAddArticle.getText());
        article.setPrix(Float.parseFloat(prixFieldAddArticle.getText()));
        article.setMaxEnStock(Integer.parseInt(nbMaxStockFieldAddArticle.getText()));
        article.setCategorie(categorieFieldAddArticle.getText());

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
            int id = cm.getMaxId("ARTICLE") + 1;
            Article article = new Article(id); //a a new empty article with the good id)
            this.setArticle(article);
            ArticleManager am = new ArticleManager();
            am.addArticle(article);
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
