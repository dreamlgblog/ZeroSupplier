package com.anytime.zerosupplier.present;

import android.text.TextUtils;

import com.anytime.zerosupplier.bean.CodeData;
import com.anytime.zerosupplier.bean.LoginData;
import com.anytime.zerosupplier.model.AbInterface.IResetPass;
import com.anytime.zerosupplier.model.ResetPassModel;
import com.anytime.zerosupplier.present.AbInterface.IForgetPassword;
import com.anytime.zerosupplier.present.AbInterface.ILoginPresent;
import com.anytime.zerosupplier.ui.view.IForgetPasswordView;

/**
 * Created by dream on 2017/6/16.
 */

public class ResetPassPresent<T> extends BasePersenter<IForgetPasswordView> implements IForgetPassword {

    private IForgetPasswordView view;
    private ResetPassModel  model = new ResetPassModel();
    public ResetPassPresent(IForgetPasswordView view){
        this.view = view;
    }

    @Override
    public void getCode(String username) {
        if(TextUtils.isEmpty(username)){
            view.showToast("请输入用户名");
            return;
        }

        if(model != null){
            model.getCode(username, new IResetPass.OnRestSumit() {
                @Override
                public void onSuccess(Object body) {
                    view.showToast(((CodeData)body).getMessage());
                }

                @Override
                public void onErrer(String content) {

                }
            });
        }
    }

    @Override
    public void getConfirm(String username, String msgCode, String password, String confirmpassword) {

    }

    @Override
    public void unSubjectRequst() {

    }
}
