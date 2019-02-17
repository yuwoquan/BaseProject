package com.example.baseproject.mvp.Smart;


import com.example.baseproject.MyApplication;
import com.example.baseproject.enity.SmartBean;
import com.example.baseproject.mvp.base.AbstractMvpPersenter;
import com.example.baseproject.mvp.base.IBaseRequestCallBack;

public class SmartPresenter extends AbstractMvpPersenter<SmartView> {
    private SmartModel smartModel;

    public SmartPresenter() {
        smartModel = new SmartModel(MyApplication.getContext());
    }
    public void clickLoadMovie(){
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        smartModel.getPhoto(new IBaseRequestCallBack<SmartBean>() {
            @Override
            public void requestError(Throwable throwable) {
                if (getmMvpView() != null) {
                    getmMvpView().resultFailure(String.valueOf(throwable));
                }
            }

            @Override
            public void requestSuccess(SmartBean smartBean) {
                if (getmMvpView() != null) {
                    getmMvpView().successgetSmart(smartBean);
                }
            }
        });
    }
    public void  interrupMovieHttp(){
        smartModel.interruptHttp();
    }
}
