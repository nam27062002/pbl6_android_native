package com.pbl.app_mobile.view;

import android.app.Activity;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

public interface LoginView {
    void showValidationError(String message);
    void navigateToRegister();
    void clearValidationError();
    void eventFocusEmail(boolean hasFocus);
    void eventFocusPassword(boolean hasFocus);
    void showHidePassword(boolean isActive);
    void signInWithGoogle(GoogleSignInClient gsc);
    void setMessageLoginWithGoogle(String message);
}