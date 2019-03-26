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

import java.util.List;

/**
 * @author Ambrose
 * @date 2019/3/26 11:14 AM
 * @desc
 */
public class MoreAdapter extends BaseQuickAdapter<XinshiBean, BaseViewHolder> {
    public MoreAdapter( @Nullable List<XinshiBean> data) {
        super(R.layout.more_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, XinshiBean item) {
        Glide.with(MyApplication.getContext())
                .load(item.getPhoto())
                .into((ImageView) helper.getView(R.id.image));
        helper.setText(R.id.type,"#"+item.getName()+"#")
                .setText(R.id.msg,item.getQianming())
                .setText(R.id.yuedu,"阅读："+String.valueOf(item.getHot()));
    }
}
