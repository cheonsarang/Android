package com.example.test01_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_img1, btn_img2;
    ImageView imgv1, imgv2, imgv3, imgv4;
    int cnt = 0;
    int cnt1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_img1 = findViewById(R.id.btn_img1);
        btn_img2 = findViewById(R.id.btn_img2);
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);
        imgv4 = findViewById(R.id.imgv4);

        btn_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;
                if(cnt == 1) {
                    imgv1.setVisibility(View.VISIBLE);
                    imgv2.setVisibility(View.GONE);
                }else if(cnt == 2) {
                    imgv2.setVisibility(View.VISIBLE);
                    imgv1.setVisibility(View.GONE);
                    cnt = 0;
                }
            }
        });

        btn_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt1++;
                if(cnt1 == 1) {
                    imgv3.setVisibility(View.VISIBLE);
                    imgv4.setVisibility(View.GONE);
                }else if(cnt1 == 2) {
                    imgv4.setVisibility(View.VISIBLE);
                    imgv3.setVisibility(View.GONE);
                    cnt1 = 0;
                }
            }
        });
    }



    @Override
    public void onClick(View v) {

    }
}