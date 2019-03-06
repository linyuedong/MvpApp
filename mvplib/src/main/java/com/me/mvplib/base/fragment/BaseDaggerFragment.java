package com.me.mvplib.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.me.mvplib.base.BaseView;
import com.me.mvplib.base.presenter.IBasePresenter;

import javax.inject.Inject;

public abstract class BaseDaggerFragment<T extends IBasePresenter> extends BaseFragment implements BaseView {

    @Inject
    public T mPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInject();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter != null){
            mPresenter.onDestroy();
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