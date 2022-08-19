package com.example.project02_iot.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_iot.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {
    ArrayList<NoticeVO> noti_list;
    LayoutInflater inflater;

    public NoticeAdapter(ArrayList<NoticeVO> noti_list, LayoutInflater inflater) {
        this.noti_list = noti_list;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_noti_recv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return noti_list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, content, writer, writedate;
        public ViewHolder(@NonNull View v) {
            super(v);
            title = v.findViewById(R.id.title);
            content = v.findViewById(R.id.content);
            writer = v.findViewById(R.id.writer);
            writedate = v.findViewById(R.id.writedate);
        }
        public void bind(@NonNull NoticeAdapter.ViewHolder holder, int position) {
            holder.title.setText(noti_list.get(position).getTitle());
            holder.content.setText(noti_list.get(position).getContent());
            holder.writer.setText(noti_list.get(position).getWriter());
            holder.writedate.setText(noti_list.get(position).getWritedate());

        }
    }
}
