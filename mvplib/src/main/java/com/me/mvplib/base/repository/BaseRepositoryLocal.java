package com.me.mvplib.base.repository;

public class BaseRepositoryLocal<T extends ILocalDataSource> implements IRepository {


    public T mLocalDataSource;

    public BaseRepositoryLocal(T localDataSource) {
        this.mLocalDataSource = localDataSource;
    }
}
