package com.example.and14_allview.listview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and14_allview.R;

import java.util.ArrayList;

//1. 상속을 받는다 어댑터 ( 종류가 많으나 가장 기본적인 어댑터 클래스 BaseAdapter )
public class List_Adapter extends BaseAdapter {
    ArrayList<CsrDTO> list ;
    LayoutInflater inflater;

    public List_Adapter(ArrayList<CsrDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    //getter&setter 또는 생성자를 사용하면 해결 가능.
    //ArrayList를 무조건 받아서 생성이 되기때문에
    //오류날확률이 더적다.
    public List_Adapter(ArrayList<CsrDTO> list) {
        this.list = list;
    }

    // 리스트뷰에 들어가는 아이템의 갯수를 지정함.
    // 5 ,== ArrayList.size()
    // index , size를 햇갈리면 안됨.
    // 0 , 1 , 2, 3 , 4
    @Override
    public int getCount() {
        return list.size();
    }

    // 밖에서 해당하는 칸의 데이터가 필요한경우 return을 위한 메소드 ( ArrayList == ListView )
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    //내부적으로 관리를 위한 item id ,
    @Override
    public long getItemId(int position) {
        return position;
    }

    // ※ 실제 디자인을 붙이는 처리를 한다 ※ LayoutInflater가 필요함 ( 어떠한 레이아웃을 찾아서 칸마다 디자인을 붙여줌.)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // LayoutInflater <-
        convertView= inflater.inflate(R.layout.item_listview,parent,false);
        ImageView imageView = convertView.findViewById(R.id.imgv_1);
        imageView.setImageResource(list.get(position).getImg_id());

        TextView tv_no = convertView.findViewById(R.id.tv_no);
        tv_no.setText(list.get(position).getNo()+"");

        TextView tv_cat = convertView.findViewById(R.id.tv_cat);
        tv_cat.setText(list.get(position).getCategory());

        TextView tv_name = convertView.findViewById(R.id.tv_name);
        tv_name.setText(list.get(position).getName());
        return convertView;
    }
}
