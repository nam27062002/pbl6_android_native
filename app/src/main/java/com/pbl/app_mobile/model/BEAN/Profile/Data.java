
package com.pbl.app_mobile.model.BEAN.Profile;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Data {

    @SerializedName("user")
    private Profile mUser;

    public Profile getUser() {
        return mUser;
    }

    public void setUser(Profile user) {
        mUser = user;
    }

}
