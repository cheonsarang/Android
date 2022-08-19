package com.example.lastporject_hiclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.lastporject_hiclass.calendar.CalendarFragment;
import com.example.lastporject_hiclass.classs.ClassFragment;
import com.example.lastporject_hiclass.hitalk.HitalkFragment;
import com.example.lastporject_hiclass.home.HomeFragment;
import com.example.lastporject_hiclass.more.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btm_nav = findViewById(R.id.btm_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.tab1) {
                    Log.d("탭", "onNavigationItemSelected: 탭1");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                }else if(item.getItemId() == R.id.tab2) {
                    Log.d("탭", "onNavigationItemSelected: 탭2");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new ClassFragment()).commit();
                }else if(item.getItemId() == R.id.tab3) {
                    Log.d("탭", "onNavigationItemSelected: 탭3");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HitalkFragment()).commit();
                }else if(item.getItemId() == R.id.tab4) {
                    Log.d("탭", "onNavigationItemSelected: 탭4");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new CalendarFragment(MainActivity.this)).commit();
                }else if(item.getItemId() == R.id.tab5) {
                    Log.d("탭", "onNavigationItemSelected: 탭5");
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new MoreFragment()).commit();
                }
                return true;
            }
        });




    }
}