package com.me.mvplib.base.repository;

public class BaseRepositoryRemote<T extends IRemoteDataSource> implements IRepository {

    public T mRemoteDataSource;

    public BaseRepositoryRemote(T IRemoteDataSource) {
        mRemoteDataSource = IRemoteDataSource;


    }
}
