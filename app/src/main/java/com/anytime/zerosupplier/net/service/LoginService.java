package com.anytime.zerosupplier.net.service;

import com.anytime.zerosupplier.bean.Login;
import com.anytime.zerosupplier.bean.LoginData;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by dream on 2017/6/15.
 */

public interface LoginService {
    @Headers({"Content-type:application/json"})
    @POST("Login")
    Call<LoginData> login(
            @Body Login login
    );
}
