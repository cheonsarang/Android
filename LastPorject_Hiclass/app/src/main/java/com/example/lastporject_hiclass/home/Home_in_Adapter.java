package com.example.lastporject_hiclass.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.lastporject_hiclass.R;

import java.util.ArrayList;

public class Home_in_Adapter extends RecyclerView.Adapter<Home_in_Adapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<HomeDTO> list;
    Context context;

    public Home_in_Adapter(LayoutInflater inflater, ArrayList<HomeDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.activity_home_in, parent, false);
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
        ImageView imgv_home;
        TextView tv_like, title, content;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_home = v.findViewById(R.id.imgv_home);
            tv_like = v.findViewById(R.id.tv_like);
            title = v.findViewById(R.id.title);
            content = v.findViewById(R.id.content);
        }
        public void bind(@NonNull ViewHolder h, int i) {
            h.imgv_home.setImageResource(list.get(i).getImgv_home());
            h.tv_like.setText(list.get(i).getTv_like());
            h.title.setText(list.get(i).getTitle());
            h.content.setText(list.get(i).getContent());
        }

    }
}
