package com.example.middle00_commonretrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.HashMap;

public class CommonAskTask extends AsyncTask<String, String, String> {

    public AsynchTaskCallBack callBack;
    //화면에 표시하기 위한 권한이나 기능
    Context context; //토스트 메세지나 프로그레스 다이얼로그 사용시 필요함
    ProgressDialog dialog;
    HashMap<String, Object> params;
    String url;

    //생성
    public CommonAskTask(Context context, String url) {
        this.context = context;
        this.url = url;
        this.dialog = new ProgressDialog(context);
        this.params = new HashMap<>();
    }

    public void addParams(String key, Object value) {
        this.params.put(key, value);
    }

    public void excuteAsk(AsynchTaskCallBack callBack) {
        this.callBack = callBack;
        this.execute();
    }

    /*public CommonAskTask(Context context, AsynchTaskCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
        this.dialog = new ProgressDialog(context); //여기에 사용할려고 Context 가져온 것이야
    }*/


    //작업 시작 전 프로그레서 다이얼로그를 보여줌
    @Override
    protected void onPreExecute() {
        if(dialog == null ) return;
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("데이터 처리중임");
        dialog.setMessage("기달");
        dialog.show();  //중요 ! 실제 보이게 처리하는 것 !
    }

    //재사용이 가능하려면 바뀌어야하는 부분 있음
    //어디를 바꿔야할까?
    //
    @Override
    protected String doInBackground(String... strings) {
        String rtnData = null;
        ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);

        try {
            rtnData = apiInterface.getData(url, params).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rtnData;

        //return "콜백";
    }

    //작업 끝났을 때


    @Override
    protected void onPostExecute(String data) {
        if(dialog == null) return;
        dialog.dismiss();
        Log.d("콜백데이터", "onPostExecute: " + data);
        //③ 실행부 : 구현해놓은 구현부를 실행해야하는 시점에 넣어주는 코드

        if(data == null || data.length() == 0) {
            callBack.onResult(data, false);
        }else {
            callBack.onResult(data, true);
        }


    }

    //다시 콜백을 주기위한 인터페이스
    public interface AsynchTaskCallBack {
        void onResult(String data, boolean isResult);
    }


}
