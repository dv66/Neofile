package sample;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.stage.StageStyle;
import utils.Utilities;

public class Main extends Application {


    @FXML
    private Pane root;




    private static Stage stage;
    
    private double xOffset = 0;
    private double yOffset = 0;


    @Override
    public void start(Stage primaryStage) throws Exception{
        setStage(primaryStage);

        primaryStage.initStyle(StageStyle.UNDECORATED);
//        new Utilities().changeScene(Constants.TEST_SCENE, stage);
//        new Utilities().changeScene(Constants.HOME_SCENE, stage);
        Parent parent = FXMLLoader.load(getClass().getResource(Constants.HOME_SCENE));
        primaryStage.setTitle(Constants.APPLICATION_NAME);
        primaryStage.setScene(new Scene(parent, Constants.DEFAULT_WIDTH, Constants.DEFAULT_HEIGHT));

        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });



        primaryStage.show();

    }


    public static void main(String[] args) throws SQLException {

        launch(args);

    }



    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

}
