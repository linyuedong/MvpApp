package com.me.mvpapp.module.homepage.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.me.mvpapp.R;
import com.me.mvpapp.http.bean.wanAndroid.ArticleDataBean;
import com.me.mvpapp.http.bean.wanAndroid.HomeArticleBean;

import java.util.List;
import java.util.Random;

public class HomeArticleAdapter extends BaseQuickAdapter<ArticleDataBean,BaseViewHolder> {

    public static int[] icons = {R.drawable.ic_boy_one,R.drawable.ic_boy_two,R.drawable.ic_boy_three,R.drawable.ic_boy_four,R.drawable.ic_boy_five,
            R.drawable.ic_girl_one,R.drawable.ic_girl_two,R.drawable.ic_girl_three,R.drawable.ic_girl_four,R.drawable.ic_girl_five};

    Random random = new Random();

    public HomeArticleAdapter(int layoutResId, @Nullable List<ArticleDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleDataBean item) {
        helper.setText(R.id.home_article_title,item.getTitle());
        helper.setImageResource(R.id.iconAndroidHome,icons[random.nextInt(10)]);

    }
}
