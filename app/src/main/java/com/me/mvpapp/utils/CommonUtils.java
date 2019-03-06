package com.me.mvpapp.utils;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;

import com.me.mvpapp.app.MvpApplication;
import com.me.mvplib.Utils.LogUtlis;

public class CommonUtils {

    public static Context getAppContext(){
        return MvpApplication.getContext();
    }

    public static int getColor(@ColorRes int color){
        Context appContext = getAppContext();
        if(appContext == null){
            LogUtlis.i("null");
        } else{
            LogUtlis.i("not null");
        }
        return ContextCompat.getColor(getAppContext(),color);
    }
}
