package com.example.baseproject.mvp.ui;

import android.os.Bundle;

import com.example.baseproject.mvp.base.AbstractMvpPersenter;
import com.example.baseproject.mvp.base.IMvpBaseView;


/**
 * @author Ambrose
 * @date 2018/12/12 7:36 PM
 * @desc
 */
public abstract class LMvpFragment <V extends IMvpBaseView, P extends AbstractMvpPersenter<V>> extends LayeFragment implements IMvpBaseView {

    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter =createPresenter();
        try {
            if (presenter == null) {
                presenter = createPresenter();
            }

            if (presenter == null) {
                throw new NullPointerException("presenter 不能为空!");
            }
            //绑定view
            presenter.attachMvpView((V) this);
        } catch (Exception e) {
            new ClassCastException(this.toString() + "实现IPresenterView或者IPresenterView子类接口");
        }
    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            presenter.detachMvpView();
        }

        super.onDestroy();
    }
    public P getPresenter() {
        return presenter;
    }
    //实例化Presenter
    public abstract P createPresenter();
}
