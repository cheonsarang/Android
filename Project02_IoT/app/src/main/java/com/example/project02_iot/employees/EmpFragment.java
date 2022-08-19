package com.example.project02_iot.employees;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class EmpFragment extends Fragment {
    RecyclerView recv_emp;
    SwipeRefreshLayout swipe_emp;
    SearchView search_emp;
    String keyword = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_emp, container, false);
        recv_emp = v.findViewById(R.id.recv_emp);
        swipe_emp = v.findViewById(R.id.swipe_emp);
        search_emp = v.findViewById(R.id.search_emp);
        recv_select();

        search_emp.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //돋보기 버튼(Submit) 전송버튼을 누르면 실행되는 곳 ( query 라는 변수는 입력된 값이 String 있음 )
                keyword = query;
                recv_select();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                keyword = newText;
                //글자가 바뀔때마다 실행되는 부분
                return false;
            }
        });

        swipe_emp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Refresh는 스와이트가 되서 동작하는 상태가 되면 처리할 이벤트 작성
                //swipe_emp.setRefreshing(false);를 안주면 계속해서 돌아감

                recv_select();
                swipe_emp.setRefreshing(false);
            }
        });


        return v;
    }

    public void recv_select() {
        CommonConn conn = new CommonConn(getContext(), "list.emp");
        conn.addParams("keyword", keyword);
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if (isResult) {
                    Log.d("사원 데이터 들어온거", "onResult: " + data);
                    ArrayList<EmployeeVO> list = new Gson().fromJson(data, new TypeToken<
                            ArrayList<EmployeeVO>>(){}.getType());

                    EmpAdapter adapter = new EmpAdapter(getLayoutInflater(), list, getContext(), EmpFragment.this);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    recv_emp.setLayoutManager(manager);
                    recv_emp.setAdapter(adapter);
                    swipe_emp.setRefreshing(false);
                }
            }
        });


    }
}