package com.example.lego.listview;

public class ListDTO {
    private int img_id;

    public int getImg_back() {
        return img_back;
    }

    public void setImg_back(int img_back) {
        this.img_back = img_back;
    }

    public ListDTO(int img_id, int img_back, String title, String emp) {
        this.img_id = img_id;
        this.img_back = img_back;
        this.title = title;
        this.emp = emp;
    }

    private int img_back;
    private String title;
    private String emp;

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

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }




}
