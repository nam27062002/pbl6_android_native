package com.pbl.app_mobile;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.pbl.app_mobile.controller.VerifyAccountController;
import com.pbl.app_mobile.view.VerifyAccountView;

import java.util.ArrayList;
import java.util.List;

public class VerifyAccount extends AppCompatActivity implements VerifyAccountView {

    List<TextView> textViews;
    List<Button> numberButtons;
    ImageButton delButton;
    ImageButton checkCodeButton;
    TextView timerTextview;
    VerifyAccountController controller;
    final Handler handler = new Handler();
    Runnable runnable;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_account);
        textViews = new ArrayList<>();
        controller = new VerifyAccountController(this);
        numberButtons = new ArrayList<>();
        textViews.add(findViewById(R.id.num1));
        textViews.add(findViewById(R.id.num2));
        textViews.add(findViewById(R.id.num3));
        textViews.add(findViewById(R.id.num4));
        delButton = findViewById(R.id.buttonDel);
        timerTextview = findViewById(R.id.timer);
        checkCodeButton = findViewById(R.id.buttonCheck);

        for (int i = 0; i <= 9; i++) {
            final int buttonValue = i;
            Button button = findViewById(getResources().getIdentifier("button" + i, "id", getPackageName()));
            numberButtons.add(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    controller.SetText(String.valueOf(buttonValue));
                }
            });
        }
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.DelHandle();
            }
        });
        RemoveAllText();

        runnable = new Runnable() {
            @Override
            public void run() {
                controller.GetTimer();
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);
    }

    @Override
    public void RemoveAllText() {
        for(TextView textView : textViews){
            textView.setText("");
        }
    }

    @Override
    public void SetText(int index, String text) {
        textViews.get(index).setText(text);
    }

    @Override
    public void DelHandle(int index) {
        textViews.get(index).setText("");
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void SetTimerCode(String timer,int s) {
        this.timerTextview.setText(timer);
        if (s < 0){
            timerTextview.setTextColor(R.color.grey2);
        }
    }

}
