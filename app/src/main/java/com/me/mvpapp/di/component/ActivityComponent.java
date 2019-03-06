package com.me.mvpapp.di.component;

import com.me.mvpapp.di.module.ActivityModule;
import com.me.mvpapp.test.login.LoginActivity;
import com.me.mvpapp.test.Login1.LoginActivity1;

import dagger.Component;

@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity activity);
    void inject(LoginActivity1 activity);
}
