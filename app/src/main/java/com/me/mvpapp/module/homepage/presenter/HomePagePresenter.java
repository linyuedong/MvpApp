package com.me.mvpapp.module.homepage.presenter;

import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.module.homepage.contract.HomePageContract;
import com.me.mvpapp.module.homepage.model.HomePageModel;
import com.me.mvpapp.module.homepage.ui.fragment.HomePageFragment;
import com.me.mvpapp.utils.RxUtils;
import com.me.mvplib.Utils.LogUtlis;
import com.me.mvplib.base.BaseObserver;
import com.me.mvplib.base.presenter.BasePresenter;

import javax.inject.Inject;

public class HomePagePresenter extends BasePresenter<HomePageFragment,HomePageModel> implements HomePageContract.Presenter {

    @Inject
    public HomePagePresenter() {

    }

    public void loadData(){
        mModel.getBannerData(false)
                .compose(RxUtils.rxSchedulersHelper())
                .subscribe(new BaseObserver<BannerBean>() {
                    @Override
                    public void onSuccess(BannerBean bannerBean) {
                        LogUtlis.i(bannerBean.getData().get(0).getDesc());

                    }

                    @Override
                    protected void onFail(Throwable e) {
                        LogUtlis.i(e.getMessage());

                    }
                });



    }


}
