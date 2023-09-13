package com.pbl.app_mobile;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    // component UI
    EditText inputEmail;
    View outLineInputEmail;
    EditText inputPassword;
    View outLineInputPassword;
    Button buttonEye;
    Button buttonRegister;
    ImageView imageEye;
    // value
    Boolean showPassword = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getComponentUI();
    }
    private void getComponentUI() {
        inputEmail =  findViewById(R.id.input_email);
        outLineInputEmail = findViewById(R.id.outline_input_email);
        inputPassword = findViewById(R.id.input_password);
        outLineInputPassword = findViewById(R.id.outline_input_password);
        buttonEye = findViewById(R.id.button_eye);
        imageEye = findViewById(R.id.image_eye);
        buttonRegister = findViewById(R.id.button_register);
        // change outline color inputfield
        HashMap<EditText,View> inputsMap = new HashMap<>();
        inputsMap.put(inputEmail,outLineInputEmail);
        inputsMap.put(inputPassword,outLineInputPassword);
        for (EditText key : inputsMap.keySet()) {
            key.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        inputsMap.get(key).setBackgroundResource(R.drawable.blue_input_backgroud);
                    } else {
                        inputsMap.get(key).setBackgroundResource(R.drawable.white_input_backgroud);
                    }
                }
            });
        }

        // set event click register
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        // set event click button eye
        buttonEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPassword = !showPassword;
                if (showPassword){
                    imageEye.setImageResource(R.drawable.view);
                    inputPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else{
                    imageEye.setImageResource(R.drawable.hide);
                    inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

    }

}
