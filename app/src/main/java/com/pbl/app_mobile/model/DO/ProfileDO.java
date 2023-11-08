package com.pbl.app_mobile.model.DO;

import com.google.gson.JsonObject;
import com.pbl.app_mobile.model.BEAN.Profile.ProfileRespone;
import com.pbl.app_mobile.model.BEAN.User.UserResponse;
import com.pbl.app_mobile.network.ApiManager;
import com.pbl.app_mobile.network.ApiService;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ProfileDO {
    ApiService apiService;
    private static ProfileDO instance;

    private ProfileDO() {
        apiService = ApiManager.getInstance().createService(ApiService.class);

    }
    public static ProfileDO getInstance(){
        if(instance == null){
            instance = new ProfileDO();
        }
        return instance;
    }
    public Call<ProfileRespone> getProfileById(int id){
        ApiManager.getInstance().addAccessToken();
        return apiService.getProfileById(id);
    }
}
