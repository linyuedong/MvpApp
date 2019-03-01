package com.me.mvplib.repository;

public class BaseRepository<T extends ILocalDataSource> implements IRepository {

    public T mLocalDataSource;
    public RepositoryManager mRemoteDataSource;


    public BaseRepository(RepositoryManager repositoryManager){
        mRemoteDataSource = repositoryManager;
    }

    public BaseRepository(RepositoryManager repositoryManager , T localDataSource){
        mRemoteDataSource = repositoryManager;
        mLocalDataSource = localDataSource;
    }
}
