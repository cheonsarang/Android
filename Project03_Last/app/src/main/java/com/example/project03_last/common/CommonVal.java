package com.example.project03_last.common;


import com.example.project03_last.AndVO;


public class CommonVal {
    //공유 자원 : 공통으로 사용할 객체 , 변수  , enum 등등을 모아놓은 클래쓰
  //  public static MemberVO loginInfo = null;// null== 로그인 안된 상태 ,
      public static AndVO loginInfo = null ;
    /*logionInfo가 null이 아니게 바꾸고 로그인 된 상태인지 판단해보기.
    * LoginActivity에서 Intent이용 MainActivity로 이동 후 ↑
    * */


}
