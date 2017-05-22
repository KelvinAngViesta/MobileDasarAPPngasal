package quewquewcrew.appngasal.model.entity;


import java.util.ArrayList;

/**
 * Created by User on 4/25/2017.
 */


public class User {
    private int id;
    private String name;
    private String email;
    private String bio;
    private String password;

    public static int _id = 1;

    public static ArrayList<User> users = new ArrayList<>();

    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = _id;
        _id++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
