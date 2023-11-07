package com.pbl.app_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class MenuActivity extends AppCompatActivity {
    Button homeButton;
    Button aboutButton;
    Button settingsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        homeButton = findViewById(R.id.buttonHome);
        aboutButton = findViewById(R.id.btabout);
        settingsButton = findViewById(R.id.btset);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
