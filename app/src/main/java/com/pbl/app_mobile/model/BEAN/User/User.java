
package com.pbl.app_mobile.model.BEAN.User;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class User {

    @SerializedName("accessToken")
    private String mAccessToken;
    @SerializedName("address")
    private Object mAddress;
    @SerializedName("avatar")
    private Object mAvatar;
    @SerializedName("createdAt")
    private String mCreatedAt;
    @SerializedName("dob")
    private Object mDob;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("email_verified")
    private Long mEmailVerified;
    @SerializedName("facebookId")
    private Object mFacebookId;
    @SerializedName("firstName")
    private Object mFirstName;
    @SerializedName("fullName")
    private String mFullName;
    @SerializedName("googleId")
    private Object mGoogleId;
    @SerializedName("id")
    private Long mId;
    @SerializedName("lastName")
    private String mLastName;
    @SerializedName("passwordDefault")
    private Long mPasswordDefault;
    @SerializedName("phNo")
    private String mPhNo;
    @SerializedName("phone_verified")
    private Long mPhoneVerified;
    @SerializedName("refreshToken")
    private String mRefreshToken;
    @SerializedName("role")
    private List<Role> mRole;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("updatedAt")
    private String mUpdatedAt;

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }

    public Object getAddress() {
        return mAddress;
    }

    public void setAddress(Object address) {
        mAddress = address;
    }

    public Object getAvatar() {
        return mAvatar;
    }

    public void setAvatar(Object avatar) {
        mAvatar = avatar;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public Object getDob() {
        return mDob;
    }

    public void setDob(Object dob) {
        mDob = dob;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Long getEmailVerified() {
        return mEmailVerified;
    }

    public void setEmailVerified(Long emailVerified) {
        mEmailVerified = emailVerified;
    }

    public Object getFacebookId() {
        return mFacebookId;
    }

    public void setFacebookId(Object facebookId) {
        mFacebookId = facebookId;
    }

    public Object getFirstName() {
        return mFirstName;
    }

    public void setFirstName(Object firstName) {
        mFirstName = firstName;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public Object getGoogleId() {
        return mGoogleId;
    }

    public void setGoogleId(Object googleId) {
        mGoogleId = googleId;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public Long getPasswordDefault() {
        return mPasswordDefault;
    }

    public void setPasswordDefault(Long passwordDefault) {
        mPasswordDefault = passwordDefault;
    }

    public String getPhNo() {
        return mPhNo;
    }

    public void setPhNo(String phNo) {
        mPhNo = phNo;
    }

    public Long getPhoneVerified() {
        return mPhoneVerified;
    }

    public void setPhoneVerified(Long phoneVerified) {
        mPhoneVerified = phoneVerified;
    }

    public String getRefreshToken() {
        return mRefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        mRefreshToken = refreshToken;
    }

    public List<Role> getRole() {
        return mRole;
    }

    public void setRole(List<Role> role) {
        mRole = role;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
