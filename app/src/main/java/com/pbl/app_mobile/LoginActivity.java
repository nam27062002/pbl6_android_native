package com.pbl.app_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.pbl.app_mobile.controller.LoginController;
import com.pbl.app_mobile.data.User;
import com.pbl.app_mobile.view.LoginView;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.Objects;


public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText inputEmail;
    private EditText inputPassword;
    private View outline_input_email;
    private View outline_input_password;
    private Button buttonSignIn;
    private Button buttonEye;
    private Button buttonRegister;
    private Button buttonLoginWithGoogle;
    private Button buttonLoginWithFb;
    private TextView textError;
    private ImageView imageEye;
    private LoginController loginController;
    private TextView textPlaceholderEmail;
    private TextView textPlaceholderPassword;
    private boolean isLoginWithGoogle = false;
    Animation clickAnimation;

    // FB
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        outline_input_email = findViewById(R.id.outline_input_email);
        outline_input_password = findViewById(R.id.outline_input_password);
        buttonSignIn = findViewById(R.id.button_sign_in);
        buttonEye = findViewById(R.id.button_eye);
        buttonRegister = findViewById(R.id.button_register);
        buttonLoginWithGoogle = findViewById(R.id.button_google);
        buttonLoginWithFb = findViewById(R.id.button_facebook);
        textError = findViewById(R.id.text_error);
        imageEye = findViewById(R.id.image_eye);
        textPlaceholderEmail = findViewById(R.id.textPlaceholderEmail);
        textPlaceholderPassword = findViewById(R.id.textPlaceholderPassword);
        loginController = new LoginController(this,this);
        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);

        clearValidationError();
        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        try {
                                            String userName = object.optString("first_name");
                                            String id = object.optString("id");
                                            String avatarUrl = object.getJSONObject("picture").getJSONObject("data").getString("url");
                                            Toast.makeText(getApplicationContext(),userName, Toast.LENGTH_SHORT).show();
                                            navigateToRegisterAuth();
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                });


                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "picture.type(large)");
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {

                        Log.e("error", "onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {

                        Log.e("error", Objects.requireNonNull(exception.getLocalizedMessage()));
                    }
                });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(clickAnimation);
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                User user = new User(email, password);
                loginController.validateCredentials(user);
            }
        });

        buttonLoginWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLoginWithGoogle = true;
                loginController.signInWithGoogle();
            }
        });

        buttonLoginWithFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLoginWithGoogle = false;
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile"));
            }
        });

        buttonEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginController.changeStatusPassword();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginController.navigateToRegister();
            }
        });

        inputEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                loginController.eventFocusEmail(hasFocus);
            }
        });
        inputPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                loginController.eventFocusPassword(hasFocus);
            }
        });

    }

    @Override
    public void showValidationError(String message) {
        textError.setText(message);
    }

    @Override
    public void navigateToRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void clearValidationError() {
        textError.setText("");
    }

    @Override
    public void eventFocusEmail(boolean hasFocus) {
        if (hasFocus) {
            outline_input_email.setBackgroundResource(R.drawable.blue_input_backgroud);
            textPlaceholderEmail.setText("");
        } else {
            outline_input_email.setBackgroundResource(R.drawable.white_input_backgroud);
            if (inputEmail.getText().toString().isEmpty()){
                textPlaceholderEmail.setText("Email or phone number");
            }
        }
    }

    @Override
    public void eventFocusPassword(boolean hasFocus) {
        if (hasFocus) {
            outline_input_password.setBackgroundResource(R.drawable.blue_input_backgroud);
            textPlaceholderPassword.setText("");
        } else {
            outline_input_password.setBackgroundResource(R.drawable.white_input_backgroud);
            if (inputPassword.getText().toString().isEmpty()){
                textPlaceholderPassword.setText("Enter your password");
            }
        }
    }

    @Override
    public void showHidePassword(boolean isActive) {
        if (isActive){
            imageEye.setImageResource(R.drawable.view);
            inputPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else{
            imageEye.setImageResource(R.drawable.hide);
            inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    @Override
    public void signInWithGoogle(GoogleSignInClient gsc) {
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    public void setMessageLoginWithGoogle(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToRegisterAuth() {
        Intent intent = new Intent(LoginActivity.this, RegisterAuthActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(LoginActivity.this, ContainerPageActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (isLoginWithGoogle) {
            super.onActivityResult(requestCode, resultCode, data);
            loginController.signInWithGoogle(requestCode,data);
        }
        else{
            callbackManager.onActivityResult(requestCode, resultCode, data);
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
