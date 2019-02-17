package com.example.baseproject.mvp.Smart;

import android.content.Context;


import com.example.baseproject.app.Api;
import com.example.baseproject.app.BaseModel;
import com.example.baseproject.enity.SmartBean;
import com.example.baseproject.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

public class SmartModel extends BaseModel {
    private Call<SmartBean> SmartBeanCall;
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public SmartModel (Context mcontext) {
        super();
        context = mcontext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void  getPhoto(final IBaseRequestCallBack<SmartBean> iBaseRequestCallBack){
        //获取Observable对象

        mcompositeDisposable.add(api.getSmart()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<SmartBean>() {
                    @Override
                    public void accept(SmartBean smartBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(smartBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(SmartBeanCall != null && !SmartBeanCall.isCanceled()){
            SmartBeanCall.cancel();
        }
    }
}
