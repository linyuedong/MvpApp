package com.me.mvpapp.test;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.me.mvpapp.R;
import com.me.mvplib.base.acticity.BaseMvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContact.View {


    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @BindView(R.id.login_form)
    ScrollView loginForm;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initDataAndView() {

        emailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(email.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
    }


}

