package com.example.lastporject_hiclass.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lastporject_hiclass.R;
import com.google.android.material.tabs.TabLayout;

public class Home_in_Activity extends AppCompatActivity {

    TextView title, content, tv_like, content_title;
    ImageView imgv_home;
    LinearLayout like_line;
    TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_in);

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        content_title = findViewById(R.id.content_title);
        tv_like = findViewById(R.id.tv_like);
        imgv_home = findViewById(R.id.imgv_home);
        like_line = findViewById(R.id.like_line);
        tabs = findViewById(R.id.tabs);
        Intent intent = getIntent();

         if(intent.getStringExtra("page").equals("home")) {
             title.setText(intent.getStringExtra("title"));
             content_title.setText((intent.getStringExtra("content_title")));
             if(intent.getStringExtra("content").equals("없애")) {
                 content.setVisibility(View.GONE);
             }else {
                 content.setText(intent.getStringExtra("content"));
             }
             tv_like.setText((intent.getStringExtra("tv_like")));
             if(intent.getStringExtra("imgv_home").equals("없애")) {
                 imgv_home.setVisibility(View.GONE);
             }else if(intent.getStringExtra("imgv_home").equals("1")) {
                 imgv_home.setImageResource( R.drawable.image24);
             }else if(intent.getStringExtra("imgv_home").equals("2")) {
                 imgv_home.setImageResource(R.drawable.image14);
             }else if(intent.getStringExtra("imgv_home").equals("3")) {
                 imgv_home.setImageResource(R.drawable.image13);
             }else if(intent.getStringExtra("imgv_home").equals("4")) {
                 imgv_home.setImageResource(R.drawable.image12);
             }else if(intent.getStringExtra("imgv_home").equals("5")) {
                 imgv_home.setImageResource(R.drawable.image11);
             }
         }else if(intent.getStringExtra("page").equals("tab1")) {
             title.setText(intent.getStringExtra("title"));
             content_title.setText((intent.getStringExtra("content_title")));
             content.setText(intent.getStringExtra("content"));
             if(intent.getStringExtra("like_line").equals("없애")) {
                 like_line.setVisibility(View.GONE);
             }
             if(intent.getStringExtra("imgv_home").equals("없애")) {
                 imgv_home.setVisibility(View.GONE);
             }
         }else if(intent.getStringExtra("page").equals("tab2")) {
             title.setText(intent.getStringExtra("title"));
             content_title.setText((intent.getStringExtra("content_title")));
             content.setText(intent.getStringExtra("content"));
             if(intent.getStringExtra("imgv_home").equals("1")) {
                 imgv_home.setImageResource( R.drawable.tab_img3);
             }else if(intent.getStringExtra("imgv_home").equals("2")) {
                 imgv_home.setImageResource( R.drawable.tab_img1);
             }else if(intent.getStringExtra("imgv_home").equals("3")) {
                 imgv_home.setImageResource( R.drawable.child_long);
             }
             tv_like.setText((intent.getStringExtra("tv_like")));
         }else if(intent.getStringExtra("page").equals("tab3")) {
             title.setText(intent.getStringExtra("title"));
             content_title.setText((intent.getStringExtra("content_title")));
             content.setText(intent.getStringExtra("content"));
             if(intent.getStringExtra("imgv_home").equals("없애")) {
                 imgv_home.setVisibility(View.GONE);
             }
             tv_like.setText((intent.getStringExtra("tv_like")));
         }else if(intent.getStringExtra("page").equals("all")) {
             title.setText(intent.getStringExtra("title"));
             if(intent.getStringExtra("content_title").equals("없애")) {
                 content_title.setVisibility(View.GONE);
             }
             if(intent.getStringExtra("content").equals("없애")) {
                 content.setVisibility(View.GONE);
             }
             if(intent.getStringExtra("like_line").equals("없애")) {
                 like_line.setVisibility(View.GONE);
             }
             if(intent.getStringExtra("imgv_home").equals("1")) {
                 imgv_home.setImageResource( R.drawable.ban8);
             }
         }









    }
}