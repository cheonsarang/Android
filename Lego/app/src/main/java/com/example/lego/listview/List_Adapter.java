package com.example.lego.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lego.R;

import java.util.ArrayList;

public class List_Adapter extends BaseAdapter {
    ArrayList<ListDTO> list;
    LayoutInflater inflater;

    public List_Adapter(ArrayList<ListDTO> list, LayoutInflater inflater) {
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
        convertView = inflater.inflate(R.layout.item_listview, parent, false);

        ImageView img_id = convertView.findViewById(R.id.img_id);
        img_id.setImageResource(list.get(position).getImg_id());

        ImageView img_back = convertView.findViewById(R.id.img_back);
        img_back.setImageResource(list.get(position).getImg_back());

        TextView title = convertView.findViewById(R.id.title);
        title.setText(list.get(position).getTitle());

        TextView emp = convertView.findViewById(R.id.emp);
        emp.setText(list.get(position).getEmp());


        return convertView;
    }
}
