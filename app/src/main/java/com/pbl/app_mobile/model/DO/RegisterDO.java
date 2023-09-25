package com.pbl.app_mobile.model.DO;

import com.pbl.app_mobile.controller.RegisterController;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.network.ApiManager;
import com.pbl.app_mobile.network.ApiService;
import com.pbl.app_mobile.network.JsonHandle;
import com.pbl.app_mobile.network.Key;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterDO {
    Boolean isPasswordHide = false;
    RegisterController registerController;
    boolean check = false;
    public RegisterDO(RegisterController registerController){
        this.registerController = registerController;
    }
    public void changeStatusPassword(){
        isPasswordHide = !isPasswordHide;
        registerController.showHidePassword(isPasswordHide);
    }
    public boolean getCheck(){
        check = !check;
        return check;
    }
    public void validateCredentials(User user){
        callApiResister();
//        String errorText = "";
//        if (!check){
//            errorText = "Please check the box to agree to the Terms of Service and Privacy Policy";
//        } else if (user.getName().isEmpty()){
//            errorText = "Please enter your name";
//        } else if (user.getEmail().isEmpty()) {
//            errorText = "Please enter your email";
//        } else if (!EmailValidator.isValidEmail(user.getEmail())) {
//            errorText = "Invalid email format";
//        } else if (user.getPhoneNumber().isEmpty()) {
//            errorText = "Please enter your phone number";
//        } else if (user.getPassword().isEmpty()) {
//            errorText = "Please enter your password";
//        }
//
//        registerController.showValidationError(errorText);
    }
    private void callApiResister() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://27.69.251.31:9000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        User user = new User("Tran Trong Nam", "User312@gmail.com", "0892224322", "User1d@123");
        Call<ResponseBody> call = apiService.signUp(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
//                    registerController.showValidationError(JsonHandle.GetValue(Key.success,response));
                }
                else{
                    registerController.showValidationError("Error code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
