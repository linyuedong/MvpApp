package com.me.mvpapp.test.Login1;

import com.me.mvpapp.test.Login.LoginContact;
import com.me.mvplib.base.model.BaseModel;
import com.me.mvplib.repository.IRepository;

public class LoginModel1 extends BaseModel implements LoginContact.Model  {

    public LoginModel1(IRepository repository) {
        super(repository);
    }
}
