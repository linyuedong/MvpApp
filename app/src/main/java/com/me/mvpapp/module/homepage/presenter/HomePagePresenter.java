package com.me.mvpapp.module.homepage.presenter;

import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;
import com.me.mvpapp.module.homepage.contract.HomePageContract;
import com.me.mvpapp.module.homepage.model.HomePageModel;
import com.me.mvpapp.module.homepage.ui.fragment.HomePageFragment;
import com.me.mvpapp.utils.RxUtils;
import com.me.mvplib.Utils.LogUtlis;
import com.me.mvplib.base.BaseObserver;
import com.me.mvplib.base.presenter.BasePresenter;

import javax.inject.Inject;

public class HomePagePresenter extends BasePresenter<HomePageFragment,HomePageModel> implements HomePageContract.Presenter {


    public int mCurrentPage = 0;
    public boolean isRefresh = false;

    @Inject
    public HomePagePresenter() {

    }

    @Override
    public void loadData(){
        loadBannerData(false);
        loadArticleData(false);
       


    }


    @Override
    public void refresh() {
        isRefresh = true;
        mCurrentPage = 0;
        loadBannerData(true);
        loadArticleData(true);
    }

    @Override
    public void loadMore() {
        isRefresh = false;
        mCurrentPage++;
        loadArticleData(false);
    }

    private void loadArticleData(boolean isUpdate) {
        mModel.getHomeArticle(mCurrentPage,isUpdate)
                .compose(RxUtils.rxSchedulersHelper())
                .subscribe(new BaseObserver<HomeArticleBean>() {
                    @Override
                    public void onSuccess(HomeArticleBean homeArticleBean) {
                        mView.showArticle(homeArticleBean.getData(),isRefresh);
                    }

                    @Override
                    protected void onFail(Throwable e) {

                    }
                });
    }

    private void loadBannerData(boolean isUpdate) {
        mModel.getBannerData(isUpdate)
                .compose(RxUtils.rxSchedulersHelper())
                .subscribe(new BaseObserver<BannerBean>() {
                    @Override
                    public void onSuccess(BannerBean bannerBean) {
                        LogUtlis.i(bannerBean.getData().get(0).getDesc());
                        mView.showBanner(bannerBean.getData());

                    }

                    @Override
                    protected void onFail(Throwable e) {
                        LogUtlis.i(e.getMessage());

                    }
                });

    }





}
