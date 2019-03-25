package com.example.baseproject.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.enity.BoardBean;
import com.example.baseproject.enity.ClubBean;

import java.util.List;

/**
 * @author Ambrose
 * @date 2019/3/25 1:56 PM
 * @desc
 */
public class NearByClubAdapter extends BaseQuickAdapter<ClubBean, BaseViewHolder> {
    public NearByClubAdapter(@Nullable List<ClubBean> data) {
        super(R.layout.club_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClubBean item) {
        helper.setText(R.id.name,item.getClubname())
                .setText(R.id.type,item.getType()+"\u3000\u3000"+item.getWangba())
                .setText(R.id.address,item.getAddress());
        Glide.with(MyApplication.getContext()).load(item.getPhoto()).into((ImageView) helper.getView(R.id.image));
    }
}
