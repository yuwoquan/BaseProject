package com.example.baseproject.mvp.Smart;


import com.example.baseproject.enity.SmartBean;
import com.example.baseproject.mvp.base.IMvpBaseView;

public interface SmartView extends IMvpBaseView {

    void successgetSmart(SmartBean smartBean);

    void resultFailure(String result);

    void requestLoading();
}
