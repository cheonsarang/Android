package com.example.and14_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.and14_allview.bteam_listview.CyaFragment;
import com.example.and14_allview.gridview.GridFragment;
import com.example.and14_allview.listview.ListFragment;
import com.example.and14_allview.recycleview.RecyclerFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //ListView, GridView, RecycleView(많이 사용)
    //Adapter(사용자가 구현하려는 모양이 각각 다르기때문에 각각 위젯들을 어댑터라는 규칙을 통해서 구현)
    ArrayList<Button> btn_list = new ArrayList<>();
    Button btn_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_list.add(findViewById(R.id.btn_listview));
        btn_list.add(findViewById(R.id.btn_gridview));
        btn_list.add(findViewById(R.id.btn_rcvview));
        btn_list.add(findViewById(R.id.btn_pj));

        for(int i = 0; i < btn_list.size(); i++) {
            btn_list.get(i).setOnClickListener(this);
        }


        //1. ViewGroup <- Layout종류를 준비 : 프래그먼트가 붙을 공간 마련
        //2. Fragment <- ↑를 붙일 프래그먼트를 준비
        //3. FragmentManager : 붙임(코딩) == 두가지 1, 2번 통해 replace 기능을 사용

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_listview) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ListFragment()).commit();
        }else if(v.getId() == R.id.btn_gridview) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new GridFragment()).commit();
        }else if(v.getId() == R.id.btn_pj) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new CyaFragment()).commit();
        }else if(v.getId() == R.id.btn_rcvview) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new RecyclerFragment()).commit();
        }
    }
}