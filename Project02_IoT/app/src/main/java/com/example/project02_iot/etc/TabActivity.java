package com.example.project02_iot.etc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.project02_iot.R;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {
    TabLayout tabs;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        toolbar = findViewById(R.id.tollbar);
        /*actionbar <= 현재상태 noActionbar 이기때문에 우리가 만든 툴바를 이용해서 액션바 대체*/
        setSupportActionBar(toolbar);

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));
        tabs.addTab(tabs.newTab().setText("차단목록"));

        //getSupportFragmentManager().beginTransaction().replace(R.id.container, new TabFragment()).commit();

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition(); //0번부터

                getSupportFragmentManager().beginTransaction().replace(R.id.container, new TabFragment(pos+1)).commit();


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    //onCreate 메소드가 끝나면 옵션메뉴를 붙일 수 있는 생명주기가 따로 있음
    //override를 통해 재정의를 해놨으면 실행해줌


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int pos =0;
        if(item.getItemId() == R.id.menu1) {
            pos = 1;
        }else if(item.getItemId() == R.id.menu2) {
            pos = 2;
        }else if(item.getItemId() == R.id.menu3) {
            pos = 3;
        }else if(item.getItemId() == R.id.menu4) {
            pos = 4;
        }
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new TabFragment(pos+1)).commit();

        return super.onOptionsItemSelected(item);
    }
}