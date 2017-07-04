package com.anytime.zerosupplier.model;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.anytime.zerosupplier.bean.Login;
import com.anytime.zerosupplier.bean.LoginData;
import com.anytime.zerosupplier.model.AbInterface.ILoginModel;
import com.anytime.zerosupplier.net.RetrofitClient;
import com.anytime.zerosupplier.rxjava.HttpClienListener;
import com.anytime.zerosupplier.rxjava.MyObserver;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dream on 2017/6/15.
 */

public class LoginModel implements ILoginModel {
    private Login mLogin;
    Observable<LoginData> login;
    public LoginModel(Login mLogin) {
        this.mLogin = mLogin;
    }
    Handler handler=new Handler(Looper.getMainLooper());

    String url = "http://180.96.21.224:1518/SaleService/";
    @Override
    public void submit(final OnLoginSumit onLoginSumit) {

        login = new RetrofitClient().getService().login(mLogin);

        login.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<LoginData>(new HttpClienListener<LoginData>() {
                    @Override
                    public void onSuccess(@NonNull LoginData data) {
                        onLoginSumit.onSuccess(data);
                    }

                    @Override
                    public void onError(String s) {

                    }
                }));
    }

    /**
     * 取消请求
     */
    @Override
    public void unRequst() {
        System.out.println("-------------------------------------------------");
        Log.e("TAG", "unRequst: ---------------------------------------------------------------------" );
        login.unsubscribeOn(Schedulers.io());
    }
}
