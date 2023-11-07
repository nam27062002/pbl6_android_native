package com.pbl.app_mobile.model.BEAN.Profile;

public class Profile {
    int id;
    String firstName;
    String lastName;
    String fullName;
    String dob;
    String address;
    String phNo;
    String phone_verified;
    String email;
    String email_verified;
    String avatar;
    String OTPSecret;
    String googleId;
    String facebookId;
    int passwordDefault;
    String createdAt;
    String updatedAt;

    public Profile(int id, String firstName, String lastName, String fullName, String dob, String address, String phNo, String phone_verified, String email, String email_verified, String avatar, String OTPSecret, String googleId, String facebookId, int passwordDefault, String createdAt, String updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.phNo = phNo;
        this.phone_verified = phone_verified;
        this.email = email;
        this.email_verified = email_verified;
        this.avatar = avatar;
        this.OTPSecret = OTPSecret;
        this.googleId = googleId;
        this.facebookId = facebookId;
        this.passwordDefault = passwordDefault;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getPhone_verified() {
        return phone_verified;
    }

    public void setPhone_verified(String phone_verified) {
        this.phone_verified = phone_verified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(String email_verified) {
        this.email_verified = email_verified;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getOTPSecret() {
        return OTPSecret;
    }

    public void setOTPSecret(String OTPSecret) {
        this.OTPSecret = OTPSecret;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public int getPasswordDefault() {
        return passwordDefault;
    }

    public void setPasswordDefault(int passwordDefault) {
        this.passwordDefault = passwordDefault;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
