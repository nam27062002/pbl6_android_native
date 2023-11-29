package com.pbl.app_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pbl.app_mobile.controller.ChangePasswordController;
import com.pbl.app_mobile.view.ChangePasswordView;

public class ChangePasswordActivity extends AppCompatActivity implements ChangePasswordView {
    private EditText inputOldPassword;
    private EditText inputNewPassword;
    private EditText inputReNewPassword;
    private ImageButton btEyeOle;
    private ImageButton btEyeNew;
    private ImageButton btEyeReNew;
    private Button btSave;
    private TextView txtError ;
    private TextView holderOle ;
    private TextView holderNew ;
    private TextView holderReNew ;
    Animation clickAnimation;
    private ChangePasswordController changePasswordController;
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
        btSave = findViewById(R.id.savechangeP);
        holderOle = findViewById(R.id.holderOld);
        holderNew = findViewById(R.id.holderNew);
        holderReNew = findViewById(R.id.holderReNew);
        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);
        txtError = findViewById(R.id.txt_error);

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
                btSave.setVisibility(View.VISIBLE);
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
            holderOle.setText("");
        } else {
            if (inputOldPassword.getText().toString().isEmpty()){
                holderOle.setText("Enter Your Old Password");
            }
        }
    }
    @Override
    public void eventFocusNewPassword(boolean hasFocus) {
        if (hasFocus) {
            holderNew.setText("");
        } else {
            if (inputNewPassword.getText().toString().isEmpty()){
                holderNew.setText("Enter New Password");
            }
        }
    }
    @Override
    public void eventFocusReNewPassword(boolean hasFocus) {
        if (hasFocus) {
            holderReNew.setText("");
        } else {
            if (inputReNewPassword.getText().toString().isEmpty()){
                holderReNew.setText("Re-Enter New Password");
            }
        }
    }
    @Override
    public void showHideOldPassword(boolean isActive) {
        if (isActive){
            btEyeOle.setBackgroundResource(R.drawable.eye_open);
            inputOldPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else{
            btEyeOle.setBackgroundResource(R.drawable.eye_off);
            inputOldPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
    @Override
    public void showHideNewPassword(boolean isActive) {
        if (isActive){
            btEyeNew.setBackgroundResource(R.drawable.eye_open);
            inputNewPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else{
            btEyeNew.setBackgroundResource(R.drawable.eye_off);
            inputNewPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
    @Override
    public void showHideReNewPassword(boolean isActive) {
        if (isActive){
            btEyeReNew.setBackgroundResource(R.drawable.eye_open);
            inputReNewPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else{
            btEyeReNew.setBackgroundResource(R.drawable.eye_off);
            inputReNewPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

}
