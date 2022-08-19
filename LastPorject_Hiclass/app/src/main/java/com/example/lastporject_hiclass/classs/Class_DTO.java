package com.example.lastporject_hiclass.classs;

public class Class_DTO {
    private int imgv_id;
    private String tv_1, tv_2;


    public Class_DTO(int imgv_id, String tv_1, String tv_2) {
        this.imgv_id = imgv_id;
        this.tv_1 = tv_1;
        this.tv_2 = tv_2;
    }


    public int getImgv_id() {
        return imgv_id;
    }

    public void setImgv_id(int imgv_id) {
        this.imgv_id = imgv_id;
    }

    public String getTv_1() {
        return tv_1;
    }

    public void setTv_1(String tv_1) {
        this.tv_1 = tv_1;
    }

    public String getTv_2() {
        return tv_2;
    }

    public void setTv_2(String tv_2) {
        this.tv_2 = tv_2;
    }
}
