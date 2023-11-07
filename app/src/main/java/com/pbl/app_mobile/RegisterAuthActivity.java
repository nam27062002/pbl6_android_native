package com.pbl.app_mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pbl.app_mobile.model.BEAN.User;

public class RegisterAuthActivity extends AppCompatActivity {
    private EditText inputPassword;
    private View outline_input_password;
    private TextView textPlaceholderPassword;
    private Button signIn;
    Animation clickAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_auth);
        inputPassword = findViewById(R.id.input_email);
        outline_input_password = findViewById(R.id.outline_input_email);
        textPlaceholderPassword = findViewById(R.id.textPlaceholderEmail);
        signIn = findViewById(R.id.button_finish);
        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);
        inputPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
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
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(clickAnimation);
                Intent intent = new Intent(RegisterAuthActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
