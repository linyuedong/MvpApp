package com.me.mvplib.base.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.me.mvplib.base.acticity.BaseView;
import com.me.mvplib.base.model.IModel;

public class BasePresenter<V extends BaseView,M extends IModel> implements IBasePresenter,LifecycleObserver {

    protected V mView;
    protected M mModel;

    public BasePresenter(V view){
        this.mView = view;
        onStart();
    }

    public BasePresenter(V view, M model){
        this.mView = view;
        this.mModel = model;
        onStart();
    }


    @Override
    public void onStart() {
        if(mView != null&&mView instanceof LifecycleOwner){
            ((LifecycleOwner) mView).getLifecycle().addObserver(this);
        }
        if(mModel != null&&mModel instanceof LifecycleOwner){
            ((LifecycleOwner) mView).getLifecycle().addObserver((LifecycleObserver) mModel);
        }
    }

    @Override
    public void onDestroy() {
        if (mModel != null)
            mModel.onDestroy();
        this.mModel = null;
        this.mView = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
    }


}
