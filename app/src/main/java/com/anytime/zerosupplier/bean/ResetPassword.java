package com.anytime.zerosupplier.bean;

/**
 * Created by dream on 2017/6/16.
 */

public class ResetPassword {
    String username;
    String password;
    String msgCode;
    String confirmpassword;

    public ResetPassword(String username, String password, String msgCode, String confirmpassword) {
        this.username = username;
        this.password = password;
        this.msgCode = msgCode;
        this.confirmpassword = confirmpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
