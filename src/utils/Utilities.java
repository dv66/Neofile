package utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Constants;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Utilities {
    public void changeScene(String fxmlFileName, Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
        primaryStage.setTitle(Constants.APPLICATION_NAME);
        primaryStage.setScene(new Scene(root, Constants.DEFAULT_WIDTH, Constants.DEFAULT_HEIGHT));
        primaryStage.show();
    }

//    public static String imageToString(ImageView image) throws IOException{
//        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image.getImage(), null);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ImageIO.write(bufferedImage, "png", outputStream);
//        byte[] imageByteArray  = outputStream.toByteArray();
//        outputStream.close();
//        return new String(imageByteArray).replace("\'", "\\\'");
//    }

}
