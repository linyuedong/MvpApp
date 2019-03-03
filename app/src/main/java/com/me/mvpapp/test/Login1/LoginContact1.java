package com.me.mvpapp.test.Login1;

public interface LoginContact1 {

    interface View  {
        void loginSuccess();
        void loginFailure();
    }

    interface Presenter{
        void login(String username, String password);
    }

    interface Model {

    }
}
