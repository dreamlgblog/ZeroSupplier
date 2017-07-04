package com.anytime.zerosupplier.model.AbInterface;

import com.anytime.zerosupplier.bean.LoginData;

/**
 * Created by dream on 2017/6/16.
 */

public interface IResetPass {

    void submit(OnRestSumit onRestSumit);
    void getCode(String username,OnRestSumit onRestSumit);
    void unRequst();

    interface OnRestSumit{
        void onSuccess(Object body);
        void onErrer(String content);
    }
}
