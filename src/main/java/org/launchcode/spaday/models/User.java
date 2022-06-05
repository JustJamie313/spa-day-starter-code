package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static java.util.Objects.isNull;

public class User {
    private Integer id;
    private static Integer nextID = 1;
    @NotBlank(message = "Username is required.")
    @Size(min=5,max=15,message="Username must be between 5 and 15 characters.")
    private String username;
    @Email(regexp=".+@.+\\..+",message="Email address is invalid.")
    private String email;
    @NotBlank(message = "Password is required.")
    @Size(min=6,message="Password must be at least 6 characters.")
    private String password;
    @NotBlank(message = "Verify Password is required.")
    @NotNull(message="Passwords do not match.")
    private String verify;

    public User() {
        this.id = nextID;
        nextID++;
    }

    public User(String username, String email, String password, String verify) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        checkPassword();
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        checkPassword();
    }
    private void checkPassword(){
        System.out.println("Password: "+this.password);
        System.out.println("Verify: "+this.verify);
        System.out.println("Matches: "+this.password.equals(this.verify));
        if(!isNull(this.password) && !isNull(this.verify) && !this.password.equals(this.verify)){
            this.verify = null;
        }
    }
}
