package com.example.baseproject.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.enity.InTheatersBean;

import java.util.List;

/**
 * @author Ambrose
 * @date 2019/3/21 11:27 AM
 * @desc
 */
public class RecommentAdapter extends BaseQuickAdapter<InTheatersBean.SubjectsBean, BaseViewHolder> {

    public RecommentAdapter(@Nullable List<InTheatersBean.SubjectsBean> data) {
            super(R.layout.intheater_item, data);
            }

    @Override
    protected void convert(BaseViewHolder viewHolder, InTheatersBean.SubjectsBean item) {



        List<InTheatersBean.SubjectsBean.DirectorsBean> listAuthor=item.getDirectors();
        for (InTheatersBean.SubjectsBean.DirectorsBean authorName:listAuthor){
            viewHolder.setText(R.id.zuozhe,"导演："+authorName.getName());
        }
        List<InTheatersBean.SubjectsBean.CastsBean> listcast=item.getCasts();
        StringBuffer str = new StringBuffer();
        int i = 1;
        for (InTheatersBean.SubjectsBean.CastsBean subcast:listcast){
            String cast=subcast.getName();
            if(listcast.size()==i){
                str.append(cast);
            }else{
                str.append(cast+"，");
            }
            i++;
        }
        viewHolder.setText(R.id.moviename,"《"+item.getTitle()+"》")
                .setText(R.id.zhuyan,"主演："+str)
                .setText(R.id.time,"上映日期："+item.getYear()+"年")
                .setText(R.id.star,"评分："+String.valueOf(item.getRating().getAverage()));
        Glide.with(MyApplication.getContext())
                .load(item.getImages().getMedium())
                .into((ImageView) viewHolder.getView(R.id.image));
    }
}
