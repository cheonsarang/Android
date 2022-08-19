package com.example.retrofit_pracice;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.HashMap;

public class CommonAskTask extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... strings) {
        ApiInterface apiInterface = ApiCilent.getApiclient().create(ApiInterface.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", "csr");

        try {
            String rtnData = apiInterface.getData("list.ccu", map).execute().body();
            return rtnData;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
