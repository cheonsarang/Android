package com.example.lastporject_hiclass.classs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastporject_hiclass.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ClassFragment extends Fragment implements View.OnClickListener{
    RecyclerView recview_class;
    FrameLayout fl_serach;
    LinearLayout ll_serach;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_class, container, false);
        recview_class = v.findViewById(R.id.recview_class);
        fl_serach = v.findViewById(R.id.fl_serach);
        ll_serach = v.findViewById(R.id.ll_serach);
        fl_serach.setOnClickListener(this);
        ll_serach.setOnClickListener(this);

        ArrayList<Class_DTO> list = new ArrayList<>();
        list.add(new Class_DTO(R.drawable.note_class, "결석사유서/체험학습", "학교양식 신청서"));
        list.add(new Class_DTO(R.drawable.calendar_class, "학교", "학사일정"));
        list.add(new Class_DTO(R.drawable.idea, "클래스", "미제출 과제"));

        Class_Adapter adapter = new Class_Adapter(inflater, list);
        recview_class.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recview_class.setLayoutManager(manager);
        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.fl_serach || v.getId() == R.id.ll_serach) {
            Intent intent = new Intent(getContext(), Class_in_Activity.class);
            startActivity(intent);
        }
    }
}