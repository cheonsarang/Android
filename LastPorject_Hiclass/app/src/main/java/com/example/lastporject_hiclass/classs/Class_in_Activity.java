package com.example.lastporject_hiclass.classs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lastporject_hiclass.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Class_in_Activity extends AppCompatActivity {
    ImageView back;
    TabLayout tabs_class;
    ListView listView_class;        // 검색을 보여줄 리스트변수
    EditText searchBar;             // 검색어를 입력할 Input 창
    ArrayList<Class_DTO> list_class, list_school;
    private ArrayList<Class_DTO> arraylist = new ArrayList<>();
    Class_in_Adapter adapter_class, adapter_school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_in);
        back = findViewById(R.id.back);
        listView_class = findViewById(R.id.listView_class);
        searchBar = findViewById(R.id.searchBar);

        tabs_class = findViewById(R.id.tabs_class);
        tabs_class.addTab(tabs_class.newTab().setText("클래스"));
        tabs_class.addTab(tabs_class.newTab().setText("학교"));




        //1리스트만들기
        list_class = new ArrayList<>();
        list_class.add(new Class_DTO("서울가락초등학교 2학년 4반", "이정민 선생님", "가입", R.drawable.garak));
        list_class.add(new Class_DTO("서울가주초등학교 1학년 2반", "여승주 선생님", "가입", R.drawable.gaju));
        list_class.add(new Class_DTO("가동초등학교 통합교육반", "서인하 선생님", "가입", R.drawable.gadong));
        list_class.add(new Class_DTO("후평초등학교 4학년 꿈나무", "최선희 선생님", "가입", R.drawable.hoopyeng));
        list_class.add(new Class_DTO("부천송일초등학교 다솜반", "류선리 선생님", "가입", R.drawable.boocheon));
        list_class.add(new Class_DTO("서울신상도 5학년 2반", "정안준 선생님", "가입", R.drawable.shin));
        list_class.add(new Class_DTO("새뜸초등학교 브라스 밴드부", "박용선 선생님", "가입", R.drawable.sae));
        list_class.add(new Class_DTO("망포초등학교 6학년 마라탕반", "권윤나 선생님", "가입", R.drawable.mangpo));
        list_class.add(new Class_DTO("영주가흥초등학교 4학년 바름반", "문인선 선생님", "가입", R.drawable.gaheannn));
        list_class.add(new Class_DTO("위례중앙초등학교 4학년 1반", "김민영 선생님", "가입", R.drawable.weeang));
        list_class.add(new Class_DTO("나비초등학교 3학년 5반", "정신영 선생님", "가입", R.drawable.nabi));
        list_class.add(new Class_DTO("영동초등학교 4학년 3반", "신수정 선생님", "가입", R.drawable.youngdong));
        list_class.add(new Class_DTO("극락초등학교 4학년 1반", "전효원 선생님", "가입", R.drawable.rack));
        adapter_class = new Class_in_Adapter(list_class, getLayoutInflater());

        arraylist.addAll(list_class);

        list_school = new ArrayList<>();
        list_school.add(new Class_DTO("인천가석초등학교", "인천 서구 가정3동 430-27", "구독하기", R.drawable.gaseck));
        list_school.add(new Class_DTO("인천가현초등학교", "인천 서구 신현동 2-103번지", "구독하기", R.drawable.gaheannn));
        list_school.add(new Class_DTO("신가초등학교", "광주 광산구 신가동 848번지", "구독하기", R.drawable.shinga));
        list_school.add(new Class_DTO("나곡초등학교", "경기 용인시 기흥구 보라동 162번지", "구독하기", R.drawable.nagock));
        list_school.add(new Class_DTO("다운초등학교", "울산 중구 다운동 811번지", "구독하기", R.drawable.down));
        list_school.add(new Class_DTO("보라초등학교", "경기 용인시 기흥구 상갈동 51-1", "구독하기", R.drawable.bora));
        list_school.add(new Class_DTO("새뜸초등학교", "새롬남로 75 KR 세종특별자치시", "구독하기", R.drawable.sae));
        list_school.add(new Class_DTO("나비초등학교", "경기도 김포시 김포한강10로134번길 70", "구독하기", R.drawable.nabi));
        list_school.add(new Class_DTO("서울가락초등학교", "서울특별시 송파구 송파대로37길 45", "구독하기", R.drawable.garak));
        list_school.add(new Class_DTO("영동초등학교", "충청북도 영동군 영동읍 영동천2길 47", "구독하기", R.drawable.youngdong));
        list_school.add(new Class_DTO("서울가주초등학교", "서울특별시 송파구 오금로40길 37", "구독하기", R.drawable.gaju));
        list_school.add(new Class_DTO("망포초등학교", "경기도 수원시 영통구 동탄지성로 550-10", "구독하기", R.drawable.mangpo));
        list_school.add(new Class_DTO("부천송일초등학교", "경기도 부천시 경인로60번길 19", "구독하기", R.drawable.boocheon));
        adapter_school = new Class_in_Adapter(list_school, getLayoutInflater());



        //2어뎁터 만들기
        //3.리스뷰에. setAdapter(adapter)

        listView_class.setAdapter(adapter_class);
        tabs_class.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if( tab.getPosition() == 0) {
                    listView_class.setAdapter(adapter_class);
                }else if( tab.getPosition() == 1) {
                    listView_class.setAdapter(adapter_school);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        searchBar.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("되냐", "beforeTextChanged: ");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("되냐", "onTextChanged: ");

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("되냐", "afterTextChanged: ");

                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = searchBar.getText().toString();
                search(text);
                search_school(text);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });





    }

    // 검색을 수행하는 메소드
    public void search(String charText) {
        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list_class.clear();


        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list_class.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else {
            // 리스트의 모든 데이터를 검색한다.
            for (int i = 0; i < arraylist.size(); i++) {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).getTitle_class().contains(charText)
                || arraylist.get(i).getContent_class().contains(charText)) {
                    // 검색된 데이터를 리스트에 추가한다.
                    list_class.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter_class.notifyDataSetChanged();
    }

    // 검색을 수행하는 메소드
    public void search_school(String charText) {
        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list_school.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list_school.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else {
            // 리스트의 모든 데이터를 검색한다.
            for (int i = 0; i < arraylist.size(); i++) {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).getTitle_class().contains(charText)
                        || arraylist.get(i).getContent_class().contains(charText)) {
                    // 검색된 데이터를 리스트에 추가한다.
                    list_school.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter_school.notifyDataSetChanged();
    }


}