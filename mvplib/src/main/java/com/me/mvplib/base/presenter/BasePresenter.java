package com.me.mvplib.base.presenter;

import android.media.Image;

import com.me.mvplib.base.acticity.BaseView;

public class BasePresenter<T extends BaseView> {

    protected T mView;

    public void attachView(T view){
        this.mView = view;
    }

    public void detachView(){
        this.mView = null;
    }




}
