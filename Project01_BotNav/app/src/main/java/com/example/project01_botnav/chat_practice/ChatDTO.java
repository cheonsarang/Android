package com.example.project01_botnav.chat_practice;

public class ChatDTO {
    private int imgv;
    private String name, content, time, num;

    public int getImgv() {
        return imgv;
    }

    public void setImgv(int imgv) {
        this.imgv = imgv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public ChatDTO(int imgv, String name, String content, String time, String num) {
        this.imgv = imgv;
        this.name = name;
        this.content = content;
        this.time = time;
        this.num = num;
    }
}


