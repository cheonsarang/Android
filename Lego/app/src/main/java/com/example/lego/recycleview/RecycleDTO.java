package com.example.lego.recycleview;

public class RecycleDTO {
    private int img_id;
    private String title, time;

    public RecycleDTO(int img_id, String title, String time) {
        this.img_id = img_id;
        this.title = title;
        this.time = time;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
