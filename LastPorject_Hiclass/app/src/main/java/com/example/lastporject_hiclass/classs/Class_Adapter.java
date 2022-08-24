package com.example.lastporject_hiclass.classs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastporject_hiclass.R;

import java.util.ArrayList;
import java.util.List;

public class Class_Adapter extends RecyclerView.Adapter<Class_Adapter.classHolder>{
    LayoutInflater inflater;
    ArrayList<Class_DTO> list;

    public Class_Adapter(LayoutInflater inflater, ArrayList<Class_DTO> list) {
        this.inflater = inflater;
        this.list = list;
    }


    @NonNull
    @Override
    public classHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_class, parent, false);
        return new classHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull classHolder holder, int position) {
        holder.imgv_id.setImageResource(list.get(position).getImgv_id());
        holder.tv_1.setText(list.get(position).getTv_1());
        holder.tv_2.setText(list.get(position).getTv_2());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class classHolder extends RecyclerView.ViewHolder {
        ImageView imgv_id;
        TextView tv_1, tv_2;
        public classHolder(@NonNull View v) {
            super(v);
            imgv_id = v.findViewById(R.id.imgv_id);
            tv_1 = v.findViewById(R.id.tv_1);
            tv_2 = v.findViewById(R.id.tv_2);
        }
    }
}
