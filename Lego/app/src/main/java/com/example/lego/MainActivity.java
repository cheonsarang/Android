package com.example.lego;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lego.gridview.GridFragment;
import com.example.lego.listview.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.container1, new ListFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container2, new GridFragment()).commit();

    }
}