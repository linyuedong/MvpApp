package com.me.mvpapp.module.homepage.ui.fragment;


import android.support.v7.widget.RecyclerView;

import com.me.mvpapp.R;
import com.me.mvpapp.di.component.DaggerFragmentComponent;
import com.me.mvpapp.di.module.FragmentModule;
import com.me.mvpapp.module.homepage.contract.HomePageContract;
import com.me.mvpapp.module.homepage.presenter.HomePagePresenter;
import com.me.mvplib.base.BaseApplication;
import com.me.mvplib.base.fragment.BaseMvpFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;

public class HomePageFragment extends BaseMvpFragment<HomePagePresenter> implements HomePageContract.View {

    @BindView(R.id.main_pager_recycler_view)
    RecyclerView mMainPagerRecyclerView;
    @BindView(R.id.normal_view)
    SmartRefreshLayout mNormalView;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initView() {
        super.initView();


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
