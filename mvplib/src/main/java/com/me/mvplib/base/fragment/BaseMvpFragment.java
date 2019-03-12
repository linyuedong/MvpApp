package com.me.mvplib.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.me.mvplib.base.acticity.BaseView;
import com.me.mvplib.base.presenter.IBasePresenter;

import javax.inject.Inject;

public abstract class BaseMvpFragment<T extends IBasePresenter> extends BaseFragment implements BaseView {

    @Inject
    public T mPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
    }

    private void initPresenter() {
        initInject();
        if(mPresenter != null){
            mPresenter.attachView(this);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter != null){
            mPresenter.detach();
        }
        mPresenter = null;
    }

    protected abstract void initInject();

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
