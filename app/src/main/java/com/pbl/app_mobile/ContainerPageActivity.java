package com.pbl.app_mobile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ContainerPageActivity extends AppCompatActivity {

    BottomNavigationView menu;
    HomeFragment homeFragment;
    OrderFragment orderFragment;
    HistoryFragment historyFragment;
    MenuFragment menuFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_page);
        menu = findViewById(R.id.menu);
        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        historyFragment = new HistoryFragment();
        menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                } else if (item.getItemId() == R.id.order) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,orderFragment).commit();
                }else  if (item.getItemId() == R.id.history) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,historyFragment).commit();
                } else  if (item.getItemId() == R.id.menu) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,menuFragment).commit();
                }
//

                return true;
            }
        });
    }
}
