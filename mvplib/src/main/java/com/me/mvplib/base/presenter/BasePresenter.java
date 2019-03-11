package com.me.mvplib.base.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.me.mvplib.base.acticity.BaseView;
import com.me.mvplib.base.model.IModel;

import javax.inject.Inject;

public class BasePresenter<V extends BaseView,M extends IModel> implements IBasePresenter<V>,LifecycleObserver {

    protected V mView;

    @Inject
    protected M mModel;



    @Override
    public void attachView(V view) {
        mView = view;
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(LifecycleOwner owner){
        ((LifecycleOwner) mView).getLifecycle().addObserver((LifecycleObserver) mModel);

    }

    @Override
    public void onDestroy() {
        if (mModel != null){
            mModel.onDestroy();
            mModel = null;
        }
        if(mView != null){
            mView = null;
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
    }


}
