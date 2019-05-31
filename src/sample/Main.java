package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import utils.Utilities;

public class Main extends Application {


    private static Stage stage;



    @Override
    public void start(Stage primaryStage) throws Exception{
        setStage(primaryStage);
//        new Utilities().changeScene(Constants.PROFILING_SCENE, stage);
        new Utilities().changeScene(Constants.HOME_SCENE, stage);
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
