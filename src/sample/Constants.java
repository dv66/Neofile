package sample;

public interface Constants {
    public static final String APPLICATION_NAME= "Neofile";


    public static final int DEFAULT_WIDTH = 1062;
    public static final int DEFAULT_HEIGHT= 763;


    public static final String VIEW_LOCATION = "../view/";
    public static final String STARTING_SCENE = VIEW_LOCATION + "login.fxml";
    public static final String PROFILING_SCENE = VIEW_LOCATION + "profile.fxml";
    public static final String HOME_SCENE = VIEW_LOCATION + "home.fxml";


    public static final String COUNTRY_DATA_LOCATION = "src/data/countries.txt";




    /*
    * Icons files
    * */
    public static final String DEFAULT_PROFILE_PIC_LOCATION = "src/resources/profile_pic.png";
    public static final String ADD_PROFILE_PIC_HOME = "src/resources/add_profiles.png";
    public static final String VIEW_PROFILE_PIC_HOME = "src/resources/view_profiles.png";
    public static final String HISTORY_PIC_HOME = "src/resources/history.png";
    public static final String SETTINGS_PIC_HOME = "src/resources/settings.png";
    public static final String FOLDER_PIC_HOME = "src/resources/folder.png";
    public static final String IMAGES_PIC_HOME = "src/resources/appointment.png";
    public static final String LOGO_PIC_HOME = "src/resources/logo_neofile.png";



    /*
    * Database constants
    * */
    public static final String DATABASE_NAME = "neofile";
    public static final String TABLE_PATIENTS = DATABASE_NAME + ".patients";

    public static final String DATABASE_USER = "root";
    public static final String DATABASE_PASSWORD = "captain9396";

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_BIRTHDAY = "BIRTHDAY";
    public static final String COLUMN_SEX = "SEX";
    public static final String COLUMN_HEIGHT = "HEIGHT";
    public static final String COLUMN_WEIGHT = "WEIGHT";
    public static final String COLUMN_OCCUPATION = "OCCUPATION";
    public static final String COLUMN_COUNTRY = "COUNTRY";
    public static final String COLUMN_CITY = "CITY";
    public static final String COLUMN_ZIPCODE = "ZIPCODE";
    public static final String COLUMN_CONTACT_NO = "CONTACT_NO";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_PROFILE_PIC = "PROFILE_PIC";





    public static final String TMP_LOCATION = "src/tmp/";
    public static final String PICTURE_FORMAT = ".png";



}
