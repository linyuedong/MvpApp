package com.me.mvpapp.http.cache;

import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;

public interface WanAndroidCache {



    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<BannerBean> getHomeBannerCache(Observable<BannerBean> techList, EvictProvider evictProvider);


    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<HomeArticleBean> getHomeArticleCache(Observable<HomeArticleBean> techList, DynamicKey idLastUserQueried, EvictProvider evictProvider);

}
