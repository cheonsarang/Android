package com.example.and11_vendingmachine;

import java.util.ArrayList;

public class DrinkDAO {
    //DrinkDTO 2건을 가진 ArrayList를 return 하는 메소드 initDrinks를 만들기
    public ArrayList<DrinkDTO> initDrinks() {
        ArrayList<DrinkDTO> list = new ArrayList();
        list.add(new DrinkDTO("콜라", 1000, 10));
        list.add(new DrinkDTO("사이다", 900, 8));
        return list;
    }

    //ArrayList<ViewDTO> <= 텍스트1, 수량1, 버튼1, ... 2,2,2,
    //ArrayList<DrinkDTO>를 입력받아 ArrayList<ViewDTO>의 내용을 세팅할 수 있는 메소드
    //두개의 ArrayList는 사이즈가 같기 때문에 index(주소)를 잘 활용하면 데이터 매칭이 편리
    /*public void setViewDTO(ViewDTO dto) {
        dto.getTv_name().setText("텍스트");
    }*/

    //Data <- ArrayList<DrinkDTO> list 메인에 있는 리스트를 활용
    //Widget <- 데이터를 표현하기 위한 위젯들을 묶어놓은 리스트 활용
    public void setData(ArrayList<DrinkDTO> list, ArrayList<ViewDTO> v_list) {
        for(int i = 0; i < v_list.size(); i++) {
            v_list.get(i).getTv_name().setText(list.get(i).getNameCnt());
            v_list.get(i).getTv_cnt().setText(list.get(i).getCnt()+" 개 남음");
        }
    }


    public void setMinusDrink(ArrayList<DrinkDTO> list, int index) {
        //수량 체크, 금액 체크(별도 메소드 사용)
        if(list.get(index).getCnt() == 0) {

        }else {
            list.get(index).setCnt(list.get(index).getCnt()-1);
        }


    }
}
