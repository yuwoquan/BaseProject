package com.example.baseproject.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.db.ZhuboBean;


import java.util.List;

public class ZhuBoAdapter extends BaseQuickAdapter<ZhuboBean, BaseViewHolder> {

    public ZhuBoAdapter(@Nullable List<ZhuboBean> data) {
        super(R.layout.zhubo_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhuboBean item) {
        helper.setText(R.id.name, item.getName());
        String s=item.getIdd();
        if (s.isEmpty()){
            s="暂无";
        }else {
            s=item.getIdd();
        }
        helper.setText(R.id.desc, "简介："+s);
        Glide.with(MyApplication.getContext()).load(item.getHobby()).into((ImageView) helper.getView(R.id.ci));
    }
}
