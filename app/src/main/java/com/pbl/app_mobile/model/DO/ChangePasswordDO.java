package com.pbl.app_mobile.model.DO;

import android.app.Activity;

import com.google.gson.JsonObject;
import com.pbl.app_mobile.controller.ChangePasswordController;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.network.ApiManager;
import com.pbl.app_mobile.network.ApiService;
import com.pbl.app_mobile.network.JsonHandle;
import com.pbl.app_mobile.utils.EmailValidator;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordDO {
    private ChangePasswordController changePasswordController;
    private boolean isOldPasswordHide = false;
    private boolean isNewPasswordHide = false;
    private boolean isReNewPasswordHide = false;
    public ChangePasswordDO(ChangePasswordController changePasswordController, Activity activity) {
        this.changePasswordController = changePasswordController;

    }
    public String validatePassword(String oldPassword, String newPassword, String reNewPassword) {
        if (oldPassword.isEmpty()) {
            return "Please enter old password";
        } else if (newPassword.isEmpty()) {
            return "Please enter new password";
        } else if (reNewPassword.isEmpty()) {
                return "Non-Matching";
        } else if (!newPassword.equals(reNewPassword)) {
            return "Please enter again new password";
        }
        return "";
    }
    public void validateCredentials(String oldPassword, String newPassword, String reNewPassword){
        String errorText = validatePassword(oldPassword,newPassword,reNewPassword);
        if (errorText.isEmpty()) {
            callApiSChangePassword(oldPassword,newPassword,reNewPassword);
        } else {
            changePasswordController.showValidationError(errorText);
        }
    }
    public void changeStatusOldPassword() {
        isOldPasswordHide = !isOldPasswordHide;
        changePasswordController.showHideOldPassword(isOldPasswordHide);
    }
    public void changeStatusNewPassword() {
        isNewPasswordHide = !isNewPasswordHide;
        changePasswordController.showHideNewPassword(isNewPasswordHide);
    }
    public void changeStatusReNewPassword() {
        isReNewPasswordHide = !isReNewPasswordHide;
        changePasswordController.showHideReNewPassword(isReNewPasswordHide);
    }
    private void callApiSChangePassword(String oldPassword, String newPassword, String reNewPassword) {

        User loggedInUser = User.getLoggedInUser();
        if (!oldPassword.equals(loggedInUser.getPassword())) {
            changePasswordController.showValidationError("Mật khẩu cũ không đúng");
            return;
        }
        ApiService apiService = ApiManager.getInstance().createService(ApiService.class);
        JsonObject passwordData = new JsonObject();
        passwordData.addProperty("oldPassword", oldPassword);
        passwordData.addProperty("newPassword", newPassword);
        passwordData.addProperty("reNewPassword", reNewPassword);
        Call<ResponseBody> call = apiService.changePassword(passwordData);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    loggedInUser.setPassword(newPassword);
                } else {
                    try {
                        changePasswordController.showValidationError(JsonHandle.getMessage(response, true));
                    } catch (Exception e) {

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        // Gọi API bằng cách sử dụng Retrofit
        // Xử lý kết quả trong onResponse và onFailure của Callback
    }

}
