package model;

public class Patient {
    private String id;
    private String name;
    private String birthday;
    private String sex;
    private String height;
    private String weight;
    private String occupation;

    private String country;
    private String city;
    private String zipcode;

    private String contactNumber;
    private String email;

    private String profilePic;

    public Patient(String id, String name, String birthday, String sex, String height,
                   String weight, String occupation, String country, String city,
                   String zipcode, String contactNumber, String email, String profilePic) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.occupation = occupation;
        this.country = country;
        this.city = city;
        this.zipcode = zipcode;
        this.contactNumber = contactNumber;
        this.email = email;
        this.profilePic = profilePic;
    }

    public Patient() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getHeight() {
        return height;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{ID = " + id + " , " +
                "EMAIL = " + email + "\n";
    }
}
