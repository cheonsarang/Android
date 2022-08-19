package com.example.project02_iot.conn;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.project02_iot.member.LoginActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn  {

    private String url; //생성시 URL만 입력받게 만들예정
    private HashMap<String, Object> params;
    ProgressDialog dialog;
    Context context;

    private ConnCallback callback;

    public CommonConn(Context context,String url) {
        this.context = context;
        this.url = url;
        this.dialog = new ProgressDialog(context);
        params = new HashMap<>();
    }

    public void addParams(String key, Object value){
        params.put(key, value);
    }

    protected void onPreExecute() {
        if(dialog == null ) return;
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("데이터 처리중임");
        dialog.setMessage("기달");
        dialog.show();  //중요 ! 실제 보이게 처리하는 것 !
    }





    public void excuteConn(ConnCallback callback) {
        this.callback = callback;

        ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
        Call<String> call = apiInterface.getData(url, params);
        onPreExecute();
        //작업실행
        call.enqueue(new Callback<String>() {   //비동기처리
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onResult(true, response.body());
                Toast.makeText(context, "서버 굿뜨", Toast.LENGTH_SHORT).show();
                onPostExecute();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onResult(false, t.getMessage());
                Log.d("실패", "onFailure: ");
                Toast.makeText(context, "서버이상", Toast.LENGTH_SHORT).show();
                onPostExecute();
            }
        });

    }

    protected void onPostExecute() {
        if(dialog == null) return;
        dialog.dismiss();
    }


    //onResponse : 결과 성공이고 데이터가 있음 : true, 데이터
    //onFailure : 결과 실패이고 오류메세지가 있음 : false, throwable

    public interface ConnCallback{
        public void onResult(boolean isResult, String data);
    }
}
