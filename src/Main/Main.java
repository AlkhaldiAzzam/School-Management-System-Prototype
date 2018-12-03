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
        
        University.readStudents();
        University.readFaculty();
        
        //Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));

        URL url = new File("src/home.fxml").toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Ingenious Education Login");

    }

    /*
     public void start(Stage stage) throws Exception {

     Label ll = new Label("hh");
        
     MaterialIconView home_icon = new MaterialIconView(MaterialIcon.HOME);
     home_icon.setSize("40px");
        
     Button db = new Button("Dashboard");
     db.setGraphic(home_icon);
        
     db.setOnAction( e -> {
     Dashboard d = new Dashboard();
     try {
     d.start( new Stage() );
     } catch (Exception ex) {
     }
     });
        
     Button stu = new Button("Students");
     stu.setOnAction( e -> {
    
     StudentTab st = new StudentTab();
            
     try {
     st.start(new Stage());
     } catch (Exception ex) {
     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
     }
                    
     });
        
        
     Button fac = new Button("Faculty");
     HBox h1 = new HBox (db, stu, fac);
     h1.setSpacing(50);
     h1.setAlignment(Pos.CENTER);
        
     Button course = new Button("Courses");
     Button sec = new Button("Sections");
     Button set = new Button("Settings");
     HBox h2 = new HBox (course, sec, set);
     h2.setSpacing(50);
     h2.setAlignment(Pos.CENTER);
        
     VBox root = new VBox (h1, h2);
     root.setSpacing(50);
     root.setAlignment(Pos.CENTER);
        
     Scene scene = new Scene (root, 800, 700);
        
     stage.setScene(scene);
     stage.show();

     }

     */
}
