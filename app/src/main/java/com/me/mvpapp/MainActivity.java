package com.me.mvpapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.me.mvpapp.module.homepage.ui.fragment.HomePageFragment;
import com.me.mvpapp.utils.CommonUtils;
import com.me.mvpapp.utils.ViewUtils;
import com.me.mvpapp.widget.statusBar.StatusBarUtil;
import com.me.mvplib.base.acticity.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.content)
    FrameLayout mContent;
    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;


    private ArrayList<Fragment> mFragments;
    private HomePageFragment mHomePageFragment;
    private WxArticleFragment mWxArticleFragment;
    private MeFragment mMeFragment;
    private int mLastFgIndex;


    @Override
    protected void initDataAndView(Bundle savedInstanceState) {
        initFragment();
        initToolbar();
        initBottomNavigationView();
        initPage();
        //LogUtlis.i(CommonUtils.getScreenParams());

    }

    private void initPage() {
        loadPage(getString(R.string.title_homepage), 0);
    }

    private void initBottomNavigationView() {
        mNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_homepage:
                        loadPage(getString(R.string.title_homepage), 0);
                        return true;
                    case R.id.navigation_wxarticle:
                        loadPage(getString(R.string.title_wxarticle), 1);
                        return true;
                    case R.id.navigation_my:
                        loadPage(getString(R.string.title_my), 2);
                        return true;
                    default:
                        return true;

                }
            }
        });
    }

    private void loadPage(String title, int position) {
        setCenterTitle(title);
        switchFragment(position);
    }

    private void switchFragment(int position) {
        if (position >= mFragments.size()) {
            return;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment targetFg = mFragments.get(position);
        Fragment lastFg = mFragments.get(mLastFgIndex);
        mLastFgIndex = position;
        ft.hide(lastFg);
        if (!targetFg.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(targetFg).commitAllowingStateLoss();
            ft.add(R.id.content, targetFg);
        }
        ft.show(targetFg);
        ft.commitAllowingStateLoss();
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mHomePageFragment = new HomePageFragment();
        mWxArticleFragment = new WxArticleFragment();
        mMeFragment = new MeFragment();
        mFragments.add(mHomePageFragment);
        mFragments.add(mWxArticleFragment);
        mFragments.add(mMeFragment);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ViewUtils.DisplayHomeAsUpEnabled(this, mToolbar, false);
        StatusBarUtil.setColor(this, CommonUtils.getColor(R.color.colorPrimaryDark), 0);

    }


    public void setCenterTitle(String title) {
        ViewUtils.setCenterTitle(this, mToolbar, title);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
