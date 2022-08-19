package com.example.lego.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lego.R;

import java.util.ArrayList;

public class Re_Adapter extends RecyclerView.Adapter<Re_Adapter.RecHolder> {
    LayoutInflater inflater;
    ArrayList<RecycleDTO> list;

    public Re_Adapter(LayoutInflater inflater, ArrayList<RecycleDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public RecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecHolder extends RecyclerView.ViewHolder {
        ImageView img__id;
        TextView title, time;

        public RecHolder(View v) {
            super(v);
            img__id = v.findViewById(R.id.img_id);
            title = v.findViewById(R.id.title);
            time = v.findViewById(R.id.time);
        }
    }

}
