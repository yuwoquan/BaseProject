package com.example.baseproject.mvp.worry;

import com.example.baseproject.MyApplication;
import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.MovieDetailBean;
import com.example.baseproject.enity.WorryBean;
import com.example.baseproject.mvp.base.AbstractMvpPersenter;
import com.example.baseproject.mvp.base.IBaseRequestCallBack;
import com.example.baseproject.mvp.movie.MoiveModel;
import com.example.baseproject.mvp.movie.MovieView;

/**
 * @author Ambrose
 * @date 2019/3/21 3:34 PM
 * @desc
 */
public class WorryPresenter extends AbstractMvpPersenter<WorryView> {
    private WorryModel moiveModel;

    public WorryPresenter() {
        moiveModel = new WorryModel(MyApplication.getContext());
    }



    public void clickWorry() {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        moiveModel.getInthe(new IBaseRequestCallBack<WorryBean>() {
            @Override
            public void requestError(Throwable throwable) {
                if (getmMvpView() != null) {
                    getmMvpView().resultFailure(String.valueOf(throwable));
                }
            }

            @Override
            public void requestSuccess(WorryBean smartBean) {
                if (getmMvpView() != null) {
                    getmMvpView().successgetWorry(smartBean);
                }
            }
        });
    }

    public void interrupMovieHttp() {
        moiveModel.interruptHttp();
    }
}
