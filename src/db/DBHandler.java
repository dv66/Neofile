package db;

import model.Patient;
import sample.Constants;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.sql.*;

public class DBHandler {
    public static void main(String[] args) throws SQLException,IOException {
//        showDatabase(Constants.TABLE_PATIENTS);

//        Patient patient = new Patient("", "dipto","12-12-12","qwer","qwer","qwer","qwer","qwer","qwer","qwer","qwer","qwer","qwer");
//        insertPatient(patient);

        Patient patient = getRow("30");
        System.out.println(patient.getProfilePic());


    }


    public static void showDatabase(String dbname) throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost",
                Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + dbname);

        while (resultSet.next()) {
            String id = resultSet.getString(Constants.COLUMN_ID);
            String name = resultSet.getString(Constants.COLUMN_NAME);
            String birthday = resultSet.getString(Constants.COLUMN_BIRTHDAY);
            String sex = resultSet.getString(Constants.COLUMN_SEX);
            String height = resultSet.getString(Constants.COLUMN_HEIGHT);
            String weight = resultSet.getString(Constants.COLUMN_WEIGHT);
            String occupation = resultSet.getString(Constants.COLUMN_OCCUPATION);
            String country = resultSet.getString(Constants.COLUMN_COUNTRY);
            String city = resultSet.getString(Constants.COLUMN_CITY);
            String zipcode = resultSet.getString(Constants.COLUMN_ZIPCODE);
            String contactNumber = resultSet.getString(Constants.COLUMN_CONTACT_NO);
            String email = resultSet.getString(Constants.COLUMN_EMAIL);
            String profilePic = resultSet.getString(Constants.COLUMN_PROFILE_PIC);

            Patient patient = new Patient(id, name, birthday, sex, height, weight,
                    occupation, country, city, zipcode, contactNumber, email, profilePic);

            System.out.println(patient);
        }

        connection.close();

    }
















    public static void insertPatient(Patient patient) throws SQLException, IOException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost",
                Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);

        PreparedStatement statement = connection.prepareStatement(
                "insert into neofile.patients (name, birthday, sex, " +
                "height, weight, occupation, country, city, zipcode, contact_no, " +
                "email, profile_pic) values (?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ? )"
        );


        statement.setString(1, patient.getName());
        statement.setString(2, patient.getBirthday());
        statement.setString(3, patient.getSex());
        statement.setString(4, patient.getHeight());
        statement.setString(5, patient.getWeight());
        statement.setString(6, patient.getOccupation());
        statement.setString(7, patient.getCountry());
        statement.setString(8, patient.getCity());
        statement.setString(9, patient.getZipcode());
        statement.setString(10, patient.getContactNumber());
        statement.setString(11, patient.getEmail());

        File image = new File(patient.getProfilePic());


        InputStream inputStream = new FileInputStream(image);

        // insert the profile image to the PROFILE_PIC column of the patients TABLE
        statement.setBinaryStream(12, inputStream, (int) image.length());

        statement.executeUpdate();

        connection.close();

    }
















    public static Patient getRow(String patientId) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost",
                Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " +
                "" + Constants.TABLE_PATIENTS +  " WHERE ID = \'" + patientId + "\'");

        Patient selectedPatient = null;
        while (resultSet.next()) {
            String id = resultSet.getString(Constants.COLUMN_ID);
            String name = resultSet.getString(Constants.COLUMN_NAME);
            String birthday = resultSet.getString(Constants.COLUMN_BIRTHDAY);
            String sex = resultSet.getString(Constants.COLUMN_SEX);
            String height = resultSet.getString(Constants.COLUMN_HEIGHT);
            String weight = resultSet.getString(Constants.COLUMN_WEIGHT);
            String occupation = resultSet.getString(Constants.COLUMN_OCCUPATION);
            String country = resultSet.getString(Constants.COLUMN_COUNTRY);
            String city = resultSet.getString(Constants.COLUMN_CITY);
            String zipcode = resultSet.getString(Constants.COLUMN_ZIPCODE);
            String contactNumber = resultSet.getString(Constants.COLUMN_CONTACT_NO);
            String email = resultSet.getString(Constants.COLUMN_EMAIL);



            // writing image to a file
            InputStream fileInputStream = resultSet.getBinaryStream(Constants.COLUMN_PROFILE_PIC);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);

            File profilePic = new File(Constants.TMP_LOCATION + id + Constants.PICTURE_FORMAT);
            OutputStream outputStream = new FileOutputStream(profilePic);
            outputStream.write(bytes);

            outputStream.close();
            fileInputStream.close();

            String picLocation = Constants.TMP_LOCATION + id + Constants.PICTURE_FORMAT;

            Patient patient = new Patient(id, name, birthday, sex, height, weight,
                    occupation, country, city, zipcode, contactNumber, email, picLocation);

            selectedPatient = patient;

        }

        connection.close();
        return  selectedPatient;
    }




}
