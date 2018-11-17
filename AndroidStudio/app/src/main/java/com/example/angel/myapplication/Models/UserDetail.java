package com.example.angel.myapplication.Models;

import android.widget.ListView;

public class UserDetail {

    private String area_resources;
    private String  tv_email;
    private String fbUserName;
    private  String tv_telephone;

    private ListView lv_materias;

    int score;

    public String getFbUserName() {
        return fbUserName;
    }

    public void setFbUserName(String fbUserName) {
        this.fbUserName = fbUserName;
    }

    public String getTv_telephone() {
        return tv_telephone;
    }

    public void setTv_telephone(String tv_telephone) {
        this.tv_telephone = tv_telephone;
    }

    public String getTv_email() {
        return tv_email;
    }

    public void setTv_email(String tv_email) {
        this.tv_email = tv_email;
    }

    public String getArea_resources() {
        return area_resources;
    }

    public void setArea_resources(String area_resources) {
        this.area_resources = area_resources;
    }

    public ListView getLv_materias() {
        return lv_materias;
    }

    public void setLv_materias(ListView lv_materias) {
        this.lv_materias = lv_materias;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }





}
