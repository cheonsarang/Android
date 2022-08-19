package com.example.project01_botnav;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    //Splash 화면은 로고를 사용자에게 자연스럽게 노출을 해서 회사의 브랜드를 인식시키는 효과
    //2-3초 정도의 시간에 서버와 통신을 해서 데이터를 가지고 오는 행위도 할 수 있음
    //=> 실제 기능이 있는 액티비티로 이동만 시킴

    //Handler <- 메인 쓰레드를 이용해서 딜레이를 주는 기능을 많이 사용
    //방법을 외우거나 할 필요 없이 한번했던 코드 있다면 복붙해서 사용 외우기 xx
    //Thread <- 접근해서 sleep을 주는것 xx

    //ProgressDialog <- Dialog : 화면 위에 어떤 알림이나 메세지를 띄우는 것 ( ex) alert )
    //앱이 지금 실행중인 것인지 아닌지 판단하는 것이 매우 모호함
    //로딩중이면 몇초나 걸리는지, 아니면 현재 상태가 서버의 응답을 기다리고 있는 것인지 사용자가 알 수 있게 해줘야 함


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ProgressDialog dialog = new ProgressDialog(SplashActivity.this);
        dialog.setTitle("로딩중 기달");
        dialog.setMessage("로오디잉주웅웅");
        dialog.show();  //dialog를 만들어놓고 show 를 안하면 절대 안보임


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                dialog.dismiss();   //다이얼로그 끄기
                finish();           //화면 종료 시키기 
            }
        }, 2000);


    }
}