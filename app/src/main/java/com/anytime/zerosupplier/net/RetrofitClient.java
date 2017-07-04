package com.anytime.zerosupplier.net;

import android.text.TextUtils;

import com.anytime.zerosupplier.bean.Login;
import com.anytime.zerosupplier.net.interceptor.BaseInterceptor;
import com.anytime.zerosupplier.net.service.ApiServiceManager;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dream on 2017/6/15.
 */

public class RetrofitClient  {
    private static final int DEFAULT_TIMEOUT = 5;
    private OkHttpClient okHttpClient;
    public static String baseUrl = ApiServiceManager.Base_URL;
    private ApiServiceManager serviceManager;

    /**
     * 默认的请求方式，地址为ApiServiceManager.Base_URL
     * 请求头是Content-type","application/json
     */
    public RetrofitClient(){
        this(null);
    }

    /**
     *   设置请求的地址
     * @param url
     */
    public  RetrofitClient(String url){
        this(url,null);

    }

    /**
     * 设置请求地址，和请求头
     * @param url
     * @param map
     */
    public RetrofitClient(String url,Map<String,String> map){
        if(TextUtils.isEmpty(url)){
            url = baseUrl;
        }
        if(map == null){
            map = new HashMap<>();
            map.put("Content-type","application/json");
        }

        //new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
        OkHttpClient okHttp = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new BaseInterceptor(map))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        //onLogin(onLoginSumit);
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttp)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();

        serviceManager = retrofit.create(ApiServiceManager.class);
    }




    public  ApiServiceManager getService(){
        return serviceManager;
    }

}
