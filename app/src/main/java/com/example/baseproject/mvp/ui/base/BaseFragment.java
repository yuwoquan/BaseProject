package com.example.baseproject.mvp.ui.base;

import android.view.View;

import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

/**
 * Created by 鱼握拳 on 2018/4/28.
 */

public abstract class BaseFragment extends QMUIFragment {

    public boolean isLocalCHange=false;
    public String first,two;
    public BaseFragment() {
    }


    /**
     * 侧滑退出的偏移
     * @return
     */
    @Override
    protected int backViewInitOffset() {
        return QMUIDisplayHelper.dp2px(getContext(), 150);
    }

    /**
     * 设置qmuiTopbar的左侧退出按钮跟title
     * @param qmuiTopBar
     * @param title
     */
    public void  setTopbar(QMUITopBar qmuiTopBar, String title){
        qmuiTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        qmuiTopBar.setBackgroundDividerEnabled(false);
        qmuiTopBar.setTitle(title);
    }

    /**
     * 用于第一次进来app的检测
     */
    @Override
    public void onResume() {
        super.onResume();
//        QDUpgradeManager.getInstance(getContext()).runUpgradeTipTaskIfExist(getActivity());
    }
}
