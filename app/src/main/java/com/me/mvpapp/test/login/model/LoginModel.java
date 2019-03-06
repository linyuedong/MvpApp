package com.me.mvpapp.test.login.model;

import com.me.mvpapp.test.login.LoginContact;
import com.me.mvplib.base.model.BaseModel;


public class LoginModel extends BaseModel<LoginRepositroy> implements LoginContact.Model {


    public LoginModel(LoginRepositroy repository) {
        super(repository);
    }





}
