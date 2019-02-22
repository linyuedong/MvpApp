package com.me.mvplib.base;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.me.mvplib.Utils.LogUtlis;
import com.me.mvplib.component.ActivityLifecycle;
import com.squareup.leakcanary.LeakCanary;

public class BaseApplication extends Application {

    private static Application mApplication;
    private static boolean debug = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        initDebugStatus();
        initLeakCanary();
        registerActivityLifecycleCallbacks(new ActivityLifecycle());
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private void initDebugStatus() {
        debug = getApplicationInfo() != null && (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        LogUtlis.i("debug = " + debug);
    }
    public static boolean isDebug(){
        return debug;
    }
}
