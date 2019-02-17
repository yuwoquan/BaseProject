package com.example.baseproject;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.baseproject.utils.utils.AppContextUtil;
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;




/**
 * Created by 鱼握拳 on 2018/4/18.
 */

public class MyApplication extends Application {

    public static Context applicationContext;
    public static Context getContext() {
        return applicationContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        // 首次安装提示
//        QDUpgradeManager.getInstance(this).check();
        applicationContext = this;
        // 初始化网络工具类
        AppContextUtil.init(this);
        QMUISwipeBackActivityManager.init(this);
        // 初始化Talkngdata
        //TCAgent.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
