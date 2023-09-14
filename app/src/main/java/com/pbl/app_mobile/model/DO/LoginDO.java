package com.pbl.app_mobile.model.DO;

import com.pbl.app_mobile.controller.LoginController;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.utils.EmailValidator;

public class LoginDO {
    private LoginController loginController;
    private boolean isPasswordHide = false;

    public void validateCredentials(User user){
        String errorText = "";
        if (user.getEmail().isEmpty()) {
            errorText = "Please enter your email";
        } else if (!EmailValidator.isValidEmail(user.getEmail())) {
            errorText = "Invalid email format";
        } else if (user.getPassword().isEmpty()) {
            errorText = "Please enter your password";
        }
        loginController.showValidationError(errorText);
    }
    public LoginDO(LoginController loginController){
        this.loginController = loginController;
    }
    public void changeStatusPassword(){
        isPasswordHide = !isPasswordHide;
        loginController.showHidePassword(isPasswordHide);
    }
}
