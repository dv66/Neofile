package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Constants;

import java.io.IOException;

public class Utilities {
    public void changeScene(String fxmlFileName, Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
        primaryStage.setTitle(Constants.APPLICATION_NAME);
        primaryStage.setScene(new Scene(root, Constants.DEFAULT_WIDTH, Constants.DEFAULT_HEIGHT));
        primaryStage.show();
    }
}
