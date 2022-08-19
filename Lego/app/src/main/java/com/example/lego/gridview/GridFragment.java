package com.example.lego.gridview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.lego.R;

import java.util.ArrayList;


public class GridFragment extends Fragment {
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);

        gridView = v.findViewById(R.id.go_grid);

        ArrayList<GridDTO> list = new ArrayList<>();
        list.add(new GridDTO(R.drawable.star, "간편모드"));
        list.add(new GridDTO(R.drawable.calendar, "편성표"));
        list.add(new GridDTO(R.drawable.user, "마이 고릴라"));
        list.add(new GridDTO(R.drawable.settings, "설정"));
        list.add(new GridDTO(R.drawable.star, "간편모드"));
        list.add(new GridDTO(R.drawable.calendar, "편성표"));
        list.add(new GridDTO(R.drawable.user, "마이 고릴라"));
        list.add(new GridDTO(R.drawable.settings, "설정"));

        Grid_Adapter adapter = new Grid_Adapter(list, inflater);
        gridView.setAdapter(adapter);
        return v;
    }
}