package com.anytime.zerosupplier.present;

import com.anytime.zerosupplier.bean.LoginData;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by dream on 2017/6/15.
 * T  对应着Activity 的UI抽象接口  视图
 */

public abstract class BasePersenter<T> {
    /**
     * 持有UI接口的弱引用
     */
    protected WeakReference<T> mViewRef;


    /**
     * 取消请求
     */
    public abstract void unSubjectRequst();

    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    /**
     * 解绑
     */
    public void detach()
    {
        if(mViewRef!=null)
        {
            mViewRef.clear();
            unSubjectRequst();
            mViewRef=null;
        }
    }
}
