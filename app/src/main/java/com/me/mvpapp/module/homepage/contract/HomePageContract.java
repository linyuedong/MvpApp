package com.me.mvpapp.module.homepage.contract;

import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;

import io.reactivex.Observable;

public interface HomePageContract {

    interface View {

    }

    interface Presenter {

    }


    interface Model {
        Observable<BannerBean> getBannerData(boolean update);
        Observable<HomeArticleBean> getHomeArticle(int page, boolean update);
    }
}
