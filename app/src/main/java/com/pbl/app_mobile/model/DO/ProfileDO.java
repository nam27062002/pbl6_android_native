package com.pbl.app_mobile.model.DO;

import com.google.gson.JsonObject;
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
    public Call<ResponseBody> getProfileById(int id){
        return apiService.getProfileById(id);
    }
}
