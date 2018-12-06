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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author a_3bd
 */
public class SectionsController implements Initializable {

    
    
    
    @FXML
    private TableView<Section> secTable;

    @FXML
    private TableColumn<Section, String> name;

    @FXML
    private TableColumn<Section, Integer> number;

    @FXML
    private TableColumn<Section, String> crn;

    @FXML
    private TableColumn<Section, String> instructor;

    @FXML
    private TableColumn<Section, String> location;

    @FXML
    private TableColumn<Section, String> status;

    @FXML
    private JFXTextField searchField;

    ////
    @FXML
    void addAction(ActionEvent event) {

        try {
            URL url = new File("src/University/addSectionWindow.fxml").toURL();
            Parent root = FXMLLoader.load(url);

            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(((Stage) searchField.getScene().getWindow()));
            dialog.setScene(new Scene(root));
                    dialog.getIcons().add(new Image ("file:data/img/icon.png"));
            dialog.show();
        } catch (Exception e) {
        }
    }

    @FXML
    void refreshAction(ActionEvent event) {

        try {

            if (AddSectionWindowController.added) {
                secTable.getItems().add(University.sections.get(University.sections.size() - 1));
            }
        } catch (Exception e) {

        }

    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // set up the columns:
        name.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        crn.setCellValueFactory(new PropertyValueFactory<>("CRN"));
        instructor.setCellValueFactory(new PropertyValueFactory<>("instructorID"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));     //P

        /*
        status.setCellFactory( new Callback<CellDataFeatures<Faculty, String>, ObservableValue<String>>() {
            
            public ObservableValue<String> call (CellDataFeatures<Faculty, String> fff) {
                return new ObservableValue<String>();
                //fff.getValue().getFullName();
            }
        }); */
        // load data
        secTable.setItems(getSections());    
    }
    
    
    
    public ObservableList<Section> getSections() {

        ObservableList<Section> s = FXCollections.observableArrayList();

        for (Section sec : University.sections) {

            if (!secTable.getItems().contains(sec)) {
                s.add(sec);
            }
        }

        return s;
    }

}
