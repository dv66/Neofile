package controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
    public TextField weightText;

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


    private HashMap<String, String> phoneCodes;

    private ArrayList countries;











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




    private void loadImage(){
//        File file = new File(System.getProperty("user.dir") + "/resources/profile_pic.png");
//        System.out.println(file.getAbsolutePath());
//        Image image = new Image(file.getAbsolutePath());
//        profileImageView.setImage(image);
    }



    private void loadData() throws IOException{
        loadSex();
        loadHeights();
        loadCountries();
        loadImage();
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
    }
}
