package com.example.baseproject.app;

import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.MovieDetailBean;
import com.example.baseproject.enity.SmartBean;
import com.example.baseproject.enity.WorryBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 鱼握拳 on 2018/5/24.
 */

public interface Api {


    @GET("host/?type=recommend&xtype=0&pageno=1&pagenum=300&_=1547602304603&__plat=pc_web&__version=2.11.8")
    Observable<SmartBean> getSmart();

    @GET("subject/{movieId}")
    Observable<MovieDetailBean> getMovieSubjectInfo(@Path("movieId") String movieId);

    @GET("in_theaters")
    Observable<InTheatersBean> getMovieInTheaters();

    @GET("soul/index.php/Questions/lists")
    Observable<WorryBean> getWorry();

}
