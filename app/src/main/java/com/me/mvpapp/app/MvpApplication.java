package com.me.mvpapp.app;

import com.me.mvplib.Utils.LogUtlis;
import com.me.mvplib.base.BaseApplication;

public class MvpApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtlis.setGlobleTag(Constants.GLOBLE_TAG);
    }
}
