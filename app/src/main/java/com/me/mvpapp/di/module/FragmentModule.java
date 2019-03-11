package com.me.mvpapp.di.module;

import com.me.mvpapp.module.homepage.ui.fragment.HomePageFragment;

import dagger.Module;
import dagger.Provides;


@Module
public class FragmentModule {


    public HomePageFragment mView;


    public FragmentModule(HomePageFragment view){
        this.mView = view;
    }

    @Provides
    public HomePageFragment provideHomePageFragment(){
        return mView;
    }


//    @Provides
//    public HomePagePresenter provideHomePagePresenter(HomePageFragment view, HomePageModel model){
//        return new HomePagePresenter(view,model);
//    }

//    @Provides
//    public HomePageModel provideHomePageModel(HomePageRespository homePageRespository){
//        return new HomePageModel(homePageRespository);
//    }
//
//    @Provides
//    public HomePageRespository provideHomePageRespository(HomePageRemoteDataResource homePageRemoteDataResource){
//        return new HomePageRespository(homePageRemoteDataResource);
//    }
//
//    @Provides
//    public HomePageRemoteDataResource provideHomePageRemoteDataResource(RetrofitManager retrofitManager){
//        return new HomePageRemoteDataResource(retrofitManager);
//    }
}
