package com.pbl.app_mobile.network;

import com.pbl.app_mobile.model.BEAN.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/v1/users/signup")
    Call<ResponseBody> signUp(@Body User user);
}
