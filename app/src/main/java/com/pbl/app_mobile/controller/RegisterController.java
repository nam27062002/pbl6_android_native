package com.pbl.app_mobile.controller;

import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.model.DO.RegisterDO;
import com.pbl.app_mobile.view.RegisterView;

public class RegisterController {
    private RegisterView view;
    private RegisterDO registerDO;
    public RegisterController(RegisterView view){
        this.view = view;
        registerDO = new RegisterDO(this);
    }
    public void navigateToLogin() {
        view.navigateToLogin();
    }

    public void eventFocusName(boolean hasFocus){
        view.eventFocusName(hasFocus);
    }
    public void eventFocusEmail(boolean hasFocus){
        view.eventFocusEmail(hasFocus);
    }
    public void eventFocusPassword(boolean hasFocus){
        view.eventFocusPassword(hasFocus);
    }
    public void changeStatusPassword(){
        registerDO.changeStatusPassword();
    }
    public void showHidePassword(boolean isActive){
        view.showHidePassword(isActive);
    }
    public void validateCredentials(User user){
        registerDO.validateCredentials(user);
    }
    public void showValidationError(String errorText){
        view.showValidationError(errorText);
    }
}
