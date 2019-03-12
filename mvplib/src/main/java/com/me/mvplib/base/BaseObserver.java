package com.me.mvplib.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T>{

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }


    @Override
    public void onError(Throwable e) {
        onFail(e);
    }


    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T t) ;
    protected abstract void onFail(Throwable e);
}

