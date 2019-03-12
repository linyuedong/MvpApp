package com.me.mvplib.base.acticity;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseActivity extends SupportActivity {


    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        onViewCreate();
        initDataAndView(savedInstanceState);
    }

    protected abstract void initDataAndView(Bundle savedInstanceState);

    protected  void onViewCreate(){

    }

    protected abstract int getLayoutId() ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY){
            mUnbinder.unbind();
        }
        mUnbinder = null;
    }
}
