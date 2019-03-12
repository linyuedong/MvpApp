package com.me.mvpapp.http.cache;


import com.me.mvpapp.http.bean.gank.GankItemBean;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;

public interface GankCache {

    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<GankItemBean> getTechList(Observable<GankItemBean> techList, DynamicKey idLastUserQueried, EvictProvider evictProvider);


}
