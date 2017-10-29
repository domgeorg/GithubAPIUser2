package com.example.christiannatsaliki.githubapiuser;

import android.util.Log;

/**
 * Created by ChristiannaTsaliki on 22/10/2017.
 */

public class usersModel {

    private String loginName;
    private String type;
    private String url ;

    public usersModel(){};

    public usersModel(String login, String type,String url){
        this.loginName = login  ;
        this.type = type;
        this.url = url;
    }

    public void setLogin(String login){
        this.loginName = login;
    }

    public String getLogin(){
        return this.loginName;
    }

    public void setType(String newType){
        this.type = newType;
    }

    public String getType(){
        return this.type;
    }

    public void setUrl(String newUrl){
        this.url = newUrl;
    }

    public String getUrl(){
        return this.url;
    }

    public void PrintModel(){
        Log.d("ModelLogin:", this.loginName);
        Log.d("ModelType:", this.type);
        Log.d("ModelUrl:", this.url);
    }

}
