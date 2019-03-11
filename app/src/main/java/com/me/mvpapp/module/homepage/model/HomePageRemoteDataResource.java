package com.me.mvpapp.module.homepage.model;

import com.me.mvpapp.http.apis.WanAndroidApis;
import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;
import com.me.mvpapp.http.bean.wanAndroid.WanAndroidResponse;
import com.me.mvplib.base.repository.IRemoteDataSource;
import com.me.mvplib.http.RetrofitManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HomePageRemoteDataResource implements IRemoteDataSource {


    public RetrofitManager mRetrofitManager ;

    @Inject
    public HomePageRemoteDataResource(RetrofitManager retrofitManager){
        this.mRetrofitManager = retrofitManager;
    }


    public Observable<WanAndroidResponse<List<BannerBean>>> getBannerData(){
        return mRetrofitManager.createService(WanAndroidApis.class).getHomeBannerList();
    }

    public Observable<WanAndroidResponse<HomeArticleBean>> getHomeArticle(int page){
        return mRetrofitManager.createService(WanAndroidApis.class).getHomeArticleList(page);
    }

}
