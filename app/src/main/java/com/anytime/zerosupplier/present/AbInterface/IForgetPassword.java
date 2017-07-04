package com.anytime.zerosupplier.present.AbInterface;

/**
 * Created by dream on 2017/6/16.
 */

public interface IForgetPassword {
    void getCode(String username);
    void getConfirm(String username,String msgCode,String password,String confirmpassword);
}
