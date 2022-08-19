package com.example.project01_botnav.chat_practice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_botnav.R;

import java.util.ArrayList;


public class ChatFragment extends Fragment {
    RecyclerView recv_main ;
    int[] imgArr = { R.drawable.etc,
            R.drawable.and,
            R.drawable.gear,
            R.drawable.profile,
            R.drawable.shopping,
            R.drawable.talk,
            R.drawable.talkblack,
            R.drawable.ic_launcher_background };

    ArrayList<ChatDTO> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat_pra, container, false);

        recv_main = v.findViewById(R.id.recv_main);

        list.add(new ChatDTO(R.drawable.etc, "채팅방 이름1", "채팅내용1", "오전 9:20", "5"));
        list.add(new ChatDTO(R.drawable.and, "채팅방 이름2", "채팅내용2", "오전 9:24", "8"));
        list.add(new ChatDTO(R.drawable.gear, "채팅방 이름3", "채팅내용3", "오전 9:50", "7"));
        list.add(new ChatDTO(R.drawable.profile, "채팅방 이름4", "채팅내용4", "오전 9:40", "1"));
        list.add(new ChatDTO(R.drawable.shopping, "채팅방 이름5", "채팅내용5", "오전 9:08", "2"));
        list.add(new ChatDTO(R.drawable.talk, "채팅방 이름6", "채팅내용6", "어제", "5"));
        list.add(new ChatDTO(R.drawable.talkblack, "채팅방 이름7", "채팅내용7", "어제", "3"));
        list.add(new ChatDTO(R.drawable.ic_launcher_background, "채팅방 이름8", "채팅내용8", "어제", "11"));

        ChatAdapter adapter = new ChatAdapter(inflater, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        recv_main.setAdapter(adapter);
        recv_main.setLayoutManager(manager);



        return v;
    }
}