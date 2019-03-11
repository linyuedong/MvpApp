package com.me.mvplib.base.acticity;

import com.me.mvplib.base.presenter.BasePresenter;


public  abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {


    public T mPresenter;

    @Override
    public void onViewCreate() {
        super.onViewCreate();
        initPresenter();

    }

    private void initPresenter() {
        mPresenter = createPresenter();
    }

    protected abstract T createPresenter();


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
