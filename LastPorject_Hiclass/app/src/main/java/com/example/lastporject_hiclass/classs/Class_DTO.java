package com.example.lastporject_hiclass.classs;

public class Class_DTO {

    private int imgv_id;
    private String tv_1, tv_2;

    public Class_DTO(int imgv_id, String tv_1, String tv_2) {
        this.imgv_id = imgv_id;
        this.tv_1 = tv_1;
        this.tv_2 = tv_2;
    }

    private String title_class;
    private String content_class;
    private String join_class;
    private int imgv_class;

    public int getImgv_class() {
        return imgv_class;
    }

    public void setImgv_class(int imgv_class) {
        this.imgv_class = imgv_class;
    }

    public Class_DTO(String title_class, String content_class, String join_class, int imgv_class) {
        this.title_class = title_class;
        this.content_class = content_class;
        this.join_class = join_class;
        this.imgv_class = imgv_class;
    }

    public String getTitle_class() {
        return title_class;
    }

    public void setTitle_class(String title_class) {
        this.title_class = title_class;
    }

    public String getContent_class() {
        return content_class;
    }

    public void setContent_class(String content_class) {
        this.content_class = content_class;
    }

    public String getJoin_class() {
        return join_class;
    }

    public void setJoin_class(String join_class) {
        this.join_class = join_class;
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
