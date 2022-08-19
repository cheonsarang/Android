package com.example.lego.gridview;

public class GridDTO {
    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GridDTO(int img_id, String content) {
        this.img_id = img_id;
        this.content = content;
    }

    private int img_id;
    private String content;



}
