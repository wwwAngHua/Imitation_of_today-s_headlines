package com.today.app;

import java.util.List;

public class NewsBean {
    private int id;
    private String title;
    private List<Integer> imgList;
    private String name;
    private String comment;
    private String time;
    private int type;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return  this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getImgList() {
        return this.imgList;
    }

    public void setImgList(List<Integer> imgList) {
        this.imgList = imgList;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
