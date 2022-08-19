package com.example.middle00_retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    // url 정보 ( middle웨어 tomcat 까지의 정보 저장해둠 )
    // 여기 클래스까지만 접근하면 바로 사용할 수 있는 Retrofit 객체를 준비해두기


    private static final String BASE_URL = "http://192.168.0.63:81/mid/";    /* cmd에 ip 주소 검색 후 스프링에서 만든 프로젝트의 home까지 접근할 수 있는 url  */
    private static Retrofit retrofit;

    public static Retrofit getApiclient() {
        if (retrofit == null) { //최초실행 시 retrofit 객체가 null 이라면 그 때만 생성하게 만듦
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)  //미들웨어의 주소를 의미(맵핑을 제외하고)
                    .addConverterFactory(ScalarsConverterFactory.create()) //json String형태를 사용가능하게 해줌
                    .client(new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).build())   //미들웨어가 꺼졌거나 응답이 불가능할 때 몇초이상 경과되면 통신 끊기위한 처리 : 안해주면 무한대기상태 됨
                    .build();
        }
        return  retrofit;
    }



}
