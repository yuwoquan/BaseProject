package com.example.baseproject.mvp.movie;

import com.example.baseproject.MyApplication;
import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.MovieDetailBean;
import com.example.baseproject.enity.SmartBean;
import com.example.baseproject.mvp.Smart.SmartModel;
import com.example.baseproject.mvp.Smart.SmartView;
import com.example.baseproject.mvp.base.AbstractMvpPersenter;
import com.example.baseproject.mvp.base.IBaseRequestCallBack;

/**
 * @author Ambrose
 * @date 2019/3/21 11:16 AM
 * @desc
 */
public class MoviePresenter extends AbstractMvpPersenter<MovieView> {
    private MoiveModel moiveModel;

    public MoviePresenter() {
        moiveModel = new MoiveModel(MyApplication.getContext());
    }
    public void clickLoadMovie(String id ){
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        moiveModel.getMovie(id,new IBaseRequestCallBack<MovieDetailBean>() {
            @Override
            public void requestError(Throwable throwable) {
                if (getmMvpView() != null) {
                    getmMvpView().resultFailure(String.valueOf(throwable));
                }
            }

            @Override
            public void requestSuccess(MovieDetailBean smartBean) {
                if (getmMvpView() != null) {
                    getmMvpView().successgetMovieDetai(smartBean);
                }
            }
        });
    }

    public void clickInthe(){
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        moiveModel.getInthe(new IBaseRequestCallBack<InTheatersBean>() {
            @Override
            public void requestError(Throwable throwable) {
                if (getmMvpView() != null) {
                    getmMvpView().resultFailure(String.valueOf(throwable));
                }
            }

            @Override
            public void requestSuccess(InTheatersBean smartBean) {
                if (getmMvpView() != null) {
                    getmMvpView().successgetIntheat(smartBean);
                }
            }
        });
    }

    public void  interrupMovieHttp(){
        moiveModel.interruptHttp();
    }
}
