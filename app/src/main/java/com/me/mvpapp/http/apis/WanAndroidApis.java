package com.me.mvpapp.http.apis;


import com.me.mvpapp.app.Constants;
import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;
import com.me.mvpapp.http.bean.wanAndroid.NavigationBean;
import com.me.mvpapp.http.bean.wanAndroid.TreeBean;
import com.me.mvpapp.http.bean.wanAndroid.WanAndroidResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

public interface WanAndroidApis {


    @Headers({DOMAIN_NAME_HEADER + Constants.WANAndroid_DOMAIN_NAME})
    @GET("article/list/{page}/json")
    Observable<WanAndroidResponse<HomeArticleBean>> getHomeArticleList(@Path("page") int page);

    @Headers({DOMAIN_NAME_HEADER + Constants.WANAndroid_DOMAIN_NAME})
    @GET("banner/json")
    Observable<WanAndroidResponse<List<BannerBean>>> getHomeBannerList();

    @Headers({DOMAIN_NAME_HEADER + Constants.WANAndroid_DOMAIN_NAME})
    @GET("tree/json")
    Observable<WanAndroidResponse<List<TreeBean>>> getTree();

    @Headers({DOMAIN_NAME_HEADER + Constants.WANAndroid_DOMAIN_NAME})
    @GET("navi/json")
    Observable<WanAndroidResponse<List<NavigationBean>>> getNavition();




}
