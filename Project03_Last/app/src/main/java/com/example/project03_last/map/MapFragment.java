package com.example.project03_last.map;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project03_last.R;
import com.example.project03_last.conn.ApiClient;
import com.example.project03_last.conn.ApiInterface;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MapFragment extends Fragment implements OnMapReadyCallback {
    MapView map_view;    //화며에 보이기만 하는 기능을 담당함 View
    NaverMap naverMap;  //실제 네이버지도의 백엔드 영역의 기능 담당(인터페이스)
    BottomSheetDialog dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(inflater.inflate(R.layout.btm_dilog_map, null));
        dialog.show();

        map_view = v.findViewById(R.id.map_view);

        NaverMapSdk.getInstance(getContext()).setClient(
                new NaverMapSdk.NaverCloudPlatformClient("6oii5bvqx9"));

        map_view.getMapAsync(this);
        getGoData();
        return v;
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {    //인터페이스를 통해 우리한테 넘겨준 맵을 재활용가능하게 전역변수에 담음
        this.naverMap = naverMap;
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(35.1535583, 126.8879957))
                .animate(CameraAnimation.Fly);
        naverMap.moveCamera(cameraUpdate);
    }

    //공공데이터 포털에 있는 정보를 GET방식으로 얻어오기 위한 메소드
    //CommonConn 처럼 나중에 재사용이 가능 구조로 만들면 좋다 2022/08/22 시도시도
    public void getGoData() {
        ApiInterface apiInterface = ApiClient.getApiclient("http://apis.data.go.kr/6290000/localspecstbaseinfo/").create(ApiInterface.class);
        //파라메터로 넘겨줄 String HashMap
        HashMap<String, String> params = new HashMap<>();
        params.put("serviceKey", "pYovlMLFQnW2UKYv2BcEIkHSL+Qxu06FkdzYTyK9zN3Twj/X3oQDzSZGwiSG8zWA03xSHXavc3zUWFKWK1la3Q==");
        params.put("numOfRows", "100");
        params.put("pageNo", "1");
        params.put("type", "json");
        apiInterface.getDataGET("getlocalspecstbaseinfo", params).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("공공데이터", "onResponse: " + response.body());
                JsonObject obj = (JsonObject) new JsonParser().parse(response.body());
                String data = obj.get("LocalSpecStBaseInfo").toString();
                ArrayList<MapDTO> list = new Gson().fromJson(data, new TypeToken<ArrayList<MapDTO>>(){}.getType());
                Log.d("공공데이터 size", "onResponse: " + list.size());

                RecyclerView recv_dialog = dialog.findViewById(R.id.recv_dialog);
                //BtmDialogAdapter adapter = new BtmDialogAdapter(list, getLayoutInflater(), naverMap);
                BtmDialogAdapter adapter = new BtmDialogAdapter(list, getLayoutInflater(), event);
                RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                recv_dialog.setAdapter(adapter);
                recv_dialog.setLayoutManager(manager);

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("공공데이터", "onFailure: " + t.getMessage());
            }
        });
    }

    //② 플래그먼트의 메모리에 올려둠, event 라는 이름으로 메모리에 올려만 둠(구조)
    MapOnclickEventCSR event = new MapOnclickEventCSR() {
        @Override
        public void cameraUpdate(double lat, double lng) {
            CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(lat, lng))
                    .animate(CameraAnimation.Fly);
            naverMap.moveCamera(cameraUpdate);
            Marker marker = new Marker();
            marker.setPosition(new LatLng(lat,lng));
            marker.setMap(naverMap);
            dialog.dismiss();
        }
    };
    //① 정의
    public interface MapOnclickEventCSR {
        void cameraUpdate(double lat, double lng);
    }
}