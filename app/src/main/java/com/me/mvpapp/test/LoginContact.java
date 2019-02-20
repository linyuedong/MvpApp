package com.me.mvpapp.test;

public interface LoginContact {

    interface View{
        void loginSuccess();
        void loginFailure();
    }

    interface Presenter{
        void login(String username, String password);
    }
}
