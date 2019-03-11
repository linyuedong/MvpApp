package com.me.mvplib.base.model;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.me.mvplib.base.repository.IRepository;

import javax.inject.Inject;

public class BaseModel<T extends IRepository> implements IModel,LifecycleObserver {

    @Inject
    public T mRepository;

    @Override
    public void onDestroy() {
        if(mRepository != null){
            mRepository = null;
        }
    }

    @OnLifecycleEvent( Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
    }


}
