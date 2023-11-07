package com.pbl.app_mobile.model.DO;
import static com.pbl.app_mobile.network.JsonHandle.IsSuccess;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.fido.u2f.api.common.RequestParams;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonObject;
import com.pbl.app_mobile.controller.LoginController;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.network.ApiManager;
import com.pbl.app_mobile.network.ApiService;
import com.pbl.app_mobile.network.JsonHandle;
import com.pbl.app_mobile.utils.EmailValidator;

import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginDO {
    private LoginController loginController;
    private boolean isPasswordHide = false;
    private GoogleSignInOptions gso;
    private GoogleSignInClient gsc;
    public void validateCredentials(User user){
        String errorText = validateUser(user);
        if (errorText.isEmpty()) {
            callApiSignIn(user);
        } else {
            loginController.showValidationError(errorText);
        }
    }
    private String validateUser(User user){
        if (user.getEmail().isEmpty()) {
            return "Please enter your email";
        } else if (!EmailValidator.isValidEmail(user.getEmail())) {
            return "Invalid email format";
        } else if (user.getPassword().isEmpty()) {
            return "Please enter your password";
        }
        return "";
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
                callApiSignInWithGoogle(account);
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

    private void callApiSignInWithGoogle(GoogleSignInAccount account){
        ApiService apiService = ApiManager.getInstance().createService(ApiService.class);
        JsonObject paramObject = new JsonObject();
        paramObject.addProperty("googleId", account.getId());
        paramObject.addProperty("email", account.getEmail());
        Call<ResponseBody> call = apiService.SignInWithGoogle(paramObject);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        if (IsSuccess(response)) {
                            loginController.messageLoginWithGoogle(account.getId() + "\n" + account.getEmail());
                            loginController.navigateToRegisterAuth();
                        }
                    } catch (Exception e) {

                    }
                } else {
                    try {
                        loginController.showValidationError(JsonHandle.getMessage(response, true));
                    } catch (Exception e) {

                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    private void callApiSignIn(User user){
        ApiService apiService = ApiManager.getInstance().createService(ApiService.class);
        JsonObject paramObject = new JsonObject();
        paramObject.addProperty("username", user.getEmail());
        paramObject.addProperty("password", user.getPassword());
        paramObject.addProperty("type", "email");
        Call<ResponseBody> call = apiService.signIn(paramObject);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        if (IsSuccess(response)) {

                            // id với accesstoken ở đây
//
                            String id = JsonHandle.GetId();
                            String accessToken = JsonHandle.GetAccessToken();
                            Log.d("NAMTRAN",id + accessToken);
                            loginController.navigateToHome();
                        }
                    } catch (Exception e) {

                        Log.e("error", Objects.requireNonNull(e.getLocalizedMessage()));
                    }
                } else {
                    try {
                        loginController.showValidationError(JsonHandle.getMessage(response, true));
                    } catch (Exception e) {

                        Log.e("error", Objects.requireNonNull(e.getLocalizedMessage()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.e("error", Objects.requireNonNull(t.getLocalizedMessage()));
            }
        });
    }
}
