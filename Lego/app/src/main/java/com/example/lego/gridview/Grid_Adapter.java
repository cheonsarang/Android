package com.example.lego.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lego.R;

import java.util.ArrayList;

public class Grid_Adapter extends BaseAdapter {
    ArrayList<GridDTO> list;
    LayoutInflater inflater;

    public Grid_Adapter(ArrayList<GridDTO> list, LayoutInflater inflater) {
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
        convertView = inflater.inflate(R.layout.item_gridview, parent, false);
        GridViewHolder viewHolder = new GridViewHolder(convertView);
        viewHolder.bind(list.get(position));
        return convertView;
    }

    public class GridViewHolder {
        ImageView img_id;
        TextView content;

        public GridViewHolder(View v) {
            img_id = v.findViewById(R.id.img_id);
            content = v.findViewById(R.id.content);
        }

        public void bind(GridDTO dto) {
            img_id.setImageResource(dto.getImg_id());
            content.setText(dto.getContent());
        }
    }
}
