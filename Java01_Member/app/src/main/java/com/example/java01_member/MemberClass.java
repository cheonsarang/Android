package com.example.java01_member;

import android.util.Log;

public class MemberClass {
    //접근제한자, static 멤버 구분자의 기능 이해
    //메인액티비티에서 세개의 변수에 모두 접근 시도, 가능과 불가능 이유 알기
    String default_a;   //같은 패키지 내에서 접근 가능
    public String public_str;   //어디서든(같은 모듈 내에서) 접근 가능
    private String private_str; //같은 멤버안에서(클래스) 안에서 접근 가능
    //protected 생략
    
    //디폴트, 퍼블릭, 프라이빗 메소드 만들기
    public void public_method() {

    }
    
    //private 접근 위해 getter & setter 만듧 -> 이것들은 반드시 접근이 되어야하기때문에 public 으로 만들어짐
    private void private_method() {

    }
    
    void default_metohd() {

    }

}
