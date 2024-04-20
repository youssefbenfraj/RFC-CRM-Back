package pfe.rfc.crm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pfe.rfc.crm.entities.Role;

import java.util.Date;

public class SignupRequest {
    @Email(message = "Valid email address is mandatory")
    @NotBlank(message = "Email is mandatory")
    private String mail ;
    @NotNull(message = "Firstname is required")

    private String firstName;
    @NotNull(message = "Lastname is required")

    private String lastName;
    @NotNull(message = "Password is required")

    private String password;
    @NotNull(message = "Role is required")


    private Role role;
    @NotNull(message = "TelNumber is required")

    private String telNumber;
    private  String imagePath ;

    private Date birthDay;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    private String address;



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
