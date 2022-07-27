package com.example.and05_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int cnt1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_img1 = findViewById(R.id.btn_img1);
        Button btn_img2 = findViewById(R.id.btn_img2);
        ImageView imgv1 = findViewById(R.id.imgv1);
        ImageView imgv2 = findViewById(R.id.imgv2);
        ImageView imgv3 = findViewById(R.id.imgv3);
        btn_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt1++;

                if(cnt1 == 1) {
                    imgv3.setVisibility(View.GONE);
                    imgv2.setVisibility(View.GONE);
                    imgv1.setVisibility(View.VISIBLE);
                    Log.d("akaeofh",  ""+cnt1);
                }else if(cnt1 == 2) {
                    imgv3.setVisibility(View.GONE);
                    imgv2.setVisibility(View.VISIBLE);
                    Log.d("akaeofh",  ""+cnt1);

                }else if(cnt1 == 3) {
                    imgv1.setVisibility(View.GONE);
                    imgv2.setVisibility(View.GONE);
                    imgv3.setVisibility(View.VISIBLE);
                    cnt1 = 0;
                    Log.d("akaeofh",  ""+cnt1);
                }
            }
        });

        btn_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt1--;
                if(cnt1 == 2 || cnt1 == -1) {
                    imgv1.setVisibility(View.GONE);
                    imgv3.setVisibility(View.GONE);
                    imgv2.setVisibility(View.VISIBLE);
                    cnt1 = 2;
                }else if(cnt1 == 1) {
                    imgv1.setVisibility(View.VISIBLE);
                    imgv2.setVisibility(View.GONE);
                }else if(cnt1 == 0) {
                    imgv1.setVisibility(View.GONE);
                    imgv2.setVisibility(View.GONE);
                    imgv3.setVisibility(View.VISIBLE);
                }


            }
        });

    }

    @Override
    public void onClick(View v) {

    }

}