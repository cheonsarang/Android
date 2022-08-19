package com.example.lastporject_hiclass.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.lastporject_hiclass.R;
import com.google.android.material.tabs.TabLayout;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment implements View.OnClickListener{
    TabLayout tabs;
    ImageView img1, img2, img3, img4, img5, class_all_h;
    TextView class_all, tv_cicle6, tv_cicle7, tv_cicle8, tv_cicle9;
    CircleImageView img_cicle6, img_cicle7, img_cicle8, img_cicle9;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        //frameLayout = v.findViewById(R.id.pager_home);

        img1 = v.findViewById(R.id.img1);
        img2 = v.findViewById(R.id.img2);
        img3 = v.findViewById(R.id.img3);
        img4 = v.findViewById(R.id.img4);
        img5 = v.findViewById(R.id.img5);
        tv_cicle6 = v.findViewById(R.id.tv_cicle6);
        tv_cicle7 = v.findViewById(R.id.tv_cicle7);
        tv_cicle8 = v.findViewById(R.id.tv_cicle8);
        tv_cicle9 = v.findViewById(R.id.tv_cicle9);

        img_cicle6 = v.findViewById(R.id.img_cicle6);
        img_cicle7 = v.findViewById(R.id.img_cicle7);
        img_cicle8 = v.findViewById(R.id.img_cicle8);
        img_cicle9 = v.findViewById(R.id.img_cicle9);

        class_all_h = v.findViewById(R.id.class_all_h);
        class_all = v.findViewById(R.id.class_all);


        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        class_all_h.setOnClickListener(this);
        class_all.setOnClickListener(this);

        tabs = v.findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("내소식"));
        tabs.addTab(tabs.newTab().setText("추천정보"));
        tabs.addTab(tabs.newTab().setText("자주 묻는 질문"));

        ViewPager pager = v.findViewById(R.id.pager_home);
        pager.setOffscreenPageLimit(3);

        HomeAdapter adapter = new HomeAdapter(getChildFragmentManager(), 1);

        Tab1Fragment fragment1 = new Tab1Fragment();
        adapter.addItem(fragment1);
        pager.setCurrentItem(1);

        Tab2Fragment fragment2 = new Tab2Fragment();
        adapter.addItem(fragment2);
        pager.setCurrentItem(2);

        Tab3Fragment fragment3 = new Tab3Fragment();
        adapter.addItem(fragment3);
        pager.setCurrentItem(3);

        pager.setAdapter(adapter);

        getChildFragmentManager().beginTransaction().replace(R.id.pager_home, new Tab1Fragment()).commit();
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    tabs.selectTab(tabs.getTabAt(0));
                }else if(position == 1){
                    tabs.selectTab(tabs.getTabAt(1));
                }else if ( position == 2){
                    tabs.selectTab(tabs.getTabAt(2));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    pager.setCurrentItem(0, true);
                }else if(tab.getPosition()==1){
                    pager.setCurrentItem(1, true);
                }else if(tab.getPosition()==2){
                    pager.setCurrentItem(2, true);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {

//        Intent intent = new Intent(getContext(), new Home_in_Activity().getClass());

        Intent intent = new Intent();
        if(v.getId() == R.id.img1){
            intent.setClass(getContext(), Home_in_Activity.class);
            intent.putExtra("page","home");
            intent.putExtra("title", "이벤트");
            intent.putExtra("content_title", "9월의 솜씨왕");
            intent.putExtra("content", "없애");
            intent.putExtra("imgv_home","1");
            intent.putExtra("tv_like", "784");

        }else if(v.getId() == R.id.img2){
            intent.setClass(getContext(), Home_in_Activity.class);
            intent.putExtra("page","home");
            intent.putExtra("title", "8월의 솜씨왕");
            intent.putExtra("content_title", "멋진 수원화성행궁");
            intent.putExtra("content", "(●'◡'●) 축하합니다, 8월의 솜씨왕\n" +
                    "\n" +
                    "본원초등학교 2학년 성은제 학생 ❣\n" +
                    "\n" +
                    "\n" +
                    "✔ 그림 설명 \n" +
                    "\n" +
                    "우리나라의 멋진 수원화성행궁을 세상에 널리 알리고 싶어요.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "✔ 하이클래스 하영쌤 한줄평 \n" +
                    "\n" +
                    "아름답기로 소문난 수원화성행궁 ! 그 행궁이 최초로 만들어질 당시의 상황을 멋지게 재현했네요 ღゝ◡╹)ノ");
            intent.putExtra("tv_like", "878");
            intent.putExtra("imgv_home", "2");
        }else if(v.getId() == R.id.img3){
            intent.setClass(getContext(), Home_in_Activity.class);
            intent.putExtra("page","home");
            intent.putExtra("title", "8월의 솜씨왕");
            intent.putExtra("content_title", "다시 찾은 우리나라!");
            intent.putExtra("content", "(●'◡'●) 축하합니다, 8월의 솜씨왕\n" +
                    "\n" +
                    "윤슬초등학교 3학년 김은아 학생 ❣\n" +
                    "\n" +
                    "\n" +
                    "✔ 그림 설명 \n" +
                    "\n" +
                    "우리나라를 끝까지 지키기 위해 노력한 유관순과 무궁화, 한복, 기쁨을 의미한 새를 그렸습니다.\n" +
                    "\n" +
                    "그림을 그리면서 우리나라를 되찾게 노력하신 분들을 생각했어요.\n" +
                    " \n" +
                    "\n" +
                    "✔ 하이클래스 하영쌤 한줄평 \n" +
                    "\n" +
                    "오늘의 대한민국을 가능하게 한 분들에게 늘 감사하는 마음을 가지며 이 아름다운 문화를 잘 지켜나가야겠어요 (๑•᎑<๑)");
            intent.putExtra("tv_like", "945");
            intent.putExtra("imgv_home", "3");
        }else if(v.getId() == R.id.img4){
            intent.setClass(getContext(), Home_in_Activity.class);
            intent.putExtra("page","home");
            intent.putExtra("title", "8월의 솜씨왕");
            intent.putExtra("content_title", "국보 익산미륵사지석탑");
            intent.putExtra("content", "(●'◡'●) 축하합니다, 8월의 솜씨왕\n" +
                    "\n" +
                    "대전둔천초등학교 4학년 서희서 학생 ❣\n" +
                    "\n" +
                    "\n" +
                    "✔ 그림 설명 \n" +
                    "\n" +
                    "국보 익산미륵사지석탑은 우리나라에서 가장 오래된 석탑입니다. \n" +
                    "\n" +
                    "엄마, 동생과 함께 몇년 전에 가봤는데 엄청 크고 웅장했습니다. \n" +
                    "\n" +
                    "그림을 그리면서 다시 한번 보러가보고 싶어졌습니다.\n" +
                    " \n" +
                    "\n" +
                    "✔ 하이클래스 하영쌤 한줄평 \n" +
                    "\n" +
                    "마치 눈앞에서 익산미륵사지 석탑을 올려다보고 있는 것 같아요!!  (๑> •̀๑)");
            intent.putExtra("tv_like", "945");
            intent.putExtra("imgv_home", "4");
        }else if(v.getId() == R.id.img5){
            intent.setClass(getContext(), Home_in_Activity.class);
            intent.putExtra("page","home");
            intent.putExtra("title", "8월의 솜씨왕");
            intent.putExtra("content_title", "한국의 전통적인 문화 소개");
            intent.putExtra("content", "(●'◡'●) 축하합니다, 8월의 솜씨왕\n" +
                    "\n" +
                    "성서초등학교 5학년 홍정민 학생 ❣\n" +
                    "\n" +
                    "\n" +
                    "✔ 그림 설명 \n" +
                    "\n" +
                    "한국에 오래전부터 내려오는 풍습, 문화, 전통들을 외국인이나 한국에 대해 잘 모르는 사람들을 대상으로 생각하여 그려봤습니다! \n" +
                    "\n" +
                    "한국의 고유하고 아름다운 특징들을 생각해 디테일도 표현해봤는데 잘 되었을지 모르겠네요.. \n" +
                    "\n" +
                    "몇 가지 안 되지만 제가 한국을 표현하는 것들로 생각되는 것들을 최선을 다해 그렸습니다.\n" +
                    " \n" +
                    "\n" +
                    "✔ 하이클래스 하영쌤 한줄평 \n" +
                    "\n" +
                    "오랜 작업시간만큼이나 정민 학생의 정성이 고스란히 들어간 그림이에요. 디테일도 최고!! ◍•ᴗ•◍");
            intent.putExtra("tv_like", "1509");
            intent.putExtra("imgv_home", "5");
        }else if(v.getId() == R.id.class_all || v.getId() == R.id.class_all_h) {
            intent.setClass(getContext(), Home_in_Activity.class);
            intent.putExtra("page","all");
            intent.putExtra("title", "추천 공식클래스");
            intent.putExtra("content_title", "없애");
            intent.putExtra("content", "없애");
            intent.putExtra("like_line", "없애");
            intent.putExtra("imgv_home", "1");
        }else if(v.getId() == R.id.tv_cicle6 || v.getId() == R.id.img_cicle6){
            intent.setClass(getContext(), Home_in_more_Activity.class);
        }
        startActivity(intent);

    }
}