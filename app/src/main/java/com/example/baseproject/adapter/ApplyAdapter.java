package com.example.baseproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.baseproject.R;
import com.example.baseproject.enity.ApplyBean;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApplyAdapter extends RecyclerView.Adapter<ApplyAdapter.ViewHolder> {

    private Context context;
    private List<ApplyBean.DataBean.ContextBean> beans = new ArrayList<>();
    private List<Integer> images = new ArrayList<>();
    private List<Integer> image1s = new ArrayList<>();
    private List<Integer> image2s = new ArrayList<>();
    private List<Integer> image3s = new ArrayList<>();
    private int type = 0;
    public void setData(List<ApplyBean.DataBean.ContextBean> beans,int type) {
        this.beans = beans;
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.apply_item, viewGroup, false);
        context = viewGroup.getContext();
        initImage();
        return new ViewHolder(view);
    }

    private void initImage() {
        images.add(R.drawable.wb1);
        images.add(R.drawable.wb2);
        images.add(R.drawable.wb3);
        images.add(R.drawable.wb4);
        images.add(R.drawable.wb5);
        images.add(R.drawable.wb6);
        images.add(R.drawable.wb7);
        image1s.add(R.drawable.wb8);
        image1s.add(R.drawable.wb9);
        image1s.add(R.drawable.wb10);
        image1s.add(R.drawable.wb11);
        image1s.add(R.drawable.wb12);
        image1s.add(R.drawable.wb13);
        image1s.add(R.drawable.wb14);
        image1s.add(R.drawable.wb15);
        image2s.add(R.drawable.wb16);
        image2s.add(R.drawable.wb17);
        image2s.add(R.drawable.wb18);
        image2s.add(R.drawable.wb19);
        image2s.add(R.drawable.wb20);
        image2s.add(R.drawable.wb21);
        image2s.add(R.drawable.wb22);
        image2s.add(R.drawable.wb23);
        image2s.add(R.drawable.wb24);
        image3s.add(R.drawable.wb25);
        image3s.add(R.drawable.wb26);
        image3s.add(R.drawable.wb27);
        image3s.add(R.drawable.wb28);
        image3s.add(R.drawable.wb29);
        image3s.add(R.drawable.wb30);
        image3s.add(R.drawable.wb31);
        image3s.add(R.drawable.wb32);
        image3s.add(R.drawable.wb33);
        image3s.add(R.drawable.wb34);
        image3s.add(R.drawable.wb35);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ApplyBean.DataBean.ContextBean contextBean = beans.get(i);
        switch (type){
            case 0:
                Glide.with(context).load(images.get(i)).into(viewHolder.imageView);
                break;
            case 1:
                Glide.with(context).load(image1s.get(i)).into(viewHolder.imageView);
                break;
            case 2:
                Glide.with(context).load(image2s.get(i)).into(viewHolder.imageView);
                break;
            case 3:
                Glide.with(context).load(image3s.get(i)).into(viewHolder.imageView);
                break;
                default:
                    break;
        }
        viewHolder.applyDate.setText(contextBean.getApple_date());
        viewHolder.applySite.setText(contextBean.getApple_site());
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.apply_date)
        TextView applyDate;
        @BindView(R.id.apply_site)
        TextView applySite;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
