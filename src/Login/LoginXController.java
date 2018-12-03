/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author a_3bd
 */
public class LoginXController implements Initializable {

    @FXML
    private Label wrong;

    @FXML
    private JFXTextField userNameField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    void handleCancelButtonAction(ActionEvent event) {

    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) {

        String name = userNameField.getText();
        String pass = passwordField.getText();

        try {
            if (loginValidation(name, pass)) {
                wrong.setVisible(false);
                System.out.println("Logged In . . .");
                closeStage();
                loadMain();

            } else {
                wrong.setVisible(true);
            }
        } catch (Exception ex) {

        }

    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    private final static File loginFile = new File("data/login.txt");

    public static boolean loginValidation(String name, String pass) throws Exception {
        Scanner fscn = new Scanner(loginFile);

        while (fscn.hasNextLine()) {

            String nameFile = fscn.nextLine();

            if (name.equals(nameFile)) {
                String passFile = fscn.nextLine();
                return (passFile.equals(pass));
            }
            fscn.nextLine();
        }
        fscn.close();

        return false;
    }

    /////////////////////
    private void closeStage() {
        ((Stage) wrong.getScene().getWindow()).close();
    }

    void loadMain() {
        try {
            //Parent parent = FXMLLoader.load(getClass().getResource("/library/assistant/ui/main/main.fxml"));
            Main.Main m = new Main.Main();

            Stage stage = new Stage(StageStyle.DECORATED);
            //stage.setTitle("Ingenious Education");
            //stage.setTitle("Home");

            m.start(stage);

        } catch (Exception ex) {
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        wrong.setVisible(false);
    }

}
