package com.anytime.zerosupplier.ui.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.anytime.zerosupplier.BaseActivty;
import com.anytime.zerosupplier.R;
import com.anytime.zerosupplier.present.LoginPresent;
import com.anytime.zerosupplier.ui.view.ILoginView;
import com.anytime.zerosupplier.utils.SettingUtils;

/**
 * Created by dream on 2017/6/15.
 */

public class LoginActivity extends BaseActivty<ILoginView,LoginPresent<ILoginView>> implements  ILoginView{
    private EditText login_phone,login_pwd;
    ProgressDialog mProgress;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_phone = (EditText) findViewById(R.id.login_phone);
        login_pwd = (EditText) findViewById(R.id.login_pwd);

    }

    @Override
    protected LoginPresent<ILoginView> createPresent() {
        return new LoginPresent<>(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestPermission(1, Manifest.permission.CALL_PHONE, new Runnable() {
            @Override
            public void run() {
                callPhone();
            }
        }, new Runnable() {
            @Override
            public void run() {
                callPhoneDenied();
            }
        });
    }

    /**
     * 每次进来都要执行一次
     */
    private void callPhone() {
        Toast.makeText(this, "CALL_PHONE OK", Toast.LENGTH_SHORT)
                .show();
    }

    private void callPhoneDenied() {
        Toast.makeText(this, "打开设置", Toast.LENGTH_SHORT)
                .show();
        //如果没有给权限则跳转到设置页面
        SettingUtils.showInstalledAppDetails(this,getPackageName());
    }


    public void submit(View view){
        mPresent.mSubmit(login_phone.getText().toString(),login_pwd.getText().toString());
    }





    @Override
    public void mLoginSubmit() {
        Toast.makeText(this, "跳转到下个界面", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showContent(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog(String content) {
        if(mProgress == null){
            mProgress = new ProgressDialog(this);
            mProgress.setMessage(content);
            mProgress.show();
        }else{
            mProgress.setMessage(content);
            mProgress.show();
        }

    }

    @Override
    public void dismissDialog() {
        if(mProgress != null){
            mProgress.dismiss();
        }

    }
}
