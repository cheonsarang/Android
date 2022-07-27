package com.example.test03_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView balance, order;
    String orderText="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        ArrayList<VendingListDTO> list = (ArrayList<VendingListDTO>) intent.getSerializableExtra("list");
        Log.d("값", String.valueOf(list.size()));

        balance = findViewById(R.id.balance);
        order = findViewById(R.id.order);

        for(int i=0; i<list.size(); i++) {
           if (list.get(i).getQty() != 0) {
                orderText += list.get(i).getName()+list.get(i).getQty()+"개,";
            }
        }


        orderText = orderText.replaceAll(",$", "");
        order.setText(orderText);

        String bal = intent.getStringExtra("balance");
        balance.setText(bal);



    }
}