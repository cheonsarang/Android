package com.example.lastporject_hiclass.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lastporject_hiclass.R;


public class Tab1Fragment extends Fragment implements View.OnClickListener {

TextView          tv_noti1 , tv_noti2, content_title, tv_noti3;
    LinearLayout like_line;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_tab1, container, false);
        tv_noti1 = v.findViewById(R.id.tv_noti1);
        tv_noti2 = v.findViewById(R.id.tv_noti2);
        tv_noti3 = v.findViewById(R.id.tv_noti3);
        //content_title = v.findViewById(R.id.content_title);
       tv_noti1.setOnClickListener(this);
       tv_noti2.setOnClickListener(this);
        tv_noti3.setOnClickListener(this);
       //content_title.setOnClickListener(this);
        like_line = v.findViewById(R.id.like_line);


        return v;
    }
        //※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
    @Override
    public void onClick(View v) {
        TextView temp = (TextView) v;
        String text = temp.getText()+"";
        /*String text = "(●'◡'●) 축하합니다, 8월의 솜씨왕 윤슬초등학교 3학년 김은아 학생 ❣\n" +
                "\n" +
                "\n" +
                "✔ 그림 설명\n" +
                "\n" +
                "우리나라를 끝까지 지키기 위해 노력한 유관순과 무궁화, 한복, 기쁨을 의미한 새를 그렸습니다.\n" +
                "\n" +
                "그림을 그리면서 우리나라를 되찾게 노력하신 분들을 생각했어요.\n" +
                "\n" +
                "\n" +
                "✔ 하이클래스 하영쌤 한줄평\n" +
                "\n" +
                "오늘의 대한민국을 가능하게 한 분들에게 늘 감사하는 마음을 가지며 이 아름다운 문화를 잘 지켜나가야겠어요 (๑•᎑<๑)";*/
        Log.d("아이디", "onClick: " + v.getId());
        //Log.d("아이디", "onClick: " + R.id.first);
        Log.d("아이디", "onClick: " + temp.getId());

        Intent intent = new Intent(getContext() , Home_in_Activity.class);
        if(temp.getId() == R.id.tv_noti1){
            intent.putExtra("page","tab1");
            intent.putExtra("title", "공지사항");
            intent.putExtra("content", "안녕하세요 \n\n 하이클래스 운영팀입니다.\n\n 강원도 내" +
                    "학교 게시물(가정통신문, 급식, 학교공지) 연동 관련 안내드립니다. \n\n " +
                    "강원교육과학정보원 요청에 따라, \n학교 홈페이지에 당일 09:00 ~ 15:30 경 작성된" +
                    " 게시물들은\n당일 17:00 이후 일괄 하이클래스에서 연동되어 제공 예정입니다." +
                    "\n\n 관련하여 궁금하신 사항이 있으신 경우\n강원교육과학정보원으로 문의 및 건의 부탁드립니다." +
                    "\n\n 감사합니다.");
            intent.putExtra("content_title", text);
            intent.putExtra("imgv_home", "없애");
            intent.putExtra("like_line", "없애");

        }else if(temp.getId() == R.id.tv_noti2) {
            intent.putExtra("page","tab1");
            intent.putExtra("title", "공지사항");
            intent.putExtra("content", "안녕하세요.\n" +
                    "\n" +
                    "하이클래스 운영팀입니다.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "하이클래스 학생건강 자가진단 서비스 푸쉬알림 정책 변경 안내드립니다.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "- 적용기간 : 2022년 7월 4일(월) 부터\n" +
                    "\n" +
                    "- 변경내용 : 1) 매일 오전 학생건강 자가진단서비스 \"앱 푸쉬 알림\" 중단\n" +
                    "\n" +
                    "                    2) 앱 내 자가진단서비스 \"바로가기 메뉴\" 미노출\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "※ 참고 : 교육부 공식앱 '건강상태 자가진단'은 정상적으로 이용 가능합니다.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "보다 만족스러운 서비스를 제공할 수 있도록 노력하겠습니다.\n" +
                    "감사합니다.\n" +
                    "\n" +
                    " ");
            intent.putExtra("content_title", text);
            intent.putExtra("imgv_home", "없애");
            intent.putExtra("like_line", "없애");
        }else if(temp.getId() == R.id.tv_noti3) {
            intent.putExtra("page","tab1");
            intent.putExtra("title", "공지사항");
            intent.putExtra("content", "안녕하세요, 하이클래스 운영팀입니다.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "알림장, 앨범, 자유게시판 등 \"모든 게시판\"에 대하여 \"동영상 다운로드\" 기능이 업데이트 되었습니다❤\n" +
                    "\n" +
                    "※ AOS(안드로이드폰)는 ver.1.14.6 / iOS(아이폰)는 ver.1.13.8 버전 이상에서 확인하실 수 있습니다.  \n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "\n" +
                    "앞으로도 의견 주시는 내용들에 귀 기울이며, 꼭 필요한 서비스를 제공해나가도록 하겠습니다.\n" +
                    "\n" +
                    "감사합니다.");
            intent.putExtra("content_title", text);
            intent.putExtra("imgv_home", "없애");
            intent.putExtra("like_line", "없애");
        }
        getContext().startActivity(intent);
    }
}