package com.pbl.app_mobile.controller;
import android.app.Activity;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.model.DO.LoginDO;
import com.pbl.app_mobile.view.LoginView;

public class LoginController {

    private LoginView view;
    private LoginDO loginDO;
    public LoginController(LoginView view, Activity activity) {
        this.view = view;
        loginDO = new LoginDO(this,activity);
    }

    public void validateCredentials(User user) {
        loginDO.validateCredentials(user);
    }
    public void showValidationError(String errorText){
        view.showValidationError(errorText);
    }
    public void eventFocusEmail(boolean hasFocus){
        view.eventFocusEmail(hasFocus);
    }
    public void eventFocusPassword(boolean hasFocus){
        view.eventFocusPassword(hasFocus);
    }
    public void changeStatusPassword(){
        loginDO.changeStatusPassword();
    }
    public void showHidePassword(boolean isActive){
        view.showHidePassword(isActive);
    }
    public void navigateToRegister() {
        view.navigateToRegister();
    }

    public void signInWithGoogle(){
        loginDO.signInWithGoogle();
    }
    public void signInWithGoogle(GoogleSignInClient gsc){
        view.signInWithGoogle(gsc);
    }
    public void signInWithGoogle(int requestCode, Intent data){
        loginDO.signInWithGoogle(requestCode,data);
    }
    public void messageLoginWithGoogle(String message){
        view.setMessageLoginWithGoogle(message);
    }
    public void signOutWithGoogle(Activity activity){
        loginDO.signOutWithGoogle(activity);
    }
}