package model;

public class Patient {
    private String name;
    private Date dateOfBirth;
    private String sex;
    private String height;
    private String occupation;

    private String country;
    private String city;
    private String zipcode;

    private String contactNumber;
    private String email;

    public Patient(String name, Date dateOfBirth, String sex,
                   String height, String occupation, String country,
                   String city, String zipcode, String contactNumber,
                   String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.height = height;
        this.occupation = occupation;
        this.country = country;
        this.city = city;
        this.zipcode = zipcode;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
