package com.me.mvpapp.test.Login1;

import android.text.TextUtils;

import com.me.mvplib.base.presenter.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter1 extends BasePresenter<LoginActivity1,LoginModel1> implements LoginContact1.Presenter{


    @Inject
    public LoginPresenter1(LoginActivity1 view) {
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
