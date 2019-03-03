package com.me.mvplib.base.acticity;

import com.me.mvplib.base.presenter.IBasePresenter;

import javax.inject.Inject;

public abstract class BaseMvpDaggerActivity <T extends IBasePresenter> extends BaseActivity implements BaseView {

    @Inject
    public T mPresenter;

    @Override
    public void onViewCreate() {
        super.onViewCreate();
        initPresenter();

    }

    private void initPresenter() {
        initInject();

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
