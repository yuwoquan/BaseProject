package com.example.baseproject.mvp.movie;

import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.MovieDetailBean;
import com.example.baseproject.enity.SmartBean;
import com.example.baseproject.mvp.base.IMvpBaseView;

/**
 * @author Ambrose
 * @date 2019/3/21 11:15 AM
 * @desc
 */
public interface MovieView extends IMvpBaseView {

    void successgetIntheat(InTheatersBean inTheatersBean);

    void successgetMovieDetai(MovieDetailBean movieDetailBean);

    void resultFailure(String result);

    void requestLoading();

}
