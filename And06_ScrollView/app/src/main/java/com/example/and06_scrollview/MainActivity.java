package com.example.and06_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_txt = findViewById(R.id.tv_txt);

        tv_txt.setText("CSR");

        //append <- 기존 글씨에 현재 붙일 String을 더한다
        for(int i = 0; i < 100; i++){
            tv_txt.append("쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕쿠쿠루삥뽕");
        }

    }

    @Override
    public void onClick(View v) {

    }
}