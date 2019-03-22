package com.me.mvpapp.module.homepage.contract;

import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;

import java.util.List;

import io.reactivex.Observable;

public interface HomePageContract {

    interface View {

        void showBanner(List<BannerBean> bannerBeans);
        void showArticle(HomeArticleBean homeArticleBean);

    }

    interface Presenter {
        void loadData();
    }


    interface Model {
        Observable<BannerBean> getBannerData(boolean update);
        Observable<HomeArticleBean> getHomeArticle(int page, boolean update);
    }
}
