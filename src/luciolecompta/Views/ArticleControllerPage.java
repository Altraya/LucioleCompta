/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import luciolecompta.MainApp;

/**
 * FXML Controller class
 *
 * @author Karakayn
 */
public class ArticleControllerPage implements Initializable {
    
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
