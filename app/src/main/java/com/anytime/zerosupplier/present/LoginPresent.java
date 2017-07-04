package com.anytime.zerosupplier.present;

import android.text.TextUtils;

import com.anytime.zerosupplier.bean.Login;
import com.anytime.zerosupplier.bean.LoginData;
import com.anytime.zerosupplier.model.AbInterface.ILoginModel;
import com.anytime.zerosupplier.model.LoginModel;
import com.anytime.zerosupplier.present.AbInterface.ILoginPresent;
import com.anytime.zerosupplier.ui.view.ILoginView;

/**
 * Created by dream on 2017/6/15.
 */

public class LoginPresent<T> extends BasePersenter<ILoginView> implements ILoginPresent {

    ILoginView mLoginView;
    ILoginModel mLoginModel;
    public LoginPresent(ILoginView mLoginView){
        this.mLoginView = mLoginView;
    }

    public void mSubmit(String username, String password) {
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            mLoginView.showContent("用户名或密码不能为空！");
            return;
        }
        mLoginModel = new LoginModel(new Login(username, password));
        mLoginView.showDialog("登录中。。");
        if(mLoginModel != null){
            mLoginModel.submit(new ILoginModel.OnLoginSumit() {
                @Override
                public void onSuccess(LoginData data) {

                    mLoginView.mLoginSubmit();

                    mLoginView.dismissDialog();
                }

                @Override
                public void onErrer(String content) {
                    mLoginView.showContent(content);
                    mLoginView.dismissDialog();
                }
            });
        }
    }

    @Override
    public void mForgetPassWord() {

    }


    @Override
    public void unSubjectRequst() {
        mLoginModel.unRequst();
    }
}
