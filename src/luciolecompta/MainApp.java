/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta;

import luciolecompta.Views.AddClientController;
import luciolecompta.Views.ClientControllerPage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import luciolecompta.Models.ArticleManager;
import luciolecompta.Models.Client;
import luciolecompta.Models.ClientManager;
import luciolecompta.Models.FactureManager;
import luciolecompta.Views.AccueilController;
import luciolecompta.Views.AddArticleController;
import luciolecompta.Views.ArticleControllerPage;
import luciolecompta.Views.FactureControllerPage;

/**
 * Controler principal
 *
 * @author Karakayn
 */
public class MainApp extends Application {

    private Stage primaryStage;
    protected BorderPane rootLayout;
    private ObservableList<Client> clientData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.getPrimaryStage().setTitle("Luciole Compta");

        initRootLayout();
        showAccueil();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Loader
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Views/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //scene = avec le menu en haut
            Scene scene = new Scene(getRootLayout());
            getPrimaryStage().setScene(scene);
            getPrimaryStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Contenu de la fenetre a l'interieur du root layout -> Accueil
     */
    public void showAccueil() {

        // Load l'interieur de la fenetre
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Views/Accueil.fxml"));
        try {
            AnchorPane accueilOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(accueilOverview);

            // Give the controller access to the main app.
            AccueilController controller = loader.getController();
            
            controller.setMainApp(this);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fenêtre correspondant aux articles
     */
    public void showArticle() {
        // Load l'interieur de la fenetre
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Views/Article.fxml"));
        try {
            AnchorPane articleOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(articleOverview);

            // Give the controller access to the main app.
            ArticleControllerPage controller = loader.getController();
            ArticleManager articleManager = new ArticleManager();
            controller.setMainApp(this, articleManager);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showFacture() {
        // Load l'interieur de la fenetre
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Views/Facture.fxml"));
        try {
            AnchorPane factureOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(factureOverview);

            // Give the controller access to the main app.
            FactureControllerPage controller = loader.getController();
            
            controller.setMainApp(this);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fenetre correspondant aux clients
     */
    public void showClient() {
        // Load l'interieur de la fenetre
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("Views/Client.fxml"));
        try {
            AnchorPane clientOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(clientOverview);

            // Give the controller access to the main app.
            ClientControllerPage controller = loader.getController();

            //Manager to get client data
            ClientManager clientManager = new ClientManager();
            
            controller.setMainApp(this, clientManager);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * @param client the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showNewClient() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Views/AddClient.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouveau client");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AddClientController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            System.out.println("Load du controler");
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
        /**
     * Opens a dialog to edit details for the specified article. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showNewArticle() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Views/AddArticle.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nouveau article");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the article into the controller.
            AddArticleController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            System.out.println("Load du controler");
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return the rootLayout
     */
    public BorderPane getRootLayout() {
        return rootLayout;
    }

}
