package com.me.mvpapp.test;

import android.text.TextUtils;

import com.me.mvplib.base.presenter.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginActivity> implements LoginContact.Presenter{

    @Override
    public void login(String username, String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mView.loginFailure();
        }else{
            mView.loginSuccess();
        }
    }
}
