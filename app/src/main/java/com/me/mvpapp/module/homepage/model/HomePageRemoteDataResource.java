package com.me.mvpapp.module.homepage.model;

import com.me.mvplib.base.repository.IRemoteDataSource;
import com.me.mvplib.http.RetrofitManager;

import javax.inject.Inject;

public class HomePageRemoteDataResource implements IRemoteDataSource {


    public RetrofitManager mRetrofitManager ;

    @Inject
    public HomePageRemoteDataResource(RetrofitManager retrofitManager){
        this.mRetrofitManager = retrofitManager;
    }




}
