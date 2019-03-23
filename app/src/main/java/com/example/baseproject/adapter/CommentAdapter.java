package com.example.baseproject.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.db.CommentBean;

import java.util.List;

/**
 * @author Ambrose
 * @date 2019/1/28 5:24 PM
 * @desc
 */
public class CommentAdapter extends BaseQuickAdapter<CommentBean, BaseViewHolder> {

    private float mShadowAlpha = 0.75f;
    private int mShadowElevationDp = 25;
    private int mRadius;

    public CommentAdapter(@Nullable List<CommentBean> data) {
        super(R.layout.comment_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentBean item) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.cover_default)
                .error(R.drawable.cover_default)
                .dontAnimate()
                .centerCrop();
        helper.setText(R.id.name, item.getName())
                .addOnClickListener(R.id.zan)
                .setText(R.id.comment, String.valueOf(item.getCommentnum()))
                .setText(R.id.msg, "\u3000"+item.getMsg())
                .setText(R.id.zan, String.valueOf(item.getZannum()))
                .setText(R.id.school, item.getSchool());
        if (TextUtils.isEmpty(item.getName())){
            RelativeLayout relativeLayout=helper.getView(R.id.rel);
            relativeLayout.setVisibility(View.GONE);
            ViewGroup.LayoutParams params= relativeLayout.getLayoutParams();
            params.height =0;
            relativeLayout.setLayoutParams(params);
        }
        Glide.with(MyApplication.getContext())
                .load(item.getPhoto())
                .apply(options)
                .into((ImageView) helper.getView(R.id.headimg));
    }
}