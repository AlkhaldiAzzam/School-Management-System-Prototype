

package Main;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class controller extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        
        URL url = new File("src/Login/loginX.fxml").toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Ingenious Education Login");
        
        
        //Login.Login ll = new Login.Login();
        
        //ll.start(stage);
        
        
    
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
