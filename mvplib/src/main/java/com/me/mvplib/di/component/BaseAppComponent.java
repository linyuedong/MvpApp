package com.me.mvplib.di.component;

import android.app.Application;

import com.me.mvplib.di.module.BaseAppModule;
import com.me.mvplib.http.RetrofitManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = BaseAppModule.class)
public interface BaseAppComponent {

    Application getApplication();

    RetrofitManager getRetrofitManager();

    void inject(Application application);

}
