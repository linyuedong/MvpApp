package com.me.mvplib.repository;

public class BaseRepositoryRemote<T extends IRemoteDataSource> implements IRepository {

    public T mRemoteDataSource;

    public BaseRepositoryRemote(T IRemoteDataSource) {
        mRemoteDataSource = IRemoteDataSource;


    }
}
