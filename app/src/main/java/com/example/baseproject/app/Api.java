package com.example.baseproject.app;

import com.example.baseproject.enity.SmartBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 鱼握拳 on 2018/5/24.
 */

public interface Api {


    @GET("host/?type=recommend&xtype=0&pageno=1&pagenum=300&_=1547602304603&__plat=pc_web&__version=2.11.8")
    Observable<SmartBean> getSmart();


}
