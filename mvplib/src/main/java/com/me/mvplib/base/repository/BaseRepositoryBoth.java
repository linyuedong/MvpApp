package com.me.mvplib.base.repository;

public class BaseRepositoryBoth<R extends IRemoteDataSource, T extends ILocalDataSource> implements IRepository {


    public R mRemotelDataSource;
    public T mLocalDataSource;

    public BaseRepositoryBoth(R remotelDataSource, T localDataSource) {
        this.mRemotelDataSource = remotelDataSource;
        this.mLocalDataSource = localDataSource;
    }
}
