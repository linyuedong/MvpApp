package com.me.mvplib.base.acticity;

import com.me.mvplib.base.presenter.BasePresenter;


public  abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {


    public T mPresenter;

    @Override
    public void onViewCreate() {
        super.onViewCreate();
        mPresenter = createPresenter();
        if(mPresenter == null){
            throw new IllegalStateException("Please call mPresenter in BaseMVPActivity(createPresenter) to create!");
        }else{
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if(mPresenter != null){
            mPresenter.detachView();
        }
        super.onDestroy();
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
