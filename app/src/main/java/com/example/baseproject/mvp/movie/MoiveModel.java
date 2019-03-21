package com.example.baseproject.mvp.movie;

import android.content.Context;

import com.example.baseproject.app.Api;
import com.example.baseproject.app.BaseModel;
import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.MovieDetailBean;
import com.example.baseproject.enity.SmartBean;
import com.example.baseproject.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * @author Ambrose
 * @date 2019/3/21 11:16 AM
 * @desc
 */
public class MoiveModel  extends BaseModel {
    private Call<MovieDetailBean> SmartBeanCall;
    private Call<InTheatersBean> inTheatersBeanCall;
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public MoiveModel (Context mcontext) {
        super();
        context = mcontext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void  getMovie(String id,final IBaseRequestCallBack<MovieDetailBean> iBaseRequestCallBack){
        //获取Observable对象
        mcompositeDisposable.add(api.getMovieSubjectInfo(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MovieDetailBean>() {
                    @Override
                    public void accept(MovieDetailBean smartBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(smartBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }

    public void  getInthe(final IBaseRequestCallBack<InTheatersBean> iBaseRequestCallBack){
        //获取Observable对象
        mcompositeDisposable.add(api.getMovieInTheaters()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<InTheatersBean>() {
                    @Override
                    public void accept(InTheatersBean smartBean) throws Exception {
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
