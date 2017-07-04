package com.anytime.zerosupplier.rxjava;

import io.reactivex.annotations.NonNull;

/**
 * Created by dream on 2017/6/16.
 */

public interface HttpClienListener<T> {
    void onSuccess(@NonNull T data);
    void onError(String s);
}
