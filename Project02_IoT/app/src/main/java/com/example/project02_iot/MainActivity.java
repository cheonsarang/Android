package com.example.project02_iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.project02_iot.common.CommonVal;
import com.example.project02_iot.conn.CommonAskTask;
import com.example.project02_iot.customer.CusFragment;
import com.example.project02_iot.employees.EmpFragment;
import com.example.project02_iot.etc.TabActivity;
import com.example.project02_iot.notice.NoticeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //Button btn_tab;
    BottomNavigationView btm_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //changeFragment(new CusFragment());

        btm_nav = findViewById(R.id.btm_nav);

        /*btn_tab = findViewById(R.id.btn_tab);

        btn_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TabActivity.class);
                startActivity(intent);
            }
        });*/
        /*
        로그인 되었을 때만 메인으로 넘어올 수 있도록 해놓음
        if(CommonVal.loginInfo != null) {
            Log.d("로그", "onCreate: 로그인 정보가 있음");
        }else {
            // 로그인 화면으로 다시 이동을 시키거나 토스트창을 보여준뒤 몇초후에 종료 강제
            //finish();
            Log.d("로그", "onCreate: 로그인 정보가 없음");
        }
        */
        /*CommonAskTask askTask = new CommonAskTask(this, "list.ccu");
        askTask.addParams("data", "csr");
        askTask.excuteAsk(new CommonAskTask.AsynchTaskCallBack() {
            @Override
            public void onResult(String data, boolean isResult) {
                Log.d("로그", "onResult: " + data);
            }
        });*/
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new CusFragment()).commit();
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_cus){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new CusFragment()).commit();
                }else if(item.getItemId() == R.id.menu_emp) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new EmpFragment()).commit();
                }else if(item.getItemId() == R.id.menu_noti) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new NoticeFragment()).commit();
                }
                return true;
            }
        });

        /*
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if(item.getItemId()==R.id.menu_cus){
                    fragment = new CusFragment();
                }else if(item.getItemId()==R.id.menu_emp){
                    fragment = new HrFragment();

                }else if(item.getItemId()==R.id.menu_noti){
                    fragment = new NoticeFragment();
                }
                if(fragment==null) return false;

                changeFragment(fragment);
                return true;
            }
        });
        */
    }



     /*public void changeFragment(Fragment fragment){

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }*/


}

