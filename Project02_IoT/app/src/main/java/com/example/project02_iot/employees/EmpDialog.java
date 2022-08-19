package com.example.project02_iot.employees;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.project02_iot.R;

public class EmpDialog extends Dialog {

    public EmpDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //다이얼로그랑 연결될 디자인을 준비( layout )
        setContentView(R.layout.dialog_emp);
        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();//다이얼로그가 안보이게 하는 처리
            }
        });
    }
}
