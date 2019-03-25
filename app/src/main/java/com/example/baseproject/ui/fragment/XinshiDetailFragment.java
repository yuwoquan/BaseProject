package com.example.baseproject.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.adapter.MovieClassifyAdapter;
import com.example.baseproject.enity.XinshiBean;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUIAppBarLayout;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;


public class XinshiDetailFragment extends BaseFragment {


    @BindView(R.id.iv_cover_bg) ImageView ivCoverBg;
    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.tv_description) TextView tvDescription;
    @BindView(R.id.topbar) QMUITopBar topbar;
    @BindView(R.id.collapsing_topbar_layout) QMUICollapsingTopBarLayout collapsingTopbarLayout;
    @BindView(R.id.appbar) QMUIAppBarLayout appbar;
    @BindView(R.id.tabs) TabLayout tabs;
    @BindView(R.id.viewpager) ViewPager viewpager;
    private Bundle bundle;
    private XinshiBean xinshiBean=new XinshiBean();
    private MovieClassifyAdapter movieClassifyAdapter;
    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_xinshi_detail, null);
        ButterKnife.bind(this, view);
        bundle=getArguments();
        xinshiBean= (XinshiBean) bundle.getSerializable("all");
//        Glide.with(MyApplication.getContext()).load(xinshiBean.getPhoto()).into(ivCoverBg);
        RequestOptions cropOptions = new RequestOptions()
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(10, 20)));
        Glide.with(MyApplication.getContext())
                .load(xinshiBean.getPhoto())
                .apply(cropOptions)
                .into(ivCoverBg);
        setTopbar(topbar,"");
        tvDescription.setText(xinshiBean.getQianming());
        tvName.setText(xinshiBean.getName());
        movieClassifyAdapter= new MovieClassifyAdapter(getBaseFragmentActivity().getSupportFragmentManager());
        viewpager.setAdapter(movieClassifyAdapter);
        viewpager.setOffscreenPageLimit(2);
        tabs.setupWithViewPager(viewpager);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
