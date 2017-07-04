package com.anytime.zerosupplier.ui.view;

/**
 * Created by dream on 2017/6/15.
 */

public interface ILoginView {

    /**
     * 提交登录请求后的逻辑
     */
    void mLoginSubmit();

    /**
     * Toast
     * @param content toast的文字
     */
    void showContent(String content);

    /**
     * 登录时候请求网络的对话框
     * @param content
     */
    void showDialog(String content);

    /**
     * 取消Progress对话框
     */
    void dismissDialog();


}
