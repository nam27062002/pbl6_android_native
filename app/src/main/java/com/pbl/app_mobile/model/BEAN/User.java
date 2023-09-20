package com.pbl.app_mobile.model.BEAN;

public class User {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(String email, String password,String name,String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {return name;}
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {return phoneNumber;}
}
