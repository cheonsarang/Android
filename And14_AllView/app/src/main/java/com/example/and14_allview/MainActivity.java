package com.example.and14_allview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.and14_allview.listview.ListFragment;

public class MainActivity extends AppCompatActivity {
    //ListView, GridView, RecycleView(많이 사용)
    //Adapter(사용자가 구현하려는 모양이 각각 다르기때문에 각각 위젯들을 어댑터라는 규칙을 통해서 구현)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1. ViewGroup <- Layout종류를 준비 : 프래그먼트가 붙을 공간 마련
        //2. Fragment <- ↑를 붙일 프래그먼트를 준비
        //3. FragmentManager : 붙임(코딩) == 두가지 1, 2번 통해 replace 기능을 사용
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ListFragment()).commit();
    }
}