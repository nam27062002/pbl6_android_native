package com.pbl.app_mobile.controller;

import android.app.Activity;

import com.pbl.app_mobile.model.DO.ChangePasswordDO;
import com.pbl.app_mobile.view.ChangePasswordView;

public class ChangePasswordController {
    private ChangePasswordView view;
    private ChangePasswordDO changPasswordDO;
    public ChangePasswordController(ChangePasswordView view, Activity activity)
    {
        this.view = view;
        changPasswordDO = new ChangePasswordDO(this, activity);
    }
    public void changeStatusOldPassword() {
        changPasswordDO.changeStatusOldPassword();
    }

    public void changeStatusNewPassword() {
        changPasswordDO.changeStatusNewPassword();
    }

    public void changeStatusReNewPassword() {
        changPasswordDO.changeStatusReNewPassword();
    }

    public void eventFocusReNewPassword(boolean hasFocus) {
        view.eventFocusReNewPassword(hasFocus);
    }

    public void eventFocusNewPassword(boolean hasFocus) {
        view.eventFocusNewPassword(hasFocus);
    }

    public void eventFocusOldPassword(boolean hasFocus) {
        view.eventFocusOldPassword(hasFocus);
    }

    public void validatePassword(String oldPassword, String newPassword, String reNewPassword) {
        changPasswordDO.validateCredentials(oldPassword,newPassword,reNewPassword);
    }

    public void showValidationError(String errorText) {
        view.showValidationError(errorText);
    }

    public void showHideOldPassword(boolean isActive) {
        view.showHideOldPassword(isActive);
    }
    public void showHideNewPassword(boolean isActive) {
        view.showHideNewPassword(isActive);
    }
    public void showHideReNewPassword(boolean isActive) {
        view.showHideReNewPassword(isActive);
    }
    public void navigateToHome(){
        view.navigateToHome();
    }
}
