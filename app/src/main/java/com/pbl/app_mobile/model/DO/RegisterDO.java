package com.pbl.app_mobile.model.DO;

import com.pbl.app_mobile.controller.RegisterController;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.utils.EmailValidator;

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
    public void validateCredentials(User user){
        String errorText = "";
        if (!check){
            errorText = "Please check the box to agree to the Terms of Service and Privacy Policy";
        } else if (user.getName().isEmpty()){
            errorText = "Please enter your name";
        } else if (user.getEmail().isEmpty()) {
            errorText = "Please enter your email";
        } else if (!EmailValidator.isValidEmail(user.getEmail())) {
            errorText = "Invalid email format";
        } else if (user.getPhoneNumber().isEmpty()) {
            errorText = "Please enter your phone number";
        } else if (user.getPassword().isEmpty()) {
            errorText = "Please enter your password";
        }
        registerController.showValidationError(errorText);
    }
    public boolean getCheck(){
         check = !check;
         return check;
    }
}
