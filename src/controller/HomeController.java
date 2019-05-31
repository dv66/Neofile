package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import org.omg.CORBA.PRIVATE_MEMBER;
import sample.Constants;
import sample.Main;
import utils.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {


    @FXML
    private ImageView addProfileImageView;

    @FXML
    private ImageView viewProfileImageView;

    @FXML
    private ImageView seeHistoryImageView;

    @FXML
    private ImageView filesImageView;

    @FXML
    private ImageView appointmentsImageView;

    @FXML
    private ImageView settingsImageView;

    @FXML
    private ImageView logo;

    @FXML
    private Pane addProfilePane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{

            loadImage(addProfileImageView, Constants.ADD_PROFILE_PIC_HOME);
            loadImage(viewProfileImageView, Constants.VIEW_PROFILE_PIC_HOME);
            loadImage(seeHistoryImageView, Constants.HISTORY_PIC_HOME);
            loadImage(filesImageView, Constants.FOLDER_PIC_HOME);
            loadImage(appointmentsImageView, Constants.IMAGES_PIC_HOME);
            loadImage(settingsImageView, Constants.SETTINGS_PIC_HOME);
            loadImage(logo, Constants.LOGO_PIC_HOME);

            addProfilePane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    try {
                        new Utilities().changeScene(Constants.PROFILING_SCENE, Main.getStage());
                    }catch (IOException e){ e.printStackTrace();}
                }
            });


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadImage(ImageView imageView, String piclocation) throws FileNotFoundException {
        FileInputStream fStream = new FileInputStream(piclocation);
        Image image = new Image(fStream);
        imageView.setImage(image);
    }

}
