package com.me.mvpapp.module.homepage.ui.fragment;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.me.commonres.statusview.StatusView;
import com.me.mvpapp.R;
import com.me.mvpapp.di.component.DaggerFragmentComponent;
import com.me.mvpapp.di.module.FragmentModule;
import com.me.mvpapp.http.bean.wanAndroid.BannerBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;
import com.me.mvpapp.module.homepage.contract.HomePageContract;
import com.me.mvpapp.module.homepage.presenter.HomePagePresenter;
import com.me.mvpapp.module.homepage.ui.adapter.HomeArticleAdapter;
import com.me.mvplib.base.BaseApplication;
import com.me.mvplib.base.fragment.BaseMvpFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomePageFragment extends BaseMvpFragment<HomePagePresenter> implements HomePageContract.View {

    @BindView(R.id.main_pager_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.normal_view)
    SmartRefreshLayout mNormalView;

    @BindView(R.id.main_pager_status_view)
    StatusView mMainPagerStatusView;
    private ArrayList<HomeArticleBean> mHomeArticleBeans;
    private HomeArticleAdapter mHomeArticleAdapter;
    private Banner mBanner;
    private ArrayList<String> mBannerUrls;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initView() {
        super.initView();
        //mMainPagerStatusView.showErrorView();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mHomeArticleBeans = new ArrayList<>();
        mHomeArticleAdapter = new HomeArticleAdapter(R.layout.homepage_artlcle_item, mHomeArticleBeans);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setHasFixedSize(true);

        //add head banner
        LinearLayout mHeaderGroup = ((LinearLayout) LayoutInflater.from(mActivity).inflate(R.layout.head_banner, null));
        mBanner = mHeaderGroup.findViewById(R.id.head_banner);
        mHeaderGroup.removeView(mBanner);
        mHomeArticleAdapter.addHeaderView(mBanner);
        mRecyclerView.setAdapter(mHomeArticleAdapter);

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


    @Override
    public void showBanner(List<BannerBean> bannerBeans) {
        ArrayList<String> imageUrls = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        for (BannerBean bean : bannerBeans) {
            imageUrls.add(bean.getImagePath());
            titles.add(bean.getTitle());
        }
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(imageUrls);
        //banner设置方法全部调用完毕时最后调用
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(2000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void showArticle(HomeArticleBean homeArticleBean) {
    }



    public class GlideImageLoader extends ImageLoader {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.img_one_bi_one).
                error(R.mipmap.img_one_bi_one);
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(imageView.getContext())
                    .asBitmap()
                    .apply(requestOptions)
                    .load((String) path)
                    .into(imageView);
        }

    }
}
