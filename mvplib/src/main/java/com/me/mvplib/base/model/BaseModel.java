package com.me.mvplib.base.model;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.me.mvplib.repository.IRepository;

public class BaseModel implements IModel,LifecycleObserver {

    public IRepository mRepository;

    public BaseModel(IRepository repository){
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
