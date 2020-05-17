package nl.zdzislaw.verhuur_voertuig.model.Users;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class User {
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "DateOfBirth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @Column(name = "Street")
    private String street;
    @Column(name = "HouseNumber")
    private int houseNumber;
    @Column(name = "Addition")
    private String addition;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "Province")
    private String province;
    @Column(name = "Country")
    private String country;
    @Id
    @NotEmpty
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    @NotEmpty
    private String password;
    @Column(name = "RegisterDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;
    @Column(name="RoleName")
    private String roleName;
    @Column(name="Enabled")
    private Boolean enabled;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public User(String firstName, String lastName, Date dateOfBirth, String street, int houseNumber, String addition, String postalCode, String province, String country, String username, String password, Date registerDate, String roleName, Boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.street = street;
        this.houseNumber = houseNumber;
        this.addition = addition;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
        this.roleName=roleName;
        this.enabled=enabled;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", addition='" + addition + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                ", authority='" + roleName + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
