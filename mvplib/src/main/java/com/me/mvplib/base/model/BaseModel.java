package com.me.mvplib.base.model;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.me.mvplib.base.repository.IRepository;

public class BaseModel<T extends IRepository> implements IModel,LifecycleObserver {

    public T mRepository;

    public BaseModel(T repository){
        this.mRepository = repository;
    }


    @Override
    public void onDestroy() {
        this.mRepository = null;
    }

    @OnLifecycleEvent( Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
    }


}
