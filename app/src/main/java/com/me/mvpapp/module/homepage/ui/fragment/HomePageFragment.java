package com.me.mvpapp.module.homepage.ui.fragment;


import com.me.mvpapp.R;
import com.me.mvpapp.di.component.DaggerFragmentComponent;
import com.me.mvpapp.di.module.FragmentModule;
import com.me.mvpapp.module.homepage.contract.HomePageContract;
import com.me.mvpapp.module.homepage.presenter.HomePagePresenter;
import com.me.mvplib.base.BaseApplication;
import com.me.mvplib.base.fragment.BaseDaggerFragment;

public class HomePageFragment extends BaseDaggerFragment<HomePagePresenter> implements HomePageContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.loadData();

    }

    @Override
    protected void initInject() {
        DaggerFragmentComponent.builder()
                .baseAppComponent(BaseApplication.getBaseAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build()
                .inject(this);
    }
}
