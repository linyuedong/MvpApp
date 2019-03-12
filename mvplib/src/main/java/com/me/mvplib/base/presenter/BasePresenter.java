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


    /**
     * 对于Activity的Presenter来说，能够监听Activity的生命周期，因此可以不用在Activity的onDestroy中调用
     * 调用Presenter的detach()释放资源，直接在Presenter的onDestroy调用即可；
     * 对于Fragment的Presenter来说，无法监听Fragment本身的生命周期（监听的是Activity）,可能Fragment销毁了
     * 但是其依赖的Activity并没有销毁，因此需要在Fragment的onDestory方法中调用Presenter的detach方法
     */

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(LifecycleOwner owner){
        ((LifecycleOwner) mView).getLifecycle().addObserver((LifecycleObserver) mModel);

    }

    @Override
    public void detach() {
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
