package com.me.mvpapp.module.homepage.model;

import com.me.mvpapp.http.apis.WanAndroidApis;
import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;
import com.me.mvpapp.http.cache.WanAndroidCache;
import com.me.mvpapp.module.homepage.contract.HomePageContract;
import com.me.mvplib.base.model.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;

public class HomePageModel extends BaseModel<HomePageRespository> implements HomePageContract.Model {


    @Inject
    public HomePageModel() {

    }


    public Observable<BannerBean> getBannerData(boolean update){
        Observable<BannerBean> homeBannerList = mRetrofitManager.createService(WanAndroidApis.class).getHomeBannerList();
        Observable<BannerBean> homeBannerCache = mRetrofitManager.getCacheService(WanAndroidCache.class).getHomeBannerCache(homeBannerList, new EvictProvider(update));
        return homeBannerCache;
    }

    public Observable<HomeArticleBean> getHomeArticle(int page, boolean update){
        Observable<HomeArticleBean> homeArticleList = mRetrofitManager.getCacheService(WanAndroidApis.class).getHomeArticleList(page);
        Observable<HomeArticleBean> homeArticleCache = mRetrofitManager.getCacheService(WanAndroidCache.class).getHomeArticleCache(homeArticleList, new DynamicKey(page), new EvictProvider(update));
        return homeArticleCache;
    }





}
