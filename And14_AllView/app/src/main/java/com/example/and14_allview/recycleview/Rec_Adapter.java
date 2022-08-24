package com.example.and14_allview.recycleview;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and14_allview.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Rec_Adapter extends RecyclerView.Adapter<Rec_Adapter.RecHolder>{
    LayoutInflater inflater;
    ArrayList<com.example.and14_allview.recycleview.CsrDTO> list;

    public Rec_Adapter(LayoutInflater inflater, ArrayList<CsrDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    //Recycler <- 재활용 : 뷰홀더(ViewHolder)를 강제함 : 무조건 만들어야 함
    //가로, 세로, 지그재그(잘 사용xx)를 제공
    //1. ViewHolder 클래스를 상속받은 inner class를 만들기
    //2. RecyclerView.Adapter 상속, RecyclerView<VH> == VH = ViewHolder(이너클래스)

    @NonNull
    @Override
    public RecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_listview, parent, false);

        return new RecHolder(v);
    }

    //데이터바인딩 ( 뷰 <-> dto ) 연결부 GridAdapter.bind();
    @Override
    public void onBindViewHolder(@NonNull RecHolder holder, int position) {
        //holder <-> dto 연결 (holder 갯수 == list.size() )
        holder.img_v.setImageResource(list.get(position).getImg_id());
        holder.tv_no.setText(list.get(position).getNo()+"");
        holder.tv_cat.setText(list.get(position).getCategory());
        holder.tv_name.setText(list.get(position).getName());
    }

    //리사이클러뷰의 아이템 갯수 지정
    @Override
    public int getItemCount() {
        return list.size();
    }

    //1. 어떤 이름이든 일단 extends RecyclerView.ViewHolder를 상속받아 ViewHolder 구조로 만드는 것
    public class RecHolder extends RecyclerView.ViewHolder {
        //@NonNull : null 을 넣으면 안됨
        ImageView img_v;
        TextView tv_no, tv_cat, tv_name;
        public RecHolder(@NonNull View v) {
            super(v);
            img_v = v.findViewById(R.id.imgv_1);
            tv_no = v.findViewById(R.id.tv_no);
            tv_cat = v.findViewById(R.id.tv_cat);
            tv_name = v.findViewById(R.id.tv_name);

            //positon

        }
    }

}
