package com.example.baseproject.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.enity.BoardBean;
import com.example.baseproject.enity.XinshiBean;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import java.util.List;

/**
 * @author Ambrose
 * @date 2019/3/25 5:53 PM
 * @desc
 */
public class XinshiAdapter  extends BaseQuickAdapter<XinshiBean, BaseViewHolder> {

    private float mShadowAlpha = 0.1f;
    private int mShadowElevationDp = 4;
    private int mRadius;

    public XinshiAdapter(@Nullable List <XinshiBean> data) {
        super(R.layout.xinshi_item,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, XinshiBean item) {
            helper.setText(R.id.name,item.getName())
            .setText(R.id.hot,String.valueOf(item.getHot()));
        Glide.with(MyApplication.getContext()).load(item.getPhoto()).into((ImageView) helper.getView(R.id.ima));
//        mRadius = QMUIDisplayHelper.dp2px(MyApplication.getContext(), 0);
//        QMUILinearLayout qmuiLinearLayout=helper.getView(R.id.qmuilayout);
//        qmuiLinearLayout.setRadiusAndShadow(mRadius,
//                QMUIDisplayHelper.dp2px(MyApplication.getContext(), mShadowElevationDp),
//                mShadowAlpha);
    }
}
