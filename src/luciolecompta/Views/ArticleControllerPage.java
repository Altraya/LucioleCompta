/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Views;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import luciolecompta.MainApp;
import luciolecompta.Models.Article;
import luciolecompta.Models.ArticleManager;

/**
 * FXML Controller class
 *
 * @author Karakayn
 */
public class ArticleControllerPage {
    
    // Reference to the main application.
    private MainApp mainApp;
    
    private ArticleManager articleManager;
    
    /**
     * Contain primary informations about client who is display on tableview => nom prenom entreprise
     */
    @FXML
    private TableView<Article> informationsArticles;
    @FXML
    private TableColumn<Article, Integer> idArticleColumn;
    @FXML
    private TableColumn<Article, String> nomArticleColumn;
    @FXML
    private TableColumn<Article, Float> prixArticleColumn;
    @FXML
    private TableColumn<Article, Integer> maxEnStock;
    @FXML
    private TableColumn<Article, String> categorieArticleColumn;

     /**
     * All field on the right of the interface
     */
    @FXML
    private TextField idField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField prixField;
    @FXML
    private TextField maxEnStockField;
    @FXML
    private TextField categorieField;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        idArticleColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nomArticleColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prixArticleColumn.setCellValueFactory(cellData -> cellData.getValue().prixProperty().asObject());
        maxEnStock.setCellValueFactory(cellData -> cellData.getValue().maxEnStockProperty().asObject());
        categorieArticleColumn.setCellValueFactory(cellData -> cellData.getValue().categorieProperty());
    
        // Listen for selection changes and show the person details when changed.
        informationsArticles.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showArticleDetails(newValue));
    }    
    
     /**
     * Fills all text fields to show details about the article. If the specified
     * article is null, all text fields are cleared.
     *
     * @param article the article or null
     */
    public void showArticleDetails(Article article){
        if(article != null){
            
        }else{
            idField.setText("");
            nomField.setText("");
            prixField.setText("");
            maxEnStockField.setText("");
            categorieField.setText("");
        }
    }
    
    /**
     * Called when the user clicks the new button. Open dialog to set attribute for the new article
     */
    @FXML
    private void handleNewArticle() {
        
        boolean okClicked = mainApp.showNewArticle();
        if (okClicked) {
            //refresh the list / select all in DB
            informationsArticles.setItems(articleManager.getClientData());
        }
    }

    @FXML
    private void handleUpdateArticle(){
        System.out.println("Handle update article");
        
        //The DB action to add article
        ArticleManager am = new ArticleManager();
        
        System.out.println("Id field : " + idField.getText());
        System.out.println("Id field text : "+idField.getText());
        int id = Integer.parseInt(idField.getText());
        System.out.println("id : "+id);
        System.out.println("Nom field : " + nomField.getText());
        
        //create new article with updated informations
        Article article = new Article(Integer.parseInt(idField.getText()), nomField.getText(), Float.parseFloat(prixField.getText()), Integer.parseInt(maxEnStockField.getText()), categorieField.getText());
        System.out.println("Updateuh article");
        System.out.println(article.toString());
        //update article in database
        am.updateArticle(article);
        
        //refresh the list / select all in DB
        informationsArticles.setItems(am.getClientData());

    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteArticle() {
        //remove the client from the view
        int selectedIndex = informationsArticles.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            //remove the article from the database
            ArticleManager aManager = new ArticleManager();
            aManager.deleteArticle(informationsArticles.getSelectionModel().getSelectedItem().getId());
            informationsArticles.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Erreur : Pas de selection");
            alert.setHeaderText("Aucun article n'a été selectionné");
            alert.setContentText("Veuillez selectionnez un article.");
            alert.showAndWait();
        }
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
    */
    public void setMainApp(MainApp mainApp, ArticleManager articleManager) {
        System.out.println("Set main app");
        this.mainApp = mainApp;
        this.articleManager = articleManager;
        // Add observable list data to the table
        ObservableList<Article> test;
        test = articleManager.getClientData();
        //System.out.println("Dans Set main app : test = "+test);
        informationsArticles.setItems(articleManager.getClientData());
    }
    
    /**
     * Called when the user click on the "Revenir au menu" button
     */
    public void handleReturnToMenu(){
        this.mainApp.showAccueil();
    }
}
