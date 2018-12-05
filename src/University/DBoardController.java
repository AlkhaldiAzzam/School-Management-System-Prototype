/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author a_3bd
 */
public class DBoardController implements Initializable {

    @FXML
    private Label numOfStu;

    @FXML
    private Label numOfFac;
    
    @FXML
    private Label numOfSec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        numOfStu.setText(University.number_Of_Students + "");
        //numOfStu.setText(University.students.size() + "");
        numOfFac.setText(University.number_Of_Faculty + "");
        //numOfFac.setText(University.faculty.size() + "");
        
        numOfSec.setText(University.number_Of_Sections + "");
        //numOfSec.setText(University.sections.size() + "");

    }

}
