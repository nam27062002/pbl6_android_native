package com.pbl.app_mobile.data;

public class User {
    private String name;
    private String email;
    private String password;
    private String fullName;
    private String phNo;
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User(String name, String email, String password, String fullName, String phNo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.phNo = phNo;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(String email, String password,String name) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, String fullName) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public String getName() {return name;}
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
