package com.pbl.app_mobile.network;
import com.google.gson.JsonObject;
import com.pbl.app_mobile.data.User;
import com.pbl.app_mobile.model.BEAN.Profile.ProfileRespone;
import com.pbl.app_mobile.model.BEAN.User.UserResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("/api/v1/users/signup")
    Call<ResponseBody> signUp(@Body User user);
    @POST("/api/v1/users/signin")
    Call<UserResponse> signIn(@Body JsonObject user);
    @POST("/api/v1/users/login/google")
    Call<ResponseBody> SignInWithGoogle(@Body JsonObject gmail);
    @GET("/api/v1/users/{id}")
    Call<ProfileRespone> getProfileById(@Path("id")int id);
}
