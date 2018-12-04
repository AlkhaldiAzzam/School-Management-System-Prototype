package Main;

import University.*;
import de.jensd.fx.glyphs.materialicons.*;
import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main {

    public void start(Stage stage) throws Exception {

                University.readFaculty();
                University.readStudents();

        URL url = new File("src/home.fxml").toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        //stage.setTitle("Ingenious Education Login");
        stage.setTitle("Home");

    }

}
