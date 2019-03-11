package com.me.mvpapp.utils;


import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;


public class ViewUtils {

    public static void setCenterTitle(Toolbar toolbar , ActionBar actionBar, CharSequence title) {
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }
        toolbar.setTitle(title);
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View view = toolbar.getChildAt(i);
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (title.equals(textView.getText())) {
                    textView.setGravity(Gravity.CENTER);
                    Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.MATCH_PARENT);
                    params.gravity = Gravity.CENTER;
                    textView.setLayoutParams(params);
                }
            }

        }
    }




    public static void DisplayHomeAsUpEnabled(AppCompatActivity activity, Toolbar toolbar, boolean displayHomeAsUpEnabled){
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled);
        if(!displayHomeAsUpEnabled) return;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    activity.finishAfterTransition();
                } else {
                    activity.onBackPressed();
                }
            }
        });

    }


    public static int getWidth(View view){
        return getWidthAndHeight(view)[0];
    }

    public static int getHeight(View view){
        return getWidthAndHeight(view)[1];
    }

    private static int[] getWidthAndHeight(View view){
       final int[] result = new int[2];
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                result[0] = view.getWidth();
                result[1] = view.getHeight();

            }
        });
        return result;
    }




}
