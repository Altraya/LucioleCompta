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
import luciolecompta.Models.Client;
import luciolecompta.Models.ClientManager;
import luciolecompta.Models.FactureManager;
import luciolecompta.Views.AccueilController;

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
        //showClient();
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
        /*try {
            System.out.println("Show Accueil ? ");
            // Load l'interieur de la fenetre
            FXMLLoader loader1 = new FXMLLoader();
            System.out.println("- Après FXML Loader -");
            loader1.setLocation(MainApp.class.getResource("Views/Accueil.fxml"));
            System.out.println("- Après le set location du loader -");
            /*
            AnchorPane accueilOverview = (AnchorPane) loader.load();
        
            // Set person overview into the center of root layout.
            getRootLayout().setCenter(accueilOverview);
            System.out.println("- Avant le load du controller -");
            // Give the controller access to the main app.
            AccueilController aController = loader1.getController();
            System.out.println("- Loader du controller -");
            aController.setMainApp(this);
            System.out.println("- Set main app fait ! -");
        /*} catch (IOException e) {
            e.printStackTrace();
        }*/
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
