package com.example.project02_iot.notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_iot.R;

import java.util.ArrayList;


public class Pager2Adapter extends RecyclerView.Adapter<Pager2Adapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<Integer> img_list;




    public Pager2Adapter(LayoutInflater inflater, ArrayList<Integer> img_list) {
        this.inflater = inflater;
        this.img_list = img_list;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_noti_pager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return img_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_pager;
        TextView title, content, writer, writedate;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_pager = v.findViewById(R.id.imgv_pager);
            title = v.findViewById(R.id.title);
            content = v.findViewById(R.id.content);
            writer = v.findViewById(R.id.writer);
            writedate = v.findViewById(R.id.writedate);
        }
        public void bind(@NonNull ViewHolder holder, int position) {
            holder.imgv_pager.setImageResource(img_list.get(position));

        }
    }


}
