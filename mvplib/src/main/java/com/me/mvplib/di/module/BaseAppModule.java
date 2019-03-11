package com.me.mvplib.di.module;

import android.app.Application;

import com.me.mvplib.http.RetrofitManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseAppModule {
    public Application mApplication;

    public BaseAppModule(Application application){
        this.mApplication=application;
    }


    @Provides
    @Singleton
    public Application provideApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    public RetrofitManager provideRetrofitManager(){
        return RetrofitManager.getInstance();
    }

}
