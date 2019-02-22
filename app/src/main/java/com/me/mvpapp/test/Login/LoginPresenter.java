package com.me.mvpapp.test.Login;

import android.text.TextUtils;

import com.me.mvplib.base.presenter.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginActivity> implements LoginContact.Presenter{


    @Inject
    public LoginPresenter(LoginActivity view) {
        super(view);
    }



    @Override
    public void login(String username, String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mView.loginFailure();
        }else{
            mView.loginSuccess();


        }
    }
}