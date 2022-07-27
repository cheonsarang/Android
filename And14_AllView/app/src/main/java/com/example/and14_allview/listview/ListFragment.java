package com.example.and14_allview.listview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        listview = v.findViewById(R.id.listview);


        // 5건 추가하기.
        ArrayList<CsrDTO> list = new ArrayList<>();
        list.add(new CsrDTO(1, R.drawable.image5,"동물1","고래1"));
        list.add(new CsrDTO(2, R.drawable.image6,"동물2","고래2"));
        list.add(new CsrDTO(3, R.drawable.image7,"동물3","고래3"));
        list.add(new CsrDTO(4, R.drawable.image8,"불가사리","불가사리"));
        list.add(new CsrDTO(5, R.drawable.image9,"커밋","커밋커밋"));

        List_Adapter adapter= new List_Adapter(list,inflater);
        listview.setAdapter(adapter);

        /*1.목록을 가지는 모든 뷰는 Adapter가 필요함.
        *    -1-1.한칸마다 보여질 데이터를 묶어놓은 객체 == DTO(ArrayList)
        *    -1-2.한칸마다 보여질 데이터를 디자인해놓은 파일 == res\layout\xml
        * 2.Adapter 생성
        *    -2-1. 클래스를 추가한다.
        *    -2-2. extends(상속)을 받아서 어댑터가 된다.
        * 3.ListView<=>Adapter연결
        * */

        return v;
    }
}