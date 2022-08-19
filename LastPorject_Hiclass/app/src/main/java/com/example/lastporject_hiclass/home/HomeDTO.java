package com.example.lastporject_hiclass.home;

public class HomeDTO {
    private int imgv_home;
    private String tv_like, title, content;

    public HomeDTO(int imgv_home, String tv_like, String title, String content) {
        this.imgv_home = imgv_home;
        this.tv_like = tv_like;
        this.title = title;
        this.content = content;
    }


    public int getImgv_home() {
        return imgv_home;
    }

    public void setImgv_home(int imgv_home) {
        this.imgv_home = imgv_home;
    }

    public String getTv_like() {
        return tv_like;
    }

    public void setTv_like(String tv_like) {
        this.tv_like = tv_like;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
