
package com.pbl.app_mobile.model.BEAN.User;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Role {

    @SerializedName("id")
    private Long mId;
    @SerializedName("role")
    private String mRole;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }

}
