package com.me.mvplib.base.presenter;

import com.me.mvplib.base.acticity.BaseView;

public class BasePresenter<V extends BaseView> implements IBasePresenter{

    protected V mView;

    public BasePresenter(V view){
        this.mView = view;
    }

    @Override
    public void detachView(){
        this.mView = null;
    }




}
