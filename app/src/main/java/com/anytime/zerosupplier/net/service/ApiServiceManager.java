package com.anytime.zerosupplier.net.service;

import com.anytime.zerosupplier.bean.BaseData;
import com.anytime.zerosupplier.bean.CodeData;
import com.anytime.zerosupplier.bean.Login;
import com.anytime.zerosupplier.bean.LoginData;
import com.anytime.zerosupplier.bean.ResetPassword;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by dream on 2017/6/15.
 */

public interface ApiServiceManager {
   public static final String Base_URL = "http://180.96.21.224:1518/SaleService/";



    /**
     * 登录
     * @param login
     * @return
     */
    @POST("Login")
    Observable<LoginData> login(
            @Body Login login
    );

    @POST("")
    Observable<BaseData> resetPass(
            @Body ResetPassword data
    );
    @POST("IdentifyingCode")
    Observable<CodeData> getCode(
            @Body String username
    );

}
