package com.example.baseproject.app;


import android.widget.RelativeLayout;

import com.example.baseproject.mvp.RetrofitManager;

/**
 * 描述：业务对象的基类
 */
public class BaseModel {
    //retrofit请求数据的管理类
    public RetrofitManager retrofitManager,soulManager;

    public BaseModel() {
        retrofitManager = RetrofitManager.builder(Constans.douban);
        soulManager= RetrofitManager.builder(Constans.soul);
    }
}
