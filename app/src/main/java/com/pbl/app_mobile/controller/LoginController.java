package com.pbl.app_mobile.controller;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.model.DO.LoginDO;
import com.pbl.app_mobile.view.LoginView;

public class LoginController {

    private LoginView view;
    private LoginDO loginDO;
    public LoginController(LoginView view) {
        this.view = view;
        loginDO = new LoginDO(this);
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
}