package com.anytime.zerosupplier.model;

import com.anytime.zerosupplier.bean.CodeData;
import com.anytime.zerosupplier.model.AbInterface.IResetPass;
import com.anytime.zerosupplier.net.RetrofitClient;
import com.anytime.zerosupplier.net.service.ApiServiceManager;
import com.anytime.zerosupplier.rxjava.HttpClienListener;
import com.anytime.zerosupplier.rxjava.MyObserver;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;

/**
 * Created by dream on 2017/6/16.
 */

public class ResetPassModel implements IResetPass{


    @Override
    public void submit(OnRestSumit onRestSumit) {

    }

    @Override
    public void getCode(String username, final OnRestSumit onRestSumit) {
        ApiServiceManager service = new RetrofitClient().getService();
        Observable<CodeData> code = service.getCode(username);
        code.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<CodeData>(new HttpClienListener<CodeData>() {
                    @Override
                    public void onSuccess(@NonNull CodeData data) {
                        onRestSumit.onSuccess(data);
                    }

                    @Override
                    public void onError(String s) {

                    }
                }));
    }


    @Override
    public void unRequst() {

    }
}
