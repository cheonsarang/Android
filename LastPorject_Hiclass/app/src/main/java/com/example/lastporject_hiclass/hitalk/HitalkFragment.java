package com.example.lastporject_hiclass.hitalk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.lastporject_hiclass.R;
import com.google.android.material.tabs.TabLayout;


public class HitalkFragment extends Fragment {
    TabLayout tabs;
    ImageView container_hitalk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hitalk, container, false);
        container_hitalk = v.findViewById(R.id.container_hitalk);
        tabs = v.findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("대화 상대"));
        tabs.addTab(tabs.newTab().setText("대화"));
        tabs.addTab(tabs.newTab().setText("통화"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition(); //0번부터
                if(pos ==0){
                    container_hitalk.setImageResource(R.drawable.image23);
                }else if(pos == 1){
                    container_hitalk.setImageResource(R.drawable.image22);
                }else if(pos == 2) {
                    container_hitalk.setImageResource(R.drawable.image21);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });






        return v;
    }
}