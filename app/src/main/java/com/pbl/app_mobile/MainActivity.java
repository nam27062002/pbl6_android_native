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

import com.pbl.app_mobile.data.ContentStart;
import com.pbl.app_mobile.data.ContentStartAppList;
import com.pbl.app_mobile.utils.RectangleCreator;

public class MainActivity extends AppCompatActivity {

    // input
    private RectangleCreator rectangleCreator;
    private GestureDetector gestureDetector;

    // component UI
    private TextView titleTextView;
    private TextView contentTextView;
    private ImageView imageView;
    private Button getStartedButton;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        getComponentUI();
        ContentStartAppList contentsStartApp = new ContentStartAppList();
        int size = contentsStartApp.contentStartApps.size();

        rectangleCreator = new RectangleCreator(this, linearLayout, size, 0);
        rectangleCreator.createRectangles();
        updateContentPage(contentsStartApp.contentStartApps.get(rectangleCreator.getTarget()));

        setupGestureDetection(contentsStartApp);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private void getComponentUI() {
        titleTextView = findViewById(R.id.text_title);
        contentTextView = findViewById(R.id.text_content);
        imageView = findViewById(R.id.image_overview);
        getStartedButton = findViewById(R.id.button_get_started);
        linearLayout = findViewById(R.id.linearLayout);
        final Animation clickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(clickAnimation);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupGestureDetection(ContentStartAppList contentsStartApp) {
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (e1.getX() - e2.getX() > 50) {
                    rectangleCreator.incrementTarget();
                    updateContentPage(contentsStartApp.contentStartApps.get(rectangleCreator.getTarget()));
                } else if (e2.getX() - e1.getX() > 50) {
                    rectangleCreator.decrementTarget();
                    updateContentPage(contentsStartApp.contentStartApps.get(rectangleCreator.getTarget()));
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }

    private void updateContentPage(ContentStart content) {
        titleTextView.setText(content.title);
        contentTextView.setText(content.content);
        imageView.setImageResource(content.srcIndex);

        if (rectangleCreator.isTargetEnd()) {
            getStartedButton.setVisibility(View.VISIBLE);
        } else {
            getStartedButton.setVisibility(View.GONE);
        }
    }
}
