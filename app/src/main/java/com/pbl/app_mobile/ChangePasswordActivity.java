package com.pbl.app_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pbl.app_mobile.controller.ChangePasswordController;
import com.pbl.app_mobile.view.ChangePasswordView;

public class ChangePasswordActivity extends AppCompatActivity implements ChangePasswordView {
    private EditText inputOldPassword;
    private EditText inputNewPassword;
    private EditText inputReNewPassword;
    private Button btEyeOle;
    private Button btEyeNew;
    private Button btEyeReNew;
    private final TextView txtError = new TextView(this);
    private final TextView holderOle = new TextView(this);
    private final TextView holderNew = new TextView(this);
    private final TextView holderReNew = new TextView(this);
    Animation clickAnimation;
    private ChangePasswordController changePasswordController;
    CharSequence hint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        inputOldPassword = findViewById(R.id.current_p);
        inputNewPassword = findViewById(R.id.new_p);
        inputReNewPassword = findViewById(R.id.re_e_p);
        btEyeOle = findViewById(R.id.eye1);
        btEyeNew = findViewById(R.id.eye2);
        btEyeReNew = findViewById(R.id.eye3);
        Button btSave = findViewById(R.id.save);
        hint = inputOldPassword.getHint();
        if (hint != null) {
            holderOle.setText(hint);
        }
        hint = inputNewPassword.getHint();
        if (hint != null) {
            holderNew.setText(hint);
        }
        hint = inputReNewPassword.getHint();
        if (hint != null) {
            holderReNew.setText(hint);
        }
        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);

        changePasswordController = new ChangePasswordController(this,this);
        clearValidationError();

        btEyeOle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePasswordController.changeStatusOldPassword();
            }
        });
        btEyeNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePasswordController.changeStatusNewPassword();
            }
        });
        btEyeReNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePasswordController.changeStatusReNewPassword();
            }
        });
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(clickAnimation);
                String oldPassword = inputOldPassword.getText().toString();
                String newPassword = inputNewPassword.getText().toString();
                String reNewPassword = inputReNewPassword.getText().toString();
                changePasswordController.validatePassword(oldPassword,newPassword,reNewPassword);
            }
        });
        inputOldPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                changePasswordController.eventFocusOldPassword(hasFocus);
            }
        });
        inputNewPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                changePasswordController.eventFocusNewPassword(hasFocus);
            }
        });
        inputReNewPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                changePasswordController.eventFocusReNewPassword(hasFocus);
            }
        });
    }
    
    @Override
    public void showValidationError(String message) {
        txtError.setText(message);
    }
    @Override
    public void navigateToHome() {
        Intent intent = new Intent(ChangePasswordActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    @Override
    public void clearValidationError() {
        txtError.setText("");
    }
    @Override
    public void eventFocusOldPassword(boolean hasFocus) {
        if (hasFocus) {
            inputOldPassword.setHint("");
        } else {
            if (inputOldPassword.getText().toString().isEmpty()){
                inputOldPassword.setHint("");
            }
        }
    }
    @Override
    public void eventFocusNewPassword(boolean hasFocus) {
        if (hasFocus) {
            inputNewPassword.setHint("");
        } else {
            if (inputNewPassword.getText().toString().isEmpty()){
                inputNewPassword.setHint("");
            }
        }
    }
    @Override
    public void eventFocusReNewPassword(boolean hasFocus) {
        if (hasFocus) {
            inputReNewPassword.setHint("");
        } else {
            if (inputReNewPassword.getText().toString().isEmpty()){
                inputReNewPassword.setHint("");
            }
        }
    }
    @Override
    public void showHideOldPassword(boolean isActive) {
        if (isActive){
            btEyeOle.setBackgroundResource(R.drawable.view);
            inputOldPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else{
            btEyeOle.setBackgroundResource(R.drawable.hide);
            inputOldPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
    @Override
    public void showHideNewPassword(boolean isActive) {
        if (isActive){
            btEyeNew.setBackgroundResource(R.drawable.view);
            inputNewPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else{
            btEyeNew.setBackgroundResource(R.drawable.hide);
            inputNewPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
    @Override
    public void showHideReNewPassword(boolean isActive) {
        if (isActive){
            btEyeReNew.setBackgroundResource(R.drawable.view);
            inputReNewPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else{
            btEyeReNew.setBackgroundResource(R.drawable.hide);
            inputReNewPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

}
