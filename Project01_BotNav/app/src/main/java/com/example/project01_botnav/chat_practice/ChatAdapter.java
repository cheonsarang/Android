package com.example.project01_botnav.chat_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_botnav.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<ChatDTO> list;

    public ChatAdapter(LayoutInflater inflater, ArrayList<ChatDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_chat_pra, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv;
        TextView name, content, time, num;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv = v.findViewById(R.id.imgv);
            name = v.findViewById(R.id.name);
            content = v.findViewById(R.id.content);
            time = v.findViewById(R.id.time);
            num = v.findViewById(R.id.num);
        }

        public void bind(@NonNull ViewHolder h, int i) {
            h.imgv.setImageResource(list.get(i).getImgv());
            h.name.setText(list.get(i).getName());
            h.content.setText(list.get(i).getContent());
            h.time.setText(list.get(i).getTime());
            h.num.setText(list.get(i).getNum());
        }


    }
}
