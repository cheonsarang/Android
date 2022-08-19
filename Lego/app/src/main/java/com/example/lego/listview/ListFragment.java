package com.example.lego.listview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lego.R;

import java.util.ArrayList;


public class ListFragment extends Fragment {
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        listView = v.findViewById(R.id.go_list);

        ArrayList<ListDTO> list = new ArrayList<>();
        list.add(new ListDTO(R.drawable.person1, R.drawable.blue,"김태현의 정치쇼", "LOVE FM"));
        list.add(new ListDTO(R.drawable.person2, R.drawable.purple,"아름다운 이 아침 김창완입니다", "POWER FM"));
        list.add(new ListDTO(R.drawable.person3, R.drawable.green,"Classic 20", "고릴라디오M"));

        List_Adapter adapter = new List_Adapter(list, inflater);
        listView.setAdapter(adapter);

        return v;
    }
}