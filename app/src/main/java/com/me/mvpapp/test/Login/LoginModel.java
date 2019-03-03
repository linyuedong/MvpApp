package com.me.mvpapp.test.Login;

import com.me.mvplib.base.model.BaseModel;
import com.me.mvplib.repository.IRepository;

public class LoginModel extends BaseModel implements LoginContact.Model  {

    public LoginModel(IRepository repository) {
        super(repository);
    }
}
