package com.example.middle00_commonretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //고객목록중 한건의 데이터만 가져오게끔 처리( SelectOne )
        //재사용
        
        //②구현부
        //인터페이스가 어떤 결과를 받고나서 처리를 만들어둠
        CommonAskTask askTask = new CommonAskTask(this, "detail.ccu");
        askTask.addParams("data", "csr");
        askTask.excuteAsk(new CommonAskTask.AsynchTaskCallBack() {
            @Override
            public void onResult(String data, boolean isResult) {
                Log.d("로그", "onResult: " + data);
            }
        });

        askTask = new CommonAskTask(this, "list.ccu");
        askTask.addParams("data", "csr");
        askTask.excuteAsk(new CommonAskTask.AsynchTaskCallBack() {
          @Override
          public void onResult(String data, boolean isResult) {
              Log.d("로그", "onResult: " + data);
          }
        });
        /*CommonAskTask askTask = new CommonAskTask(this, new CommonAskTask.AsynchTaskCallBack() {
            @Override
            public void onResult(String result) {
                Log.d("메인 액티비티", "onResult: " + result);
            }
        });*/

                //askTask.execute();
                //비동기처리를 하지않고 동기처리를 강제로 함
                // askTask.execute().get(); : 절대 사용xx
                //감지를 하고 NetWork 오류를 발생시키고 앱을 강제종료 처리







        /*ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
        HashMap<String, Object> params = new HashMap<>();
        params.put("data", "test");


        apiInterface.getData("list.ccu", params).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("응답", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("응답", "onFailure: " + t.getMessage());
            }
        });*/

    }
}