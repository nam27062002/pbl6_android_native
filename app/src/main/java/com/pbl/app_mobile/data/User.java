package com.pbl.app_mobile.data;

public class User {
    private String name;
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(String email, String password,String name) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {return name;}
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
