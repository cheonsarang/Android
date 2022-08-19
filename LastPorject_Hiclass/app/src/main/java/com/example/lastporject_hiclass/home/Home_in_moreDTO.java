package com.example.lastporject_hiclass.home;

public class Home_in_moreDTO {
    private String title_m, date_m, content_title_m, content_m, like_m;
    private int imgv_m;

    public Home_in_moreDTO(String title_m, String date_m, String content_title_m, String content_m, String like_m, int imgv_m) {
        this.title_m = title_m;
        this.date_m = date_m;
        this.content_title_m = content_title_m;
        this.content_m = content_m;
        this.like_m = like_m;
        this.imgv_m = imgv_m;
    }

    public String getTitle_m() {
        return title_m;
    }

    public void setTitle_m(String title_m) {
        this.title_m = title_m;
    }

    public String getDate_m() {
        return date_m;
    }

    public void setDate_m(String date_m) {
        this.date_m = date_m;
    }

    public String getContent_title_m() {
        return content_title_m;
    }

    public void setContent_title_m(String content_title_m) {
        this.content_title_m = content_title_m;
    }

    public String getContent_m() {
        return content_m;
    }

    public void setContent_m(String content_m) {
        this.content_m = content_m;
    }

    public String getLike_m() {
        return like_m;
    }

    public void setLike_m(String like_m) {
        this.like_m = like_m;
    }

    public int getImgv_m() {
        return imgv_m;
    }

    public void setImgv_m(int imgv_m) {
        this.imgv_m = imgv_m;
    }
}
