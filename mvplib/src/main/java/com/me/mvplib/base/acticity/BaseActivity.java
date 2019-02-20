package com.me.mvplib.base.acticity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        onViewCreate();
        initDataAndView();
    }

    protected abstract void initDataAndView();

    protected  void onViewCreate(){

    }

    protected abstract int getLayoutId() ;
}
