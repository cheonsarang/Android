package com.example.middle00_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메인스레드에서 작업하는게 아니라 비동기로 어떤 작업을 위핸 작업관리자
        CommonAskTask conn = new CommonAskTask();   //나중에 필요하다면 인터페이스를 넘기고난 후 callback 메소드를 메인으로 뺄거야
        conn.execute();


        /*ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("data", "Send!!");


        Call<String> apiTest = apiInterface.getData("list.ccu", map);//요청 준비 끝
        try {
            String data = apiTest.execute().body();
            Log.d("동기작업", "onCreate: " + data);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /* 비동기처리
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("통신테스트", "onResponse: ");
                //TypeToken
                ArrayList<CustomerVO> list
                        = new Gson().fromJson(response.body(), new TypeToken< ArrayList<CustomerVO> >(){}.getType());
                for (int i = 0; i < list.size(); i++) {
                    Log.d("리스트 내용", "onResponse: " + list.get(i).getName() + "");
                }

                //Log.d("통신테스트", "onResponse: "+ response.body());
                //Gson => toJson
                //FromJson <= Gson
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("통신테스트", "onResponse: 실패 " + t.getMessage());
            }
        });
*/

    }
}