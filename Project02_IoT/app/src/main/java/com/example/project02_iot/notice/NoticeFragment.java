package com.example.project02_iot.notice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;
import com.example.project02_iot.customer.CustomerVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;


public class NoticeFragment extends Fragment {
    TextView tv_test;
    ImageView imgv_test;
    //1. 애니메이션 객체준비
    Animation flowAnim, rotate;

    //2. load속성을 이용해서 만들어준 애니메이션 로딩

    //3. 위젯에 연결

    ViewPager2 pager2;
    RecyclerView recy_noti;
    SpringDotsIndicator indicator;
    ArrayList<Integer> img_list = new ArrayList<>();
    //ArrayList<NoticeVO> noti_list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notice, container, false);
        recy_noti = v.findViewById(R.id.recy_noti);


        img_list.add(new Integer(R.drawable.banner1));
        img_list.add(new Integer(R.drawable.banner2));
        img_list.add(new Integer(R.drawable.banner3));
        img_list.add(new Integer(R.drawable.banner4));
        img_list.add(new Integer(R.drawable.banner5));

        //img_list를 이용하여(size, bind) Pager2Adapter 라는 어댑터를 만들기
        //RecyclerView Adapter랑 똑같이 만들면 됨


        pager2 = v.findViewById(R.id.pager2);
        Pager2Adapter adapter = new Pager2Adapter(getLayoutInflater(), img_list);
        pager2.setAdapter(adapter);
        pager2.setPageTransformer(new ZoomOutPageTransformer());

        indicator = v.findViewById(R.id.indicator);
        indicator.setViewPager2(pager2);



        CommonConn conn = new CommonConn(getContext(), "list.no");
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult) {
                    ArrayList<NoticeVO> noti_list = new Gson().fromJson(data,
                            new TypeToken<ArrayList<NoticeVO>>(){}.getType());
                    Log.d(" 사이즈 ", "onResult: " + noti_list.size());
                    NoticeAdapter adapter = new NoticeAdapter(noti_list, getLayoutInflater());
                    recy_noti.setAdapter(adapter);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recy_noti.setLayoutManager(manager);
                }
            }
        });




        /* ==============애니메이션======================
      //  flowAnim = AnimationUtils.loadAnimation(getContext(), R.anim.flow);
      //  rotate = AnimationUtils.loadAnimation(getContext(), R.anim.rotate);

       // tv_test = v.findViewById(R.id.tv_test);
       // imgv_test = v.findViewById(R.id.imgv_test);

        //tv_test.startAnimation(flowAnim);
        //imgv_test.startAnimation(rotate);
        */

        autoSlide();
        return v;
    }

    public void autoSlide() {
        //new Handler() <- SplashActivity 페이지 전환용으로 사용
        //runOnUiThread(Activity에서만 접근 가능) <- 페이지 내부에서 디자인이 바뀌는용으로 쓰레드 사용 시
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < img_list.size(); i++) {
                    final int value = i;
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //비동기로 디자인 작업
                            pager2.setCurrentItem(value);

                        }
                    });

                    try {
                        Thread.sleep(2000);
                        if(i == img_list.size()-1) {
                            i = -1;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();

    }

    public class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }
}