package com.me.mvpapp.di.module;

import android.app.Activity;

import com.me.mvpapp.test.Login.LoginActivity;
import com.me.mvpapp.test.Login1.LoginActivity1;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(LoginActivity activity) {
        this.mActivity = activity;
    }


    @Provides
    public LoginActivity provideActivity() {
        return (LoginActivity) mActivity;
    }

    public ActivityModule(LoginActivity1 activity) {
        this.mActivity = activity;
    }


    @Provides
    public LoginActivity1 provideActivity1() {
        return (LoginActivity1) mActivity;
    }
}
