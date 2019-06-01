package controller;
import db.DBHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import model.Patient;
import sample.Constants;
import utils.Utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    public ChoiceBox sexChoiceBox;

    @FXML
    public TextField nameText;

    @FXML
    public TextField contactText;

    @FXML
    public TextField zipText;

    @FXML
    public TextField emailText;

    @FXML
    public TextField cityText;

    @FXML
    public TextField weightText;

    @FXML
    public TextField occupationText;

    @FXML
    public ChoiceBox countryChoiceBox;

    @FXML
    public DatePicker dateOfBirth;

    @FXML
    public ChoiceBox feetChoiceBox;

    @FXML
    public ChoiceBox inchChoiceBox;

    @FXML
    public ImageView profileImageView;

    @FXML
    public Button saveButton;


    private HashMap<String, String> phoneCodes;

    private ArrayList countries;

    private String profilePictureLocation;











    private void loadSex(){
        String sex[] = {"Male", "Female", "Others"};
        sexChoiceBox.getItems().addAll(FXCollections.observableArrayList(sex));
    }




    private void loadCountries() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(Constants.COUNTRY_DATA_LOCATION)));
        countries = new ArrayList();
        phoneCodes = new HashMap<>();

        String s;

        while((s = reader.readLine()) != null) {
            String[] countryCodes = s.split("---");
            countries.add(countryCodes[1]);
            phoneCodes.put(countryCodes[1], countryCodes[0]);
        }
        reader.close();
        countryChoiceBox.getItems().addAll(countries);
    }









    private void loadHeights(){
        ArrayList feet = new ArrayList();
        ArrayList inch = new ArrayList();

        for(int i = 6; i >= 1; i--){
            feet.add(Integer.toString(i) + " ft ");
        }

        for(int j = 11; j >=0 ; j--){
            inch.add(Integer.toString(j) + " in.");
        }

        feetChoiceBox.getItems().addAll(feet);
        inchChoiceBox.getItems().addAll(inch);
    }









    private void loadImage() throws FileNotFoundException{
        FileInputStream fStream = new FileInputStream(Constants.DEFAULT_PROFILE_PIC_LOCATION);
        Image image = new Image(fStream);
        profileImageView.setImage(image);
    }










    private void loadData() throws IOException, FileNotFoundException{
        loadSex();
        loadHeights();
        loadCountries();
        loadImage();
    }





    public void savePatientProfile(ActionEvent event) throws IOException, SQLException {
        Patient patient = new Patient();

        patient.setName(nameText.getText());
        patient.setBirthday(dateOfBirth.getValue().toString());
        patient.setSex((String) sexChoiceBox.getValue());
        patient.setHeight((String) feetChoiceBox.getValue() + "-" + (String) inchChoiceBox.getValue());
        patient.setWeight(weightText.getText());
        patient.setOccupation(occupationText.getText());
        patient.setCountry((String) countryChoiceBox.getValue());
        patient.setCity(cityText.getText());
        patient.setZipcode(zipText.getText());
        patient.setContactNumber(contactText.getText());
        patient.setEmail(emailText.getText());
        patient.setProfilePic(profilePictureLocation);

        DBHandler.insertPatient(patient);
    }




    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        try {
            loadData();

        }catch (IOException e){
            e.printStackTrace();
        }

        countryChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                String selectedCountry = (String)countryChoiceBox.getItems().get((Integer) number2);
                contactText.setText("+" + phoneCodes.get(selectedCountry));
            }
        });

        profileImageView.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose Photo");
                File file = fileChooser.showOpenDialog(profileImageView.getScene().getWindow());
                if (file != null) {
                    profilePictureLocation = file.toURI().toString();
                    profileImageView.setImage(new Image(profilePictureLocation));
                    profilePictureLocation = profilePictureLocation.substring(5);
                }
            }
        });
    }
}
