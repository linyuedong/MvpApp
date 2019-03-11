package com.me.mvpapp.module.homepage.model;

import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;
import com.me.mvpapp.http.bean.wanAndroid.WanAndroidResponse;
import com.me.mvpapp.module.homepage.contract.HomePageContract;
import com.me.mvplib.base.model.BaseModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HomePageModel extends BaseModel<HomePageRespository> implements HomePageContract.Model {


    @Inject
    public HomePageModel(HomePageRespository repository) {
        super(repository);
    }


    public Observable<WanAndroidResponse<List<BannerBean>>> getBannerData(){
        return mRepository.getBannerData();
    }

    public Observable<WanAndroidResponse<HomeArticleBean>> getHomeArticle(int page){
        return mRepository.getHomeArticle(page);
    }


    @Override
    public void onDestroy() {

    }
}
