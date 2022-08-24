package com.example.and14_allview.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and14_allview.R;

import java.util.ArrayList;


public class Grid_Adapter extends BaseAdapter {
    ArrayList<CsrDTO> list;
    LayoutInflater inflater;


    public Grid_Adapter(ArrayList<CsrDTO> list, LayoutInflater inflater) {
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
    //convertView 부분은 우리한테 내용물 넣으라구 null인 상태로 비워져서 들어오는 변수 -> return해주면 알아서 붙임
    //parent getCount 만큼 나눈 공간을 position 별로 한칸씩 우리한테 줌
    //↑ 두가지는 붙일 내용과 붙일 공간 ※LayoutInflater
    //ViewHolder 라는 것 만들기(↓ View(위젯)용 DTO) <= RecyclerView 에서는 ViewHolder를 강제함
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_gridview, parent, false);
        GridViewHolder viewHolder = new GridViewHolder(convertView);
        viewHolder.bind(list.get(position));
        return convertView;
    }

    public class GridViewHolder {
        ImageView imgv_1 ;
        TextView tv_no, tv_cat, tv_name;

        public GridViewHolder(View v) {
            imgv_1 = v.findViewById(R.id.imgv_1);
            tv_no = v.findViewById(R.id.tv_no);
            tv_cat = v.findViewById(R.id.tv_cat);
            tv_name = v.findViewById(R.id.tv_name);
        }

        public void bind(CsrDTO dto) {
            imgv_1.setImageResource(dto.getImg_id());
            tv_no.setText(dto.getNo()+"");
            tv_cat.setText(dto.getCategory());
            tv_name.setText(dto.getName());
        }


    }

}

