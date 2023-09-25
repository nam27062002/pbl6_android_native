package com.pbl.app_mobile.model.BEAN;

public class User {
    public User(String fullName, String email, String phNo, String password) {
        this.fullName = fullName;
        this.email = email;
        this.phNo = phNo;
        this.password = password;
    }

    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhNo() {
        return phNo;
    }

    public String getPassword() {
        return password;
    }

    private String email;
    private String phNo;
    private String password;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
