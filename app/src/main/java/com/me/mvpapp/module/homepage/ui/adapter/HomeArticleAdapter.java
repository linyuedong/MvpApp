package com.me.mvpapp.module.homepage.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;

import java.util.List;

public class HomeArticleAdapter extends BaseQuickAdapter<HomeArticleBean,BaseViewHolder> {

    public HomeArticleAdapter(int layoutResId, @Nullable List<HomeArticleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeArticleBean item) {

    }
}
