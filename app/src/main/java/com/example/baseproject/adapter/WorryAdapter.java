package com.example.baseproject.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.baseproject.R;
import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.WorryBean;

import java.util.List;

/**
 * @author Ambrose
 * @date 2019/3/21 3:30 PM
 * @desc
 */
public class WorryAdapter extends BaseQuickAdapter<WorryBean.ListBean, BaseViewHolder> {

    public WorryAdapter(@Nullable List<WorryBean.ListBean> data) {
        super(R.layout.worry_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WorryBean.ListBean item) {
        helper.setText(R.id.title,item.getQuestionTitle())
                .setText(R.id.msg,item.getQuestionDes())
                .setText(R.id.time,item.getQuestionTimer())
                .setText(R.id.type,"#"+item.getQuestionCat()+"#");
    }
}
