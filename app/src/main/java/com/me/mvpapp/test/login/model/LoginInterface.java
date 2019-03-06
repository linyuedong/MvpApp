package com.me.mvpapp.test.login.model;

import com.me.mvplib.base.repository.ILocalDataSource;
import com.me.mvplib.base.repository.IRemoteDataSource;

public interface LoginInterface {

    interface Remote extends IRemoteDataSource{

    }


    interface Local extends ILocalDataSource{

    }

}
