package com.me.mvpapp.module.homepage.model;

import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;
import com.me.mvpapp.http.bean.wanAndroid.WanAndroidResponse;
import com.me.mvplib.base.repository.BaseRepositoryRemote;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HomePageRespository extends BaseRepositoryRemote<HomePageRemoteDataResource> {

    @Inject
    public HomePageRespository(HomePageRemoteDataResource IRemoteDataSource) {
        super(IRemoteDataSource);
    }

    public Observable<WanAndroidResponse<List<BannerBean>>> getBannerData(){
        return mRemoteDataSource.getBannerData();
    }

    public Observable<WanAndroidResponse<HomeArticleBean>> getHomeArticle(int page){
        return mRemoteDataSource.getHomeArticle(page);
    }
}
