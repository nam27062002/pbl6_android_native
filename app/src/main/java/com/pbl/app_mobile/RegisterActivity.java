package com.pbl.app_mobile;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pbl.app_mobile.controller.RegisterController;
import com.pbl.app_mobile.model.BEAN.User.User;
import com.pbl.app_mobile.view.RegisterView;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    EditText inputName;
    EditText inputEmail;
    EditText inputPassword;
    EditText inputPhoneNumber;
    View outline_input_email;
    View outline_input_name;
    View outline_input_password;
    View outline_input_phonenumber;
    Button buttonSignin;
    Button buttonSignUp;
    Button buttonEye;
    ImageView imageEye;
    TextView placeholderName;
    TextView placeholderEmail;
    TextView placeholderPhonenumber;
    TextView placeholderPassword;
    private TextView textError;
    RegisterController registerController;
    ImageButton radioButton;
    TextView textRadio;
    Animation clickAnimation;
    @SuppressLint("ResourceAsColor")
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
        outline_input_phonenumber = findViewById(R.id.outline_input_phonenumber);
        inputPhoneNumber = findViewById(R.id.input_phonenumber);
        placeholderName = findViewById(R.id.textPlaceholderName);
        placeholderEmail = findViewById(R.id.textPlaceholderEmail);
        placeholderPhonenumber = findViewById(R.id.textPlaceholderPhonenumber);
        placeholderPassword = findViewById(R.id.textPlaceholderPassword);
        textRadio = findViewById(R.id.text_radio);
        radioButton = findViewById(R.id.radioButton);
        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);
        clearValidationError();
        String fullText = "By signing up you agree to the Terms of service and Privacy policy";
        SpannableString spannableString = new SpannableString(fullText);
        int startIndex = fullText.indexOf("Terms of service");
        int endIndex = startIndex + "Terms of service".length();
        spannableString.setSpan(new ForegroundColorSpan(R.color.yellow), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        startIndex = fullText.indexOf("Privacy policy");
        endIndex = startIndex + "Privacy policy".length();
        spannableString.setSpan(new ForegroundColorSpan(R.color.yellow), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textRadio.setText(spannableString);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(clickAnimation);
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                String phoneNumber = inputPhoneNumber.getText().toString();
                User user = new User(name,email,phoneNumber,password);
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
        inputPhoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                registerController.eventFocusPhoneNumber(hasFocus);
            }
        });
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerController.onRadioButtonClicked();
            }
        });
    }

    @Override
    public void navigateToLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(RegisterActivity.this, ContainerPageActivity.class);
        startActivity(intent);
    }

    @Override
    public void eventFocusName(boolean hasFocus) {
        if (hasFocus) {
            outline_input_name.setBackgroundResource(R.drawable.blue_input_backgroud);
            placeholderName.setText("");
        } else {
            outline_input_name.setBackgroundResource(R.drawable.white_input_backgroud);
            if (inputName.getText().toString().isEmpty()){
                placeholderName.setText("Fullname");
            }
        }
    }

    @Override
    public void eventFocusEmail(boolean hasFocus) {
        if (hasFocus) {
            outline_input_email.setBackgroundResource(R.drawable.blue_input_backgroud);
            placeholderEmail.setText("");
        } else {
            outline_input_email.setBackgroundResource(R.drawable.white_input_backgroud);
            if (inputEmail.getText().toString().isEmpty()){
                placeholderName.setText("Email or phone number");
            }
        }
    }

    @Override
    public void eventFocusPassword(boolean hasFocus) {
        if (hasFocus) {
            outline_input_password.setBackgroundResource(R.drawable.blue_input_backgroud);
            placeholderPassword.setText("");
        } else {
            outline_input_password.setBackgroundResource(R.drawable.white_input_backgroud);
            if (inputPassword.getText().toString().isEmpty()){
                placeholderPassword.setText("Enter your password");
            }
        }
    }

    @Override
    public void eventFocusPhoneNumber(boolean hasFocus) {
        if (hasFocus) {
            outline_input_phonenumber.setBackgroundResource(R.drawable.blue_input_backgroud);
            placeholderPhonenumber.setText("");
        } else {
            outline_input_phonenumber.setBackgroundResource(R.drawable.white_input_backgroud);
            if (inputPhoneNumber.getText().toString().isEmpty()){
                placeholderPhonenumber.setText("Your mobile number");
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
    public void showValidationError(String errorText) {
        textError.setText(errorText);
    }
    @Override
    public void clearValidationError() {
        textError.setText("");
    }

    @Override
    public void setRadioButton(boolean check) {
        radioButton.setBackgroundResource(check ? R.drawable._check_circle : R.drawable._circle);
    }
}
