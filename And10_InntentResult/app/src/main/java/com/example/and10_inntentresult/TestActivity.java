package com.example.and10_inntentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent1 = getIntent();
        LoginDTO dto = (LoginDTO) intent1.getSerializableExtra("dto");
        String test = intent1.getStringExtra("test");
        int ah = intent1.getIntExtra("int",0);

        Log.d("아", "onCreate: " + test);
        Log.d("아", "onCreate: " + dto.getId() + dto.getPw());
        Log.d("아", "onCreate: " + ah);

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reIntent = new Intent();
                reIntent.putExtra("test", "테스트가 끝남");
                //결과 코드를 지정
                setResult(RESULT_OK, reIntent);

                //액티비티를 종결함
                finish();
            }
        });




    }
}