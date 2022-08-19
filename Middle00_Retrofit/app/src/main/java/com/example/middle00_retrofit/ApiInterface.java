package com.example.middle00_retrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {


    // 실제로 요청한 Url, 넘겨줄 파라메터 등 설정하는 곳
    // callback받기위해 만듦
    // get, post 를 미리 지정하는 방식 x , FormUrlEncoded 라는 어노테이션을 이용해서 입력받기 oo

    @FormUrlEncoded
    @POST
    Call<String> getData(@Url String url, @FieldMap HashMap<String, Object> parameters);  // @FieldMap : 접속되고 추가 ( 파라메터 )

}
