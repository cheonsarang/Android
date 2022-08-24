package com.example.and14_allview.gridview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.and14_allview.R;
import com.example.and14_allview.listview.List_Adapter;

import java.util.ArrayList;

public class GridFragment extends Fragment {
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);

        gridView = v.findViewById(R.id.gridview);

        ArrayList<CsrDTO> list = new ArrayList<>();
        list.add(new CsrDTO(1, R.drawable.image5,"동물", "고래1"));
        list.add(new CsrDTO(2, R.drawable.image6,"동물", "고래2"));
        list.add(new CsrDTO(3, R.drawable.image7,"동물", "고래3"));
        list.add(new CsrDTO(4, R.drawable.image8,"동물", "불가사리"));
        list.add(new CsrDTO(5, R.drawable.image9,"동물?", "커밋"));


        Grid_Adapter adapter = new Grid_Adapter(list, inflater);
        gridView.setAdapter(adapter);
        return v;
    }
}