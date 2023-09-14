package com.pbl.app_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.pbl.app_mobile.controller.LoginController;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.view.LoginView;


public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText inputEmail;
    private EditText inputPassword;
    private View outline_input_email;
    private View outline_input_password;
    private Button buttonSignIn;
    private Button buttonEye;
    private Button buttonRegister;
    private TextView textError;
    private ImageView imageEye;
    private LoginController loginController;

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
        textError = findViewById(R.id.text_error);
        imageEye = findViewById(R.id.image_eye);
        loginController = new LoginController(this);

        clearValidationError();
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                User user = new User(email, password);
                loginController.validateCredentials(user);
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
        } else {
            outline_input_email.setBackgroundResource(R.drawable.white_input_backgroud);
        }
    }

    @Override
    public void eventFocusPassword(boolean hasFocus) {
        if (hasFocus) {
            outline_input_password.setBackgroundResource(R.drawable.blue_input_backgroud);
        } else {
            outline_input_password.setBackgroundResource(R.drawable.white_input_backgroud);
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


}
