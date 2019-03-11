package com.me.mvpapp.app;

import com.me.mvplib.Utils.LogUtlis;
import com.me.mvplib.base.BaseApplication;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

public class MvpApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtlis.setGlobleTag(Constants.GLOBLE_TAG);
        initRetrofit();
    }

    private void initRetrofit() {
        RetrofitUrlManager.getInstance().setDebug(true);
        //将每个 BaseUrl 进行初始化,运行时可以随时改变 DOMAIN_NAME 对应的值,从而达到切换 BaseUrl 的效果
        RetrofitUrlManager.getInstance().putDomain(Constants.WANAndroid_DOMAIN_NAME, Constants.APP_WANAndroid_DOMAIN);
        RetrofitUrlManager.getInstance().putDomain(Constants.GANK_DOMAIN_NAME, Constants.APP_GANK_DOMAIN);

    }
}
