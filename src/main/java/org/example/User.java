package org.example;

import java.util.ArrayList;

public  class User {

    private String username;
    private String password;



    // Static field to store all user objects
    public static ArrayList<User> users = new ArrayList<User>();

    //Constructor method used to create objects from a class
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Getter method for username
    public  String getUsername() {
        return this.username;
    }
    //Setter method for username
    public  void setUsername(String newUsername) {
        this.username = username;
    }

    //Getter method for password
    public String getPassword() {
        return password;
    }

    //Setter method for password
    public void setPassword(String password) {
        this.password = password;
    }


}

