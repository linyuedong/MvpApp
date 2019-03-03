package com.me.mvplib.repository;

import com.me.mvplib.R;

public class BaseRepositoryLocal<T extends ILocalDataSource> implements IRepository {


    public T mLocalDataSource;

    public BaseRepositoryLocal(T localDataSource) {
        this.mLocalDataSource = localDataSource;
    }
}
