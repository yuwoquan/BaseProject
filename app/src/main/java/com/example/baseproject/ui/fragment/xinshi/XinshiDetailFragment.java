package com.example.baseproject.ui.fragment.xinshi;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
import com.example.baseproject.eventbus.MessageEvent;
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
    private AppBarStatee mState;
    private Bundle bundle;
    private XinshiBean xinshiBean=new XinshiBean();
    private MovieClassifyAdapter movieClassifyAdapter;
    private static final String TAG = "XinshiDetailFragment";
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
        initAppBar();
        return view;
    }

    /**
     * 监听topbar
     */
    private enum AppBarStatee {
        EXPANDED, COLLAPSED, MIDDLE
    }
    private void initAppBar() {
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (mState != AppBarStatee.EXPANDED) {
                        //修改状态标记为展开
                        mState = AppBarStatee.EXPANDED;
                        collapsingTopbarLayout.setTitle("");
                       topbar.setTitle("");
                        Log.e(TAG, "onOffsetChanged: " );
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (mState != AppBarStatee.COLLAPSED) {
                        //修改状态标记为折叠
                        mState = AppBarStatee.COLLAPSED;
                        topbar.setTitle(xinshiBean.getName());
                        Log.e(TAG, "onOffsetChanged: " );
                    }
                } else {
                    if (mState != AppBarStatee.MIDDLE) {
                        if (mState == AppBarStatee.COLLAPSED) {
                            collapsingTopbarLayout.setTitle("");
                        }
                        topbar.setTitle("");
                        //修改状态标记为中间
                        mState = AppBarStatee.MIDDLE;
                        Log.e(TAG, "onOffsetChanged: ");
                    }
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
