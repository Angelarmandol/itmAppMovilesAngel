package com.example.angel.myapplication.Models;

import android.widget.ListView;

public class UserDetail {

    public String area_resources;
    public String  tv_email;
    public String fbUserName;
    public  String tv_telephone;
    public String link;
    boolean zaviable;
    int score;
    private ListView lv_materias;


    public UserDetail(String name, String telephone, String email, String areaResources, String url, int score, boolean aviable) {
        this.fbUserName=name;
        this.tv_telephone=telephone;
        this.tv_email=email;
        this.area_resources=areaResources;
        this.link=url;
        this.score=score;
        this.zaviable=aviable;
    }


}
