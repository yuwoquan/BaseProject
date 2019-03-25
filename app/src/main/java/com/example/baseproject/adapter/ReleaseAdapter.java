package com.example.baseproject.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.db.MyReleaseBean;

import java.util.List;

/**
 * @author Ambrose
 * @date 2019/3/25 3:50 PM
 * @desc
 */
public class ReleaseAdapter extends BaseQuickAdapter<MyReleaseBean, BaseViewHolder> {


    public ReleaseAdapter(@Nullable List<MyReleaseBean> data) {
        super(R.layout.intheater_item,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyReleaseBean item) {
        helper.setText(R.id.moviename,"标题:"+item.getTitle())
                .setText(R.id.zhuyan,"活动时间："+item.getTime())
                .setText(R.id.time,"活动地址："+item.getAddress())
                .setText(R.id.star,"人数："+item.getPeople());
        Glide.with(MyApplication.getContext())
                .load(item.getUrl())
                .into((ImageView) helper.getView(R.id.image));
    }
}