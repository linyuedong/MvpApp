package com.me.mvplib.base.presenter;

import com.me.mvplib.base.acticity.BaseView;

public interface IBasePresenter<V extends BaseView> {
    void attachView(V view);
    void detach();
}
