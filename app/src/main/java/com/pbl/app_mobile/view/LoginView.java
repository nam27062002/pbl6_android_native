package com.pbl.app_mobile.view;

public interface LoginView {
    void showValidationError(String message);
    void navigateToRegister();
    void clearValidationError();
    void eventFocusEmail(boolean hasFocus);
    void eventFocusPassword(boolean hasFocus);
    void showHidePassword(boolean isActive);
}