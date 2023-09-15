package com.pbl.app_mobile;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pbl.app_mobile.controller.RegisterController;
import com.pbl.app_mobile.model.BEAN.User;
import com.pbl.app_mobile.view.RegisterView;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    EditText inputName;
    EditText inputEmail;
    EditText inputPassword;
    View outline_input_email;
    View outline_input_name;
    View outline_input_password;
    Button buttonSignin;
    Button buttonSignUp;
    Button buttonEye;
    ImageView imageEye;
    private TextView textError;
    RegisterController registerController;
    Animation clickAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        registerController = new RegisterController(this);
        buttonSignin = findViewById(R.id.button_sign_in);
        inputEmail = findViewById(R.id.input_email);
        inputName = findViewById(R.id.input_name);
        inputPassword = findViewById(R.id.input_password);
        outline_input_name = findViewById(R.id.outline_input_name);
        outline_input_email = findViewById(R.id.outline_input_email);
        outline_input_password = findViewById(R.id.outline_input_password);
        buttonEye = findViewById(R.id.button_eye);
        buttonSignUp = findViewById(R.id.button_sign_up);
        imageEye = findViewById(R.id.image_eye);
        textError = findViewById(R.id.text_error);
        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);
        clearValidationError();
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(clickAnimation);
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                User user = new User(email, password, name);
                registerController.validateCredentials(user);
            }
        });

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerController.navigateToLogin();
            }
        });
        buttonEye.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                registerController.changeStatusPassword();
            }
        });
        inputEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                registerController.eventFocusEmail(hasFocus);
            }
        });
        inputName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                registerController.eventFocusName(hasFocus);
            }
        });
        inputPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                registerController.eventFocusPassword(hasFocus);
            }
        });
    }

    @Override
    public void navigateToLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void eventFocusName(boolean hasFocus) {
        if (hasFocus) {
            outline_input_name.setBackgroundResource(R.drawable.blue_input_backgroud);
        } else {
            outline_input_name.setBackgroundResource(R.drawable.white_input_backgroud);
        }
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

    @Override
    public void showValidationError(String errorText) {
        textError.setText(errorText);
    }
    @Override
    public void clearValidationError() {
        textError.setText("");
    }
}
