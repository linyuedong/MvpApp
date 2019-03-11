package com.me.mvpapp.utils;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.me.mvpapp.app.MvpApplication;

public class CommonUtils {

    public static Context getAppContext(){
        return MvpApplication.getContext();
    }

    public static int getColor(@ColorRes int color){
        return ContextCompat.getColor(getAppContext(),color);
    }

    /**
     * 获取屏幕相关参数
     *
     * @return
     */
    public static String getScreenParams() {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getAppContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        int heightPixels = dm.heightPixels;
        int widthPixels = dm.widthPixels;
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        int densityDpi = dm.densityDpi;
        float density = dm.density;
        float scaledDensity = dm.scaledDensity;
        float heightDP = heightPixels / density;
        float widthDP = widthPixels / density;
        float smallestWidthDP;
        if(widthDP < heightDP) {
            smallestWidthDP = widthDP;
        }else {
            smallestWidthDP = heightDP;
        }
        String str = "heightPixels: " + heightPixels + "px";
        str += "\nwidthPixels: " + widthPixels + "px";
        str += "\nxdpi: " + xdpi + "dpi";
        str += "\nydpi: " + ydpi + "dpi";
        str += "\ndensityDpi: " + densityDpi + "dpi";
        str += "\ndensity: " + density;
        str += "\nscaledDensity: " + scaledDensity;
        str += "\nheightDP: " + heightDP + "dp";
        str += "\nwidthDP: " + widthDP + "dp";
        str += "\nsmallestWidthDP: " + smallestWidthDP + "dp";
        return str;
    }
}
