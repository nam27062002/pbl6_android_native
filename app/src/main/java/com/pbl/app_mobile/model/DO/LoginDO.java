package com.pbl.app_mobile.model.DO;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.pbl.app_mobile.controller.LoginController;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.utils.EmailValidator;

public class LoginDO {
    private LoginController loginController;
    private boolean isPasswordHide = false;
    private GoogleSignInOptions gso;
    private GoogleSignInClient gsc;
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
    public LoginDO(LoginController loginController, Activity activity){
        this.loginController = loginController;
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(activity,gso);
    }
    public void changeStatusPassword(){
        isPasswordHide = !isPasswordHide;
        loginController.showHidePassword(isPasswordHide);
    }
    public void signInWithGoogle(int requestCode, Intent data){
        if (requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                loginController.messageLoginWithGoogle(account.getDisplayName().toString() + "\n" + account.getEmail());
            } catch (ApiException e) {
                loginController.messageLoginWithGoogle("something went wrong");
            }
        }
    }
    public void signInWithGoogle(){
        loginController.signInWithGoogle(gsc);
    }
    public void signOutWithGoogle(Activity activity){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                activity.finish();
                loginController.messageLoginWithGoogle("signed out");
            }
        });
    }
    public void logOutWithFacebook(){
        LoginManager.getInstance().logOut();
    }
}
