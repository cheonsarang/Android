package com.example.and11_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_name1, tv_name2, tv_cnt1, tv_cnt2, tv_money;
    Button btn_order1, btn_order2, btn_inputmoney, btn_ok;
    EditText edt_money;
    ArrayList<DrinkDTO> list; //= new ArrayList<>();   //ArrayList 사용할 준비 마침(초기화)
    DrinkDAO dao = new DrinkDAO();
    //ViewDTO dto = new ViewDTO(findViewById(R.id.tv_name1), findViewById(R.id.tv_cnt1), findViewById(R.id.btn_order1));
    ArrayList<ViewDTO> v_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = dao.initDrinks();        //음료 2건을 만들어 냄, 사실 디비에서 가져와야 함

        v_list.add(new ViewDTO(findViewById(R.id.tv_name1), findViewById(R.id.tv_cnt1), findViewById(R.id.btn_order1)));
        v_list.add(new ViewDTO(findViewById(R.id.tv_name2), findViewById(R.id.tv_cnt2), findViewById(R.id.btn_order2)));

        for(int i = 0; i < v_list.size(); i++) {
            v_list.get(i).getBtn_order().setOnClickListener(this);
        }

        tv_money = findViewById(R.id.tv_money);
        btn_inputmoney = findViewById(R.id.btn_inputmoney);
        btn_ok = findViewById(R.id.btn_ok);
        edt_money = findViewById(R.id.edt_money);
        dao.setData(list, v_list);


        /*
        ArrayList와 DTO 구조로 묶어서 사용 안해도 되는 부분
        tv_cnt1 = findViewById(R.id.tv_cnt1);
        tv_cnt2 = findViewById(R.id.tv_cnt2);

        tv_name1 = findViewById(R.id.tv_name1);
        tv_name1.setText(list.get(0).getNameCnt());

        tv_name2 = findViewById(R.id.tv_name2);
        tv_name2.setText(list.get(1).getNameCnt());

        tv_money = findViewById(R.id.tv_money);
        btn_order1 = findViewById(R.id.btn_order1);
        btn_order2 = findViewById(R.id.btn_order2);
        btn_inputmoney = findViewById(R.id.btn_inputmoney);
        btn_ok = findViewById(R.id.btn_ok);
        edt_money = findViewById(R.id.edt_money);*/

        /*
        배열로 사용할 수 있게
        TextView[] tvs = new TextView[2];
        Integer[] tv = {R.id.tv_name1, R.id.tv_name2};

        for (int i = 0; i < tvs.length; i++) {
            tvs[i] = findViewById(tv[i]);
        }*/
    }

    @Override
    public void onClick(View v) {
        int i = 0;
        if(v.getId() == R.id.btn_order1) {
        i = 0;
        }else if(v.getId() == R.id.btn_order2) {
        i = 1;
        }
        dao.setMinusDrink(list, i);
        dao.setData(list, v_list);
    }
}