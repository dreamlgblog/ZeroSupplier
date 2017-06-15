package com.anytime.zerosupplier.model;

import android.os.Handler;
import android.os.Looper;

import com.anytime.zerosupplier.bean.Login;
import com.anytime.zerosupplier.bean.LoginData;
import com.anytime.zerosupplier.net.service.LoginService;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dream on 2017/6/15.
 */

public class LoginModel implements ILoginModel {
    private Login mLogin;
    public LoginModel(Login mLogin) {
        this.mLogin = mLogin;
    }
    Handler handler=new Handler(Looper.getMainLooper());

    String url = "http://180.96.21.224:1518/SaleService/";
    @Override
    public void submit(final OnLoginSumit onLoginSumit) {



        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();

        LoginService service = retrofit.create(LoginService.class);
       service.login(mLogin).enqueue(new Callback<LoginData>() {
           @Override
           public void onResponse(Call<LoginData> call, Response<LoginData> response) {
               onLoginSumit.onSuccess(response.body());
           }

           @Override
           public void onFailure(Call<LoginData> call, Throwable t) {

           }
       });
    }
}
