package com.example.baseproject.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.enity.BoardBean;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import java.util.List;

/**
 * @author Ambrose
 * @date 2019/1/28 1:18 PM
 * @desc
 */
public class BoardAdapter extends BaseQuickAdapter<BoardBean, BaseViewHolder> {

    private float mShadowAlpha = 0.75f;
    private int mShadowElevationDp = 25;
    private int mRadius;

    public BoardAdapter(@Nullable List<BoardBean> data) {
        super(R.layout.board_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BoardBean item) {
        QMUIFrameLayout mTestLayout=helper.getView(R.id.qmui_layout);
        mRadius= QMUIDisplayHelper.dp2px(MyApplication.getContext(), 12);
        mTestLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(MyApplication.getContext(), mShadowElevationDp),
                mShadowAlpha); RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.cover_default)
                .error(R.drawable.cover_default)
                .dontAnimate()
                .centerCrop();
        helper.setText(R.id.btn, item.getLines()+"人参与")
                .setText(R.id.msg, "\u3000"+item.getMsg());
        Glide.with(MyApplication.getContext())
                .load(item.getPhoto())
                .apply(options)
                .into((ImageView) helper.getView(R.id.image));
    }
}
