package com.example.lastporject_hiclass.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;


import com.example.lastporject_hiclass.R;

import java.util.ArrayList;


public class Home_in_Fragment extends Fragment {


    FrameLayout frame_home;
    ArrayList<HomeDTO> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_in_, container, false);
        frame_home = v.findViewById(R.id.frame_home);

        //list.add(new HomeDTO(R.id.));

        Home_in_Adapter adapter = new Home_in_Adapter(inflater, list, getContext());

        return v;
    }
}