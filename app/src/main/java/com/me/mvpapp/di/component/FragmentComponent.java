package com.me.mvpapp.di.component;


import com.me.mvpapp.di.module.FragmentModule;
import com.me.mvpapp.module.homepage.ui.fragment.HomePageFragment;
import com.me.mvplib.di.component.BaseAppComponent;
import com.me.mvplib.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class,dependencies = BaseAppComponent.class)
public interface FragmentComponent {

    void inject(HomePageFragment homePageFragment);

}
