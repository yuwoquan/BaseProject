package com.example.baseproject.utils.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.zhouwei.mzbanner.holder.MZViewHolder;

/**
 * @author Ambrose
 * @date 2019/3/21 3:00 PM
 * @desc
 */
public class BannerViewHolder implements MZViewHolder<String> {
    private ImageView mImageView;
    @Override
    public View createView(Context context) {
        // 返回页面布局
        View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
        mImageView = (ImageView) view.findViewById(R.id.banner_image);
        return view;
    }

    @Override
    public void onBind(Context context, int position, String data) {
        // 数据绑定
//        mImageView.setImageResource(data);
        Glide.with(MyApplication.getContext()).load(data).into(mImageView);
    }
}
