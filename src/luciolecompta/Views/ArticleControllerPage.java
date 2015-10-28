/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import luciolecompta.MainApp;
import luciolecompta.Models.Article;

/**
 * FXML Controller class
 *
 * @author Karakayn
 */
public class ArticleControllerPage {
    
    // Reference to the main application.
    private MainApp mainApp;
    
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
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
    */
    public void setMainApp(MainApp mainApp) {
        System.out.println("Set main app");
        this.mainApp = mainApp;
    }
}
