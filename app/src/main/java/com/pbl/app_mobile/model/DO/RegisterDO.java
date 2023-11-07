package com.pbl.app_mobile.model.DO;

import com.pbl.app_mobile.controller.RegisterController;
import com.pbl.app_mobile.data.User;
import com.pbl.app_mobile.network.ApiManager;
import com.pbl.app_mobile.network.ApiService;
import com.pbl.app_mobile.network.JsonHandle;
import com.pbl.app_mobile.utils.EmailValidator;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class RegisterDO {
    private Boolean isPasswordHide = false;
    private RegisterController registerController;
    private boolean check = false;

    public RegisterDO(RegisterController registerController) {
        this.registerController = registerController;
    }

    public void changeStatusPassword() {
        isPasswordHide = !isPasswordHide;
        registerController.showHidePassword(isPasswordHide);
    }

    public boolean getCheck() {
        check = !check;
        return check;
    }

    public void validateCredentials(User user) {
        String errorText = validateUser(user);
        if (errorText.isEmpty()) {
            callApiRegister(user);
        } else {
            registerController.showValidationError(errorText);
        }
    }

    private String validateUser(User user) {
        if (!check) {
            return "Please check the box to agree to the Terms of Service and Privacy Policy";
        }

        if (user.getFullName().isEmpty()) {
            return "Please enter your name";
        }

        if (user.getEmail().isEmpty()) {
            return "Please enter your email";
        }

        if (!EmailValidator.isValidEmail(user.getEmail())) {
            return "Invalid email format";
        }

        if (user.getPhNo().isEmpty()) {
            return "Please enter your phone number";
        }

        if (user.getPassword().isEmpty()) {
            return "Please enter your password";
        }

        return "";
    }

    private void callApiRegister(User user) {
        ApiService apiService = ApiManager.getInstance().createService(ApiService.class);
        Call<ResponseBody> call = apiService.signUp(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        if (JsonHandle.IsSuccess(response)) {
                            registerController.navigateToHome();
                        }
                    } catch (Exception e) {

                    }
                } else {
                    try {
                        registerController.showValidationError(JsonHandle.getMessage(response, true));
                    } catch (Exception e) {

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}

