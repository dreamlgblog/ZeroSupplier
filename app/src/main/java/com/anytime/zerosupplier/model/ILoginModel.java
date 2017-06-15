package com.anytime.zerosupplier.model;

import com.anytime.zerosupplier.bean.LoginData;

/**
 * Created by dream on 2017/6/15.
 */

public interface ILoginModel {

    void submit(OnLoginSumit onLoginSumit);
    interface OnLoginSumit{
        void onSuccess(LoginData body);
        void onErrer(String content);
    }
}
