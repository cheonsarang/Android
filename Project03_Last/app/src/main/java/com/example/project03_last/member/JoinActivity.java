package com.example.project03_last.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.project03_last.AndVO;
import com.example.project03_last.R;
import com.example.project03_last.conn.CommonConn;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

public class JoinActivity extends AppCompatActivity {
    TextInputEditText edt_id, edt_pw, edt_name;
    RadioGroup rdo_grp;
    Button btn_join, btn_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_name = findViewById(R.id.edt_name);
        rdo_grp = findViewById(R.id.rdo_grp);
        btn_join = findViewById(R.id.btn_join);
        btn_close = findViewById(R.id.btn_close);

        Intent intent = getIntent();
        edt_id.setText(intent.getStringExtra("email"));
        if(edt_id.getText().toString().length() > 1) {
            edt_id.setEnabled(false);
        }

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndVO vo = new AndVO();
                vo.setEmail(edt_id.getText()+"");
                vo.setPw(edt_pw.getText()+"");
                vo.setName(edt_name.getText()+"");
                if( rdo_grp.getCheckedRadioButtonId() == R.id.rdo_man) {
                    vo.setGender("남");
                }else {
                    vo.setGender("여");
                }

                CommonConn conn = new CommonConn(JoinActivity.this, "join");
                conn.addParams("vo", new Gson().toJson(vo));
                conn.excuteConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {

                    }
                });

            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}