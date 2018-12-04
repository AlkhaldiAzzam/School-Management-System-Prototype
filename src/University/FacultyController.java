/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author a_3bd
 */
public class FacultyController implements Initializable {

    
    @FXML
    private JFXTextField searchField;

    ////
    
    
    
    
    @FXML
    void addAction(ActionEvent event) {
        
        try {
            URL url = new File("src/University/addFacultyWindow.fxml").toURL();
            Parent root = FXMLLoader.load(url);
            
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(((Stage) searchField.getScene().getWindow()));
                //VBox dialogVbox = new VBox(20);
                //dialogVbox.getChildren().add(new Text("This is a Dialog"));
                //Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(new Scene(root));
                dialog.show();
        } catch (Exception e) {
            
        }

    }
    
    
    
    ////
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
