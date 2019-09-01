package com.example.demo.model;


import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[a-zA-Z]+$", message = "Błędne imie")
    @NotEmpty(message="{com.example.projekt.model.User.firstName.NotEmpty}")
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]+$", message = "Błędne nazwisko")
    @NotEmpty(message="{com.example.projekt.model.User.lastName.NotEmpty}")
    private String lastName;

    @Email(message = "Błedny email")
    private String email;

    @Column(unique = true)
    private String username;

    private String password;
    private String passwordAgain;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //    do telefonu
//    @Pattern(regexp="^\\d+$",
//            message = "{com.example.projekt.model.User.phone.NotEmpty}")

    public User(String firstName, String lastName, String email, String password, String passwordAgain) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordAgain = passwordAgain;
    }

    public User(){

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    @Override
    public String toString() {
        return "User: " +
                "FirstName: " + firstName + '\'' +
                "LastName: " + lastName + '\'' +
                "Email: " + email + '\'' +
                "Password: " + password + '\'' +
                "PasswordAgain: " + passwordAgain + '\'' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(passwordAgain, user.passwordAgain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password, passwordAgain);
    }
}
