package com.example.and13_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SubFragment extends Fragment {

    // 기본적으로 프래그먼트 파일을 추가하게 되면 불필요한 코드가 많음.
    // 우리가 필요한것은 onCreateView!만 있으면 됨.\
    // onCreateView라는 메소드는 항상 View타입이 리턴되어야한다.

    // 서브프래그먼트가 생성될때 상위 액티비티에서 받아오는 방식 ??????
    //
    Context context;
    //생성자를 이용해서 액티비티로 Context를 받아온다
    //3. 필요한 기능(객체)가 있고 생성하거나 받아올 수 없는 상황이면 객체가 생성될 때 해당하는 기능을 받아오면 됨
    public SubFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sub, container, false);

        Button btn_subFrag = v.findViewById(R.id.btn_subFrag);

        btn_subFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Context는 어떠한 기능을 사용하기위해서 상위 액티비티에서 무언가를 받아옴.
                //Toast.makeText(v.getContext(), "", Toast.LENGTH_SHORT).show(); <= 오류가 날 소지가 많음 x

                Toast.makeText(context, "킹받드라슈", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show(); // 1. Fragment에서 Context기능을 받아오기위한 첫번째방법.
                //Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show(); // 2. Fragment에서 Context기능을 받아오기위한 두번째방법.
            }
        });



        return v;


        // return 밑에는 절대로 실행될 문장이 아니기때문에 코드 에러. 지우거나 return 위로 올려야함.int aaa = 0 ;//?

    }
}