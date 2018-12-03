/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
        } else if (mouseEvent.getSource() == fac_btn) {
            //loadStage("/home/fxml/Timetable.fxml");
        }
}
    
    
    //
    
    private void loadStage(String fxml) {
        try {
            
        URL url = new File("src/"+ fxml).toURL();
        Parent root = FXMLLoader.load(url);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
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
        // TODO
    }    
    
}
