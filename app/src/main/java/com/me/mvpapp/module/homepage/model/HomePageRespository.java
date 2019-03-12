package com.me.mvpapp.module.homepage.model;

import com.me.mvplib.base.repository.BaseRepositoryRemote;

import javax.inject.Inject;

public class HomePageRespository extends BaseRepositoryRemote<HomePageRemoteDataResource> {

    @Inject
    public HomePageRespository(HomePageRemoteDataResource IRemoteDataSource) {
        super(IRemoteDataSource);
    }

}
