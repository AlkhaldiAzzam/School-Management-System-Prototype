/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import University.University;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author a_3bd
 */
public class HomeController implements Initializable {
    
    @FXML
    private Button db_btn;
    
    @FXML
    private Button stu_btn;
    
    @FXML
    private Button fac_btn;
    
    @FXML
    private Button cur_btn;
    
    @FXML
    private Button sec_btn;
    
    @FXML
    private Button set_btn;
    
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == db_btn) {
            loadStage("University/DBoard.fxml");
            System.out.println("Dashboard");
        } else if (mouseEvent.getSource() == stu_btn) {
            //loadStage("/home/fxml/Students.fxml");
            loadStage("University/Students.fxml");
            System.out.println("Dashboard");
        } else if (mouseEvent.getSource() == fac_btn) {
            loadStage("University/Faculty.fxml");
        }
    }

    //
    private void loadStage(String fxml) {
        try {
            
            URL url = new File("src/" + fxml).toURL();
            Parent root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            
            String title;
            
            switch (fxml) {
                case "University/DBoard.fxml":
                    title = "Dashboard";
                    break;
                case "University/Students.fxml":
                    title = "Students";
                    break;
                case "University/Faculty.fxml":
                    title = "Faculty";
                    break;
                default:
                    title = "X";
            }
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            University.readSections();
            University.readFaculty();
            University.readStudents();
        } catch (Exception ex) {
            System.out.println("Error in " + getClass().getName());
        }
    }    
    
}
