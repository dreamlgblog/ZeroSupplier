package com.anytime.zerosupplier.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anytime.zerosupplier.BaseActivty;
import com.anytime.zerosupplier.R;
import com.anytime.zerosupplier.model.AbInterface.IResetPass;
import com.anytime.zerosupplier.present.BasePersenter;
import com.anytime.zerosupplier.present.ResetPassPresent;
import com.anytime.zerosupplier.ui.view.IForgetPasswordView;

/**
 * Created by dream on 2017/6/16.
 */

public class ForgetPassWordActivity extends BaseActivty<IForgetPasswordView,ResetPassPresent<IForgetPasswordView>> implements IForgetPasswordView, View.OnClickListener {

    private TextView text_getyzm;
    private EditText resetpwd_input_phone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        text_getyzm = (TextView) findViewById(R.id.text_getyzm);
        resetpwd_input_phone = (EditText) findViewById(R.id.resetpwd_input_phone);
        text_getyzm.setOnClickListener(this);
    }

    @Override
    protected ResetPassPresent<IForgetPasswordView> createPresent() {
        return new ResetPassPresent<>(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_getyzm:
                mPresent.getCode(resetpwd_input_phone.getText().toString());
                break;
        }
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
