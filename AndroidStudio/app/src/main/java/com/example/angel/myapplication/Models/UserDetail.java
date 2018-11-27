package com.example.angel.myapplication.Models;

import android.widget.ListView;

public class UserDetail {

    private String area_resources;
    private String  tv_email;
    private String fbUserName;
    private  String tv_telephone;


    private String link;

    private ListView lv_materias;
    boolean zaviable;
    int score;

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
