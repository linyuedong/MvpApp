package com.me.mvplib.base.acticity;

import android.arch.lifecycle.LifecycleOwner;

import com.me.mvplib.base.presenter.BasePresenter;
import com.me.mvplib.base.presenter.IBasePresenter;

import javax.inject.Inject;

public abstract class BaseMvpDaggerActivity <T extends BasePresenter> extends BaseActivity implements BaseView {

    @Inject
    public T mPresenter;

    @Override
    public void onViewCreate() {
        super.onViewCreate();
        initPresenter();

    }

    private void initPresenter() {
        initInject();
        if(mPresenter != null){
            mPresenter.attachView(this);
            getLifecycle().addObserver(mPresenter);
        }

    }

    protected abstract void initInject() ;



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.onDestroy();
        }
        mPresenter = null;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {

    }
}
