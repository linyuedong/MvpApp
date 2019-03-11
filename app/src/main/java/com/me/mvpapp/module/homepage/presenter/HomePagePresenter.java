package com.me.mvpapp.module.homepage.presenter;

import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.WanAndroidResponse;
import com.me.mvpapp.module.homepage.contract.HomePageContract;
import com.me.mvpapp.module.homepage.model.HomePageModel;
import com.me.mvpapp.module.homepage.ui.fragment.HomePageFragment;
import com.me.mvpapp.utils.RxUtils;
import com.me.mvplib.Utils.LogUtlis;
import com.me.mvplib.base.presenter.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class HomePagePresenter extends BasePresenter<HomePageFragment,HomePageModel> implements HomePageContract.Presenter {

    @Inject
    public HomePagePresenter(HomePageFragment view, HomePageModel model) {
        super(view, model);
    }

    public void loadData(){

        mModel.getBannerData()
                .compose(RxUtils.rxSchedulersHelper())
                .subscribe(new Observer<WanAndroidResponse<List<BannerBean>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(WanAndroidResponse<List<BannerBean>> listWanAndroidResponse) {
                LogUtlis.i(listWanAndroidResponse.getData().get(0).getDesc());
            }

            @Override
            public void onError(Throwable e) {
                LogUtlis.i(e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        });

    }


}
