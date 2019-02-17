package com.example.baseproject.mvp.ui.base;

import android.view.View;

import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;


/**
 * Created by 鱼握拳 on 2018/4/18.
 */

public abstract class LayFragment extends QMUIFragment {
    public boolean mHaveLoadData; // 表示是否已经请求过数据
    private boolean isInit;
    private boolean isLoad;
    public boolean mLoadDataFinished; // 表示数据是否已经请求完毕
    private View mRootView;
//    // 表示开始加载数据, 但不表示数据加载已经完成
    public abstract void loadDataStart();
//    // 表示找控件完成, 给控件们设置数据不会报空指针了



//    protected abstract View initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        /**
         * 如果还没有加载过数据 && 用户切换到了这个fragment,那就开始加载数据
         */

        if (!mHaveLoadData && isVisibleToUser) {
            loadDataStart();
            mHaveLoadData = true;
        }
    }



    @Override
    protected int backViewInitOffset() {
        return QMUIDisplayHelper.dp2px(getContext(), 100);
    }

//
//    protected void lazyLoadEveryTime() {
//
//    }
//
//    /**
//     * 取消懒加载
//     */
//    protected void stopLoad() {
//
//    }

}
