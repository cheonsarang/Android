package com.example.project03_last.map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project03_last.R;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.a.c;

import java.util.ArrayList;

public class BtmDialogAdapter extends  RecyclerView.Adapter<BtmDialogAdapter.ViewHolder> {
    ArrayList<MapDTO> list ;
    LayoutInflater inflater;
    //NaverMap naverMap;
    MapFragment.MapOnclickEventCSR event;   //null

    public BtmDialogAdapter(ArrayList<MapDTO> list, LayoutInflater inflater, MapFragment.MapOnclickEventCSR event) {
        this.list = list;
        this.inflater = inflater;
        this.event = event; //frgment에서 메모리에 올려둔 인터페이스
    }

    /*public BtmDialogAdapter(ArrayList<MapDTO> list, LayoutInflater inflater, NaverMap naverMap) {
        this.list = list;
        this.inflater = inflater;
        this.naverMap = naverMap;
    }*/

    /*public BtmDialogAdapter(ArrayList<MapDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }*/
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_btm_dialog_recv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.bind(h, i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, addrRoad, addrJibun, mngAgcTel, syncTime;
        Button btn_map;
        public ViewHolder(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.name);
            addrRoad = v.findViewById(R.id.addrRoad);
            addrJibun = v.findViewById(R.id.addrJibun);
            mngAgcTel = v.findViewById(R.id.mngAgcTel);
            syncTime = v.findViewById(R.id.syncTime);
            btn_map = v.findViewById(R.id.btn_map);

        }

        public void bind(@NonNull ViewHolder h, int i){
            h.name.setText(list.get(i).getName());
            h.addrRoad.setText(list.get(i).getAddrRoad());
            h.addrJibun.setText(list.get(i).getAddrJibun());
            h.mngAgcTel.setText(list.get(i).getMngAgcTel());
            h.syncTime.setText(list.get(i).getSyncTime());
            h.btn_map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lat = 0;
                    double lng = 0;
                    try {
                        lat = Double.parseDouble(list.get(i).getLat());
                        lng = Double.parseDouble(list.get(i).getLng());
                        event.cameraUpdate(lat, lng);
                    } catch (Exception e) {

                    }
                    /*CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng((Double.parseDouble(list.get(i).getLat())), Double.parseDouble(list.get(i).getLng())));
                    naverMap.moveCamera(cameraUpdate);*/
                }
            });
        }
    }
}
