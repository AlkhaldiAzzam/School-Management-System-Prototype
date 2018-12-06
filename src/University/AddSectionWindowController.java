/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author a_3bd
 */
public class AddSectionWindowController implements Initializable {

    public static boolean added = false;
    //     public Section(int number, String courseName, String CRN, String instructorID, String location, int max) 

    @FXML
    private JFXTextField courseNameField;

    @FXML
    private JFXTextField locationField;

    @FXML
    private JFXTextField maxNumberField;

    @FXML
    private Label msgLabel;


    @FXML
    void addAction(ActionEvent event) {

        added = false;
        if (courseNameField.getText().isEmpty() || locationField.getText().isEmpty() || maxNumberField.getText().isEmpty()) {
            msgLabel.setVisible(true);
        } else {
            msgLabel.setVisible(false);

            int n = Integer.parseInt(maxNumberField.getText());
            Section sec = new Section ( courseNameField.getText(), locationField.getText(), n );
            added = true;
                      
            ((Stage) msgLabel.getScene().getWindow()).close();

        try {
            University.readSections();
        } catch (Exception e) {
        }
        }
    }

    
    @FXML
    void cancelAction(ActionEvent event) {

        ((Stage) msgLabel.getScene().getWindow()).close();

    }

    //
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msgLabel.setVisible(false);
    }

}
