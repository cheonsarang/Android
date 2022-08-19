package com.example.lastporject_hiclass.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lastporject_hiclass.R;


public class Tab3Fragment extends Fragment implements View.OnClickListener{
    TextView tab3_tv1, tab3_tv2, tab3_tv3, tab3_tv4 ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab3, container, false);

        tab3_tv1 = v.findViewById(R.id.tab3_tv1);
        tab3_tv2 = v.findViewById(R.id.tab3_tv2);
        tab3_tv3 = v.findViewById(R.id.tab3_tv3);
        tab3_tv4 = v.findViewById(R.id.tab3_tv4);

        tab3_tv1.setOnClickListener(this);
        tab3_tv2.setOnClickListener(this);
        tab3_tv3.setOnClickListener(this);
        tab3_tv4.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), Home_in_Activity.class);
        if(v.getId() == R.id.tab3_tv1) {
            intent.putExtra("page","tab3");
            intent.putExtra("title", "클래스");
            intent.putExtra("content_title", "Q. 과제 게시판에 글쓰기 버튼이 없어요");
            intent.putExtra("content", "A.\n" +
                    "\n" +
                    "과제게시판은 선생님이 출제한 게시물에 학부모/학생이 과제를 제출하는 형식입니다.\n" +
                    "\n" +
                    "따라서 선생님께서 과제게시판에 게시물을 올리셔야만 해당 게시물에 과제 제출이 가능합니다.");
            intent.putExtra("imgv_home", "없애");
            intent.putExtra("tv_like", "1251");
        }else if(v.getId() == R.id.tab3_tv2) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hc18110910.notion.site/e46baf0610c54472b40c476b28033556#45da6774f91c499c91659dc9fd29a007"));
        }else if(v.getId() == R.id.tab3_tv3) {
            intent.putExtra("page","tab3");
            intent.putExtra("title", "회원가입/로그인");
            intent.putExtra("content_title", "Q. 학부모인데 학생으로 잘못 가입했어요");
            intent.putExtra("content", "A. \n" +
                    "\n" +
                    "하이클래스는 휴대폰번호 1개당 1계정 회원 가입이 가능하며,\n" +
                    "\n" +
                    "회원타입을 잘못 선택하여 가입하였을 경우 계정 변경이 불가합니다.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "따라서 학부모(학생)인데 학생(학부모)으로 잘못 가입한 경우에는\n" +
                    "\n" +
                    "조금 번거로우시더라도 클래스가 아닌 \"서비스\" 탈퇴 후 정확한 타입으로 재가입을 하셔야합니다.\n" +
                    "\n" +
                    "(단, 탈퇴 전 작성하셨던 게시물 또는 출석체크 이력은 삭제될 수 있습니다.)");
            intent.putExtra("imgv_home", "없애");
            intent.putExtra("tv_like", "1304");
        }else if(v.getId() == R.id.tab3_tv4) {
            intent.putExtra("page","tab3");
            intent.putExtra("title", "학교 서비스");
            intent.putExtra("content_title", "Q. 간편한 체험학습보고서 제출방법");
            intent.putExtra("content", "A. \n" +
                    "\n" +
                    "체험학습 보고서 등 각종 학교 양식을\n" +
                    "\n" +
                    "온라인으로 제출하여 사용하실 수 있습니다. \n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "✔ 어디서 신청서를 작성하고 제출하나요?\n" +
                    "\n" +
                    "- App > 클래스 탭 > [학교 양식 신청서] 클릭\n" +
                    "\n" +
                    "- PC > 클래스 > 학교양식 신청서 > 제출하고자 하는 양식 [작성하기] 클릭\n" +
                    "\n" +
                    "단, 선생님께서 해당 기능을 사용하지 않으실 경우, 앱 또는 웹에서 보이지 않을 수 있습니다. 선생님께 문의해주세요.");
            intent.putExtra("imgv_home", "없애");
            intent.putExtra("tv_like", "798");
        }
        getContext().startActivity(intent);
    }
}