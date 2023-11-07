package com.pbl.app_mobile.view;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

public interface ChangePasswordView {
    void showValidationError(String message);
    void clearValidationError();
    void eventFocusOldPassword(boolean hasFocus);
    void eventFocusNewPassword(boolean hasFocus);
    void eventFocusReNewPassword(boolean hasFocus);
    void showHideOldPassword(boolean isActive);
    void showHideNewPassword(boolean isActive);
    void showHideReNewPassword(boolean isActive);
    void navigateToHome();
}
