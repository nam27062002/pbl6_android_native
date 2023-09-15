package com.pbl.app_mobile.view;

public interface RegisterView {
    void navigateToLogin();
    void eventFocusName(boolean hasFocus);
    void eventFocusEmail(boolean hasFocus);
    void eventFocusPassword(boolean hasFocus);
    void showHidePassword(boolean isActive);
    void showValidationError(String errorText);
    void clearValidationError();
}
