package com.anytime.zerosupplier.net.interceptor;

import com.anytime.zerosupplier.present.BasePersenter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dream on 2017/6/16.
 * 设置拦截器。添加请求头
 */

public class BaseInterceptor implements Interceptor{
    private Map<String,String> headers;

    public BaseInterceptor(Map<String,String> headers){
        this.headers = headers;
    }



    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        if(headers != null && headers.size() > 0){
            Set<String> keys = headers.keySet();
            for (String headerkey:
                 keys) {
                builder.addHeader(headerkey,headers.get(headerkey)).build();
            }
        }
        return chain.proceed(builder.build());
    }
}
