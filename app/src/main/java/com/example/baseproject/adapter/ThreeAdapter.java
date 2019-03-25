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

/**
 * @author Ambrose
 * @date 2019/1/23 12:51 PM
 * @desc
 */
public class ThreeAdapter extends BaseQuickAdapter<ZhuboBean, BaseViewHolder> {

    public ThreeAdapter(@Nullable List<ZhuboBean> data) {
        super(R.layout.fensi_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhuboBean item) {
        helper.setText(R.id.fensi, item.getName()+"粉丝群")
                .addOnClickListener(R.id.cli);;
//        String s=item.getIdd();
//        if (s.isEmpty()){
//            s="暂无";
//        }else {
//            s=item.getIdd();
//        }
//        helper.setText(R.id.desc, "简介："+s);
        Glide.with(MyApplication.getContext()).load(item.getHobby()).into((ImageView) helper.getView(R.id.cimage));
    }
}
