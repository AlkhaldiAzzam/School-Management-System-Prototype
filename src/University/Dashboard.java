/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author a_3bd
 */
public class Dashboard  {

    public void start(Stage stage) throws Exception {

        University.readStudents();
        University.readFaculty();
        
        Label num_stu = new Label( University.number_Of_Students + "\nTotal Students");
        Label num_fac = new Label( University.number_Of_Faculty + "\nTotal Faculty Members");
        
        VBox root = new VBox ( num_stu, num_fac);
        Scene scene = new Scene (root, 500, 500);
        
        stage.setScene(scene);
        stage.show();
    
    }
    
    
}
