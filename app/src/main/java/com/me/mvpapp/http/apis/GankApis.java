package com.me.mvpapp.http.apis;


import com.me.mvpapp.app.Constants;
import com.me.mvpapp.http.bean.gank.GankHttpResponse;
import com.me.mvpapp.http.bean.gank.GankItemBean;
import com.me.mvpapp.http.bean.gank.GankSearchItemBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

/**
 * Created by codeest on 16/8/19.
 */

public interface GankApis {

    /**
     * 技术文章列表
     */
    @Headers({DOMAIN_NAME_HEADER + Constants.GANK_DOMAIN_NAME})
    @GET("data/{tech}/{num}/{page}")
    Observable<GankItemBean> getTechList(@Path("tech") String tech, @Path("num") int num, @Path("page") int page);

    /**
     * 妹纸列表
     */
    @Headers({DOMAIN_NAME_HEADER + Constants.GANK_DOMAIN_NAME})
    @GET("data/福利/{num}/{page}")
    Observable<GankHttpResponse<List<GankItemBean>>> getGirlList(@Path("num") int num, @Path("page") int page);

    /**
     * 搜索
     */
    @Headers({DOMAIN_NAME_HEADER + Constants.GANK_DOMAIN_NAME})
    @GET("search/query/{query}/category/{type}/count/{count}/page/{page}")
    Observable<GankHttpResponse<List<GankSearchItemBean>>> getSearchList(@Path("query") String query, @Path("type") String type, @Path("count") int num, @Path("page") int page);



}
