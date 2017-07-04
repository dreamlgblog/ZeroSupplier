package com.anytime.zerosupplier.model.AbInterface;

import com.anytime.zerosupplier.bean.LoginData;

import java.lang.annotation.Target;

/**
 * Created by dream on 2017/6/15.
 */

public interface ILoginModel {

    void submit(OnLoginSumit onLoginSumit);

    void unRequst();

    interface OnLoginSumit{
        void onSuccess(LoginData body);
        void onErrer(String content);
    }
}
