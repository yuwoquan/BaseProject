package com.example.baseproject.mvp.worry;

import android.content.Context;

import com.example.baseproject.app.Api;
import com.example.baseproject.app.BaseModel;
import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.MovieDetailBean;
import com.example.baseproject.enity.WorryBean;
import com.example.baseproject.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * @author Ambrose
 * @date 2019/3/21 3:34 PM
 * @desc
 */
public class WorryModel extends BaseModel {
    private Call<WorryBean> SmartBeanCall;
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public WorryModel (Context mcontext) {
        super();
        context = mcontext;
        api=soulManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }

    public void  getInthe(final IBaseRequestCallBack<WorryBean> iBaseRequestCallBack){
        //获取Observable对象
        mcompositeDisposable.add(api.getWorry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<WorryBean>() {
                    @Override
                    public void accept(WorryBean smartBean) throws Exception {
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
