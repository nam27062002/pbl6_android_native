package com.pbl.app_mobile.model.DO;

import com.pbl.app_mobile.controller.RegisterController;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.network.ApiManager;
import com.pbl.app_mobile.network.ApiService;
import com.pbl.app_mobile.network.JsonHandle;
import com.pbl.app_mobile.utils.EmailValidator;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        String errorText = "";
        if (!check){
            errorText = "Please check the box to agree to the Terms of Service and Privacy Policy";
        } else if (user.getFullName().isEmpty()){
            errorText = "Please enter your name";
        } else if (user.getEmail().isEmpty()) {
            errorText = "Please enter your email";
        } else if (!EmailValidator.isValidEmail(user.getEmail())) {
            errorText = "Invalid email format";
        } else if (user.getPhNo().isEmpty()) {
            errorText = "Please enter your phone number";
        } else if (user.getPassword().isEmpty()) {
            errorText = "Please enter your password";
        }
        if (errorText.isEmpty()){
            callApiResister(user);
        }
        else{
            registerController.showValidationError(errorText);
        }
    }
    private void callApiResister(User user) {
        ApiService apiService = ApiManager.getInstance().createService(ApiService.class);
        Call<ResponseBody> call = apiService.signUp(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        if(JsonHandle.IsSuccess(response)){
                            registerController.navigateToHome();
                        }
                    } catch (Exception e){}
                }
                else{
                    try {
                        registerController.showValidationError(JsonHandle.getMessage(response,true));
                    } catch (Exception e){}

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
