package com.example.lastporject_hiclass.classs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lastporject_hiclass.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Class_in_Adapter extends BaseAdapter {
    ArrayList<Class_DTO> list;
    LayoutInflater inflater;

    public Class_in_Adapter(ArrayList<Class_DTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_class_in, parent, false);
        CircleImageView imageView = convertView.findViewById(R.id.imgv_class);
        imageView.setImageResource(list.get(position).getImgv_class());

        TextView title_class = convertView.findViewById(R.id.title_class);
        title_class.setText(list.get(position).getTitle_class());

        TextView content_class = convertView.findViewById(R.id.content_class);
        content_class.setText(list.get(position).getContent_class());

        TextView join_class = convertView.findViewById(R.id.join_class);
        join_class.setText(list.get(position).getJoin_class());

        return convertView;
    }
}
