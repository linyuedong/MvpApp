package com.me.mvplib.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.me.mvplib.base.BaseView;
import com.me.mvplib.base.presenter.IBasePresenter;

public abstract class BaseMvpFragment<T extends IBasePresenter> extends BaseFragment implements BaseView {

    public T mPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter != null){
            mPresenter.onDestroy();
        }
        mPresenter = null;
    }

    private void initPresenter() {
        mPresenter = createPresenter();
    }

    protected abstract T createPresenter();


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
