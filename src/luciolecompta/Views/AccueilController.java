/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Views;

import javafx.fxml.FXML;
import luciolecompta.MainApp;

/**
 *
 * @author Karakayn
 */
public class AccueilController {
    
    // Reference to the main application.
    private MainApp mainApp;
    
    public AccueilController(){
        
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        
        
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
    
    /**
     * Called when the user clicks the new button. Open dialog to show client
     */
    @FXML
    private void handleShowClient() {        
        mainApp.showClient();
    }
}
