package com.me.mvplib.base;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.me.mvplib.Utils.LogUtlis;
import com.me.mvplib.component.ActivityLifecycle;
import com.me.mvplib.di.component.BaseAppComponent;
import com.me.mvplib.di.component.DaggerBaseAppComponent;
import com.me.mvplib.di.module.BaseAppModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class BaseApplication extends Application {

    private static Application mApplication;
    private static boolean debug = false;
    private static RefWatcher mRefWatcher;
    private static BaseAppComponent baseAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        initDebugStatus();
        initInject();
        initLeakCanary();
        initBulgly();
        registerActivityLifecycleCallbacks(new ActivityLifecycle());

    }

    private void initBulgly() {

    }

    private void initInject() {
        DaggerBaseAppComponent
                .builder()
                .baseAppModule(new BaseAppModule(mApplication))
                .build()
                .inject(this);
    }

    public static BaseAppComponent getBaseAppComponent(){
        if(baseAppComponent == null){
            baseAppComponent = DaggerBaseAppComponent
                    .builder()
                    .baseAppModule(new BaseAppModule(mApplication))
                    .build();
        }

        return baseAppComponent;
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        mRefWatcher = LeakCanary.install(this);
    }

    private void initDebugStatus() {
        debug = getApplicationInfo() != null && (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        LogUtlis.i("debug = " + debug);
    }
    public static boolean isDebug(){
        return debug;
    }

    public static Application getContext(){
        return mApplication;
    }

    public static RefWatcher getRefWatcher(){
        return mRefWatcher;
    }
}
