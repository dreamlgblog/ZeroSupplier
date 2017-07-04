package com.anytime.zerosupplier.rxjava;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by dream on 2017/6/16.
 */

public class MyObserver<T> implements Observer<T> {
    private HttpClienListener<T> listener;
    public MyObserver(HttpClienListener<T> listener){
        this.listener = listener;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull Object o) {
        listener.onSuccess((T)o);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        listener.onError(e.getLocalizedMessage());
    }

    @Override
    public void onComplete() {

    }


}
