package com.me.mvpapp.test.login.model;

import com.me.mvplib.http.RetrofitManager;

public class LoginRemoteDataResource implements LoginInterface.Remote {

    public RetrofitManager mRetrofitManager = null;

    public LoginRemoteDataResource(RetrofitManager retrofitManager){
        mRetrofitManager = retrofitManager;
    }

    public void login(){

    }


}
