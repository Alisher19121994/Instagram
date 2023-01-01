package com.example.instagram.model.search;

public class User {

    String fullname;
    String emailAddress;

    public String getFullname() {
        return fullname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public User(String fullname, String emailAddress) {
        this.fullname = fullname;
        this.emailAddress = emailAddress;
    }
}
