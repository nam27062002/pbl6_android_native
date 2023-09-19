package com.pbl.app_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pbl.app_mobile.controller.WelcomeController;
import com.pbl.app_mobile.data.ContentStart;
import com.pbl.app_mobile.data.ContentStartAppList;
import com.pbl.app_mobile.utils.RectangleCreator;
import com.pbl.app_mobile.view.WelcomeView;

public class MainActivity extends AppCompatActivity implements WelcomeView {


    private RectangleCreator rectangleCreator;
    private GestureDetector gestureDetector;

    private TextView titleTextView;
    private TextView contentTextView;
    private ImageView imageView;
    private Button buttonGetStarted;
    private LinearLayout linearLayout;
    Animation clickAnimation;
    private WelcomeController welcomeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        welcomeController = new WelcomeController(this);
        clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);
        titleTextView = findViewById(R.id.text_title);
        contentTextView = findViewById(R.id.text_content);
        imageView = findViewById(R.id.image_overview);
        buttonGetStarted = findViewById(R.id.button_get_started);
        linearLayout = findViewById(R.id.linearLayout);
        welcomeController.getCurrentUI();
        buttonGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(clickAnimation);
                welcomeController.navigateToLogin();
            }
        });
        setupGestureDetection();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }



    private void setupGestureDetection() {
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                welcomeController.eventSwipeHorizontal(e1,e2);
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }


    @Override
    public void navigateToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void setCurrentUI(ContentStartAppList contentsStartApp,int size){
        rectangleCreator = new RectangleCreator(this, linearLayout, size, 0);
        rectangleCreator.createRectangles();
    }

    @Override
    public void updateContentPage(ContentStart contentStart,int target){
        titleTextView.setText(contentStart.title);
        contentTextView.setText(contentStart.content);
        imageView.setImageResource(contentStart.srcIndex);
        rectangleCreator.changeTarget(target);
        if (rectangleCreator.isTargetEnd()) {
            buttonGetStarted.setVisibility(View.VISIBLE);
        } else {
            buttonGetStarted.setVisibility(View.GONE);
        }
    }
}
