package com.example.and13_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 메인액티비티 안에 어떤곳에 붙였을까?
    // View : 위젯 ( xml에서 디자인할수있는 모든것들 )
    // ViewGroup : ↑ 안에 묶어서 넣을수있는 구조를 가진 위젯(Layout)

    // LayoutInflate.inflate ( R.layout.내가만든xml , ViewGroup , true );
    TestFragment testFragment = new TestFragment();
    SubFragment subFragment = new SubFragment(this);
    static Button btn_change ;
    ToastDAO dao = new ToastDAO();
    static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_change = findViewById(R.id.btn_change);


        dao.showToast(this,"문자열 보여주기");

        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        fragmentManager = getSupportFragmentManager();

        btn_change.setTag(0);
        //위젯에 어떤 상태정보를 넣어두고 사용하기위한것(Object형태여서 뭐든지 넣을수있다.)

        // FragmentManager <- 이게 필요함 ( 프래그먼트를 붙이는 처리를 한다. )
        // 액티비티 기준으로 FragmentManager를 초기화 하는 방식(사용준비)
        // Transaction ( DB ) : INSERT , UPDATE  , DELETE => COMMIT , ROLLBACK 을 해줘야만 작업이 확정이 됨.

    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.showToast(MainActivity.this,"문자열 보여주기");
                int btnTag = Integer.parseInt( btn_change.getTag().toString());//Object
                if(btnTag == 0){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,testFragment).commit();
                    btn_change.setTag(1);
                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,subFragment).commit();
                    btn_change.setTag(0);
                }
            }
        });
    }


    // static 키워드를 이용해서 멤버를 static멤버로 만들기
    // static이 붙으면 static멤버다 != static이 안붙으면 static멤버가 아니다.

    // 두가지 멤버가 있음 : static 멤버 , 인스턴스 멤버

    // static은 항상 메모리에 먼저 가있어야함.
    // 인스턴스멤버는 new를 통해서 인스턴스화 과정을 실행해야 메모리에 올라감.

    // static메소드를 안드로이드에서 사용했을때 불편한점.
    // 대부분의 안드로이드에서 사용되는 멤버들은(Context,FragmentManager등) 인스턴스 멤버임.
    // static에서 구현을 하려면 하나씩 static으로 만들거나 해야하는 불편한점이 많음.(메모리용량많이씀)
    // MainActivity activity = new MainAcvitity();
    // ↓ 방식은 사용을 자제하자!( 안된다고 무조건 static을 쓰지 말자 )
    public static void mainMethod(){
        Log.d("메인메소드", "mainMethod: ");
        // ?
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dao.showToast(MainActivity.this,"문자열 보여주기");
                int btnTag = Integer.parseInt( btn_change.getTag().toString());//Object
                if(btnTag == 0){
                    //getSupportFragmentManager() <- 메소드 ( return fragmentManager )
                    fragmentManager.beginTransaction().replace(R.id.container,new TestFragment()).commit();
                    btn_change.setTag(1);
                }else{
                    fragmentManager.beginTransaction().replace(R.id.container,new SubFragment(v.getContext())).commit();
                    btn_change.setTag(0);
                }
            }
        });
    }


    // 모든 멤버에 접근이 가능함.
    public void mainMethodI(){

        dao.showToast(MainActivity.this,"문자열 보여주기");
        int btnTag = Integer.parseInt( btn_change.getTag().toString());//Object
        if(btnTag == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,testFragment).commit();
            btn_change.setTag(1);
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.container,subFragment).commit();
            btn_change.setTag(0);
        }

    }
}