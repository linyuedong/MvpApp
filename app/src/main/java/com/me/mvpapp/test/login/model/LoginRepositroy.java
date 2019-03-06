package com.me.mvpapp.test.login.model;

import com.me.mvplib.base.repository.BaseRepositoryBoth;

public class LoginRepositroy extends BaseRepositoryBoth<LoginRemoteDataResource,LoginLocalDataResource> {

    public LoginRepositroy(LoginRemoteDataResource remotelDataSource, LoginLocalDataResource localDataSource) {
        super(remotelDataSource, localDataSource);
    }






}
