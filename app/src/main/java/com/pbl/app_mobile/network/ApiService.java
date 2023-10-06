package com.pbl.app_mobile.network;
import com.google.gson.JsonObject;
import com.pbl.app_mobile.model.BEAN.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/v1/users/signup")
    Call<ResponseBody> signUp(@Body User user);
    @POST("/api/v1/users/signin")
    Call<ResponseBody> signIn(@Body JsonObject user);
    @POST("/api/v1/users/login/google")
    Call<ResponseBody> SignInWithGoogle(@Body JsonObject gmail);
}
