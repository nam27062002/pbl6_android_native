package com.pbl.app_mobile.network;

import com.pbl.app_mobile.model.DO.LoginDO;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private static String BASE_URL = "http://ridewizard.pro:9000/";

    private static ApiManager instance;
    private Retrofit retrofit;
    OkHttpClient.Builder httpClient;
    private ApiManager() {
        httpClient = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public void addAccessToken(){
        httpClient.addInterceptor(new AuthInterceptor(LoginDO.accessToken));
    }
    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }
        return instance;
    }

    public <T> T createService(Class<T> serviceClass) {
        if (retrofit != null) {
            return retrofit.create(serviceClass);
        } else {
            throw new IllegalStateException("Retrofit instance is not initialized.");
        }
    }
}
