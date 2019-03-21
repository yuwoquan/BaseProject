package com.example.baseproject.mvp.worry;

import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.MovieDetailBean;
import com.example.baseproject.enity.WorryBean;
import com.example.baseproject.mvp.base.IMvpBaseView;

/**
 * @author Ambrose
 * @date 2019/3/21 3:33 PM
 * @desc
 */
public interface WorryView extends IMvpBaseView {


    void successgetWorry(WorryBean worryBean);

    void resultFailure(String result);

    void requestLoading();
}
