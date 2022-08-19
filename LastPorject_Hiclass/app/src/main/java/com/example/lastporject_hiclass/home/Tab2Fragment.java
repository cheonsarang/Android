package com.example.lastporject_hiclass.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lastporject_hiclass.R;


public class Tab2Fragment extends Fragment implements View.OnClickListener{
    ImageView tab2_imgv1, tab2_imgv2, tab2_imgv3;
    TextView tab2_tv1, tab2_tv2, tab2_tv3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab2, container, false);

        tab2_imgv1 = v.findViewById(R.id.tab2_imgv1);
        tab2_imgv2 = v.findViewById(R.id.tab2_imgv2);
        tab2_imgv3 = v.findViewById(R.id.tab2_imgv3);
        tab2_tv1 = v.findViewById(R.id.tab2_tv1);
        tab2_tv2 = v.findViewById(R.id.tab2_tv2);
        tab2_tv3 = v.findViewById(R.id.tab2_tv3);

        tab2_imgv1.setOnClickListener(this);
        tab2_imgv2.setOnClickListener(this);
        tab2_imgv3.setOnClickListener(this);
        tab2_tv1.setOnClickListener(this);
        tab2_tv2.setOnClickListener(this);
        tab2_tv3.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext() , Home_in_Activity.class);
        if(v.getId() == R.id.tab2_imgv1 || getId() == R.id.tab2_tv1) {
            intent.putExtra("page","tab2");
            intent.putExtra("title", "안전수칙");
            intent.putExtra("content_title", "여름철 물놀이, 이것만은 꼭 기억해요!");
            intent.putExtra("content", "즐거운 여름방학, 우리 모두 안전하게 물놀이해요!");
            intent.putExtra("imgv_home", "1");
            intent.putExtra("tv_like", "184");
        }else if(v.getId() == R.id.tab2_imgv2 || getId() == R.id.tab2_tv2) {
            intent.putExtra("page","tab2");
            intent.putExtra("title", "안전수칙");
            intent.putExtra("content_title", "폭염&집중 호우 예방 안전 수칙");
            intent.putExtra("content", "폭염과 태풍을 예방해 안전한 여름을 보내요");
            intent.putExtra("imgv_home", "2");
            intent.putExtra("tv_like", "273");
        }else if(v.getId() == R.id.tab2_imgv3 || getId() == R.id.tab2_tv3) {
            intent.putExtra("page","tab2");
            intent.putExtra("title", "기타정보");
            intent.putExtra("content_title", "아동안전지킴이집이란?");
            intent.putExtra("content", "출처 : 대구강북경찰서 여성청소년계");
            intent.putExtra("imgv_home", "3");
            intent.putExtra("tv_like", "712");
        }
        getContext().startActivity(intent);
    }
}