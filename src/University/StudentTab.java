/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package University;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author a_3bd
 */
public class StudentTab {

    public void start(Stage stage) throws Exception {

        

        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(300);
        stage.setHeight(500);
 
        Label label = new Label("Address Book");
        //TableView table = new TableView();
        TableView <Student> table = new TableView <Student>();
        
        
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn midNameCol = new TableColumn("Middle Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn idCol = new TableColumn("ID");
        TableColumn majorCol = new TableColumn("Major");
        TableColumn advCol = new TableColumn("Advisor");
        
        table.getColumns().addAll(firstNameCol, midNameCol, lastNameCol, idCol, majorCol, advCol);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        
        University.readStudents();
        System.out.println(University.students[1]);
        ObservableList<Student> o = FXCollections.observableArrayList(University.students);
        table.setItems(o);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
        
    }
    

}
