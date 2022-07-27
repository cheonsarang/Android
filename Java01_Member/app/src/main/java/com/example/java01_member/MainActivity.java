package com.example.java01_member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    MemberClass mem = new MemberClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("public", "onClick: "+ mem.public_str);
                Log.d("default", "onClick: " + mem.default_a);
                Log.d("private", "private는 클래스 내부에서만 사용 가능");

            }
        });
    }
}