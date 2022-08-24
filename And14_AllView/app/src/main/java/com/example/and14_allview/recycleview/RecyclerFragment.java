package com.example.and14_allview.recycleview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and14_allview.R;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class RecyclerFragment extends Fragment {

    RecyclerView recview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);
        recview = v.findViewById(R.id.recview);

        ArrayList<CsrDTO> list = new ArrayList<>();
        list.add(new CsrDTO(1, R.drawable.image5,"동물", "고래1"));
        list.add(new CsrDTO(2, R.drawable.image6,"동물", "고래2"));
        list.add(new CsrDTO(3, R.drawable.image7,"동물", "고래3"));
        list.add(new CsrDTO(4, R.drawable.image8,"동물", "불가사리"));
        list.add(new CsrDTO(5, R.drawable.image9,"동물?", "커밋"));

        Rec_Adapter adapter = new Rec_Adapter(inflater, list);
        recview.setAdapter(adapter);

        /*Layoutmanager <- 가로인지 세로인지 설정해서 넣는 것 필수!!*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        //첫번째 파라메터 : context, 액티비티면 this 이고 Fragment 면 받아와서 넘기면 됨
        //두번째 파라메터 : 방향 가로 또는 세로
        //세번째 파라메터 : 반대로 순서를 바꿀건지 여부, 대부분 false
        recview.setLayoutManager(layoutManager);
        return v;
    }
}