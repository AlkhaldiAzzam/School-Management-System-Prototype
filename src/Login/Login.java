package Login;

import Main.Main;
import de.jensd.fx.glyphs.fontawesome.*;
import de.jensd.fx.glyphs.materialdesignicons.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login extends Application {
    
    /*

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

    Label label;
    
    */
    @Override
    public void start(Stage stage) throws Exception {

        /*
        label = new Label("LOGIN");
        label.setStyle("-fx-text-fill: #028040; -fx-font-size:70px");
        
        
        MaterialDesignIconView icon = new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT);
        icon.setSize("40px");
        icon.setStyle(    
"    -icons-color: #028040;\n" +
"    -fx-fill: linear-gradient(-icons-color 0%, \n" +
"        derive(-icons-color, 100%) 30%, derive(#028040, 30%) 85%); ");
        
        TextField unameF = new TextField();
        PasswordField passF = new PasswordField();

        unameF.setMinSize(350, 45);
        unameF.setMaxSize(350, 45);
        unameF.setStyle(" -fx-border-color: #028040; -fx-border width: 0, 0, 1, 0; -fx-background-color: transparent;"
                + "-fx-background-radius: 15px; -fx-border-radius: 15px;" );
        
        HBox hb1 = new HBox (icon, unameF);
        hb1.setSpacing(10);
        hb1.setAlignment(Pos.CENTER);
        
        MaterialDesignIconView icon2 = new MaterialDesignIconView(MaterialDesignIcon.KEY);
        icon2.setSize("40px");
        icon2.setStyle(    
"    -icons-color: #028040;\n" +
"    -fx-fill: linear-gradient(-icons-color 0%, \n" +
"        derive(-icons-color, 100%) 30%, derive(#028040, 30%) 85%); ");
        
        passF.setMinSize(350, 45);
        passF.setMaxSize(350, 45);
        passF.setStyle("  -fx-border-color: #028040; -fx-border width: 0, 0, 1, 0; -fx-background-color: transparent;"
                + "-fx-background-radius: 15px; -fx-border-radius: 15px;" );
        
        HBox hb2 = new HBox (icon2, passF);
        hb2.setSpacing(10);
        hb2.setAlignment(Pos.CENTER);
        
        
        
        
        
        Button login_btn = new Button("LOGIN");
        Button canl_btn = new Button("Cancel");
        Label wrong = new Label ("Wrong username or password.");

        login_btn.setMinSize(160, 45);
        login_btn.setMaxSize(160, 45);
        login_btn.setStyle("     -fx-background-color: #028040;\n"
                + "    -fx-background-radius: 6, 5;\n"
                + "    -fx-background-insets: 0, 1;\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n"
                + "    -fx-text-fill: #fff; -fx-font-size: 20px;"
                );

        canl_btn.setMinSize(160, 45);
        canl_btn.setMaxSize(160, 45);
        canl_btn.setStyle("     -fx-background-color: #028040;\n"
                + "    -fx-background-radius: 6, 5;\n"
                + "    -fx-background-insets: 0, 1;\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n"
                + "    -fx-text-fill: #fff; -fx-font-size: 20px ");
        
        
        
        login_btn.setOnAction( e -> { 
            
            String name = unameF.getText();
            String pass = passF.getText();
            
            try {
                if( loginValidation(name, pass) ) {
                    wrong.setVisible(false);
                    System.out.println("Logged In . . .");
                    closeStage();
                    loadMain();
                    
                }
                                        
                else
                    wrong.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        });
        
        canl_btn.setOnAction( e -> {
            System.exit(0);
        });

        HBox btns = new HBox(login_btn, canl_btn);
        btns.setAlignment(Pos.CENTER);
        btns.setSpacing(20);
        btns.setStyle("-fx-background-color: #fff");

        wrong.setStyle(" -fx-text-fill: red; -fx-font-size:18px ");
        wrong.setVisible(false);
        
        VBox root = new VBox(label, hb1, hb2, btns, wrong);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);
        root.setStyle("-fx-background-color: #fff");

        Scene scene = new Scene(root, 450, 500);

        stage.setScene(scene);
        stage.show();
*/
    }
    
    
    
    /*
    private void closeStage() {
        //((Stage) label.getScene().getWindow()).close();
    }

    void loadMain() {
        try {
            //Parent parent = FXMLLoader.load(getClass().getResource("/library/assistant/ui/main/main.fxml"));
            Main m = new Main();
            
            
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Ingenious Education");
            
                        m.start(stage);

            
        }
        catch (Exception ex) {
        }
    }
*/
}
