package com.example.lastporject_hiclass.classs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastporject_hiclass.R;

import java.util.ArrayList;


public class ClassFragment extends Fragment {
    RecyclerView recview_class;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_class, container, false);
        recview_class = v.findViewById(R.id.recview_class);

        ArrayList<Class_DTO> list = new ArrayList<>();
        list.add(new Class_DTO(R.drawable.star, "결석사유서/체험학습", "학교양식 신청서"));
        list.add(new Class_DTO(R.drawable.star, "학교", "학사일정"));
        list.add(new Class_DTO(R.drawable.star, "클래스", "미제출 과제"));

        Class_Adapter adapter = new Class_Adapter(inflater, list);
        recview_class.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recview_class.setLayoutManager(manager);



        return v;
    }
}