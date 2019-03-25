package com.example.baseproject.ui.fragment;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButtonDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ZhiyinFragment extends BaseFragment {

    @BindView(R.id.tabs) QMUITabSegment mTabSegment;
    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.sex) TextView sex;
    @BindView(R.id.man) QMUIRoundButton man;
    @BindView(R.id.woman) QMUIRoundButton woman;
    @BindView(R.id.xing) TextView xing;
    @BindView(R.id.qiang) QMUIRoundButton qiang;
    @BindView(R.id.ruo) QMUIRoundButton ruo;
    @BindView(R.id.ceyice) QMUIRoundButton ceyice;
    @BindView(R.id.qmui_layout) QMUILinearLayout qmuiLayout;
    private float mShadowAlpha = 0.48f;
    private int mShadowElevationDp = 8;
    private int mRadius=28;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_zhiyin, null);
        ButterKnife.bind(this, view);
        initTabs();
        mtopbar.setTitle("知音");
        qmuiLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(MyApplication.getContext(), mShadowElevationDp),
                mShadowAlpha);
        final QMUIRoundButtonDrawable bgone = (QMUIRoundButtonDrawable) man.getBackground();
        final QMUIRoundButtonDrawable bgtwo = (QMUIRoundButtonDrawable) woman.getBackground();
        final QMUIRoundButtonDrawable bgthree = (QMUIRoundButtonDrawable) qiang.getBackground();
        final QMUIRoundButtonDrawable bgfour = (QMUIRoundButtonDrawable) ruo.getBackground();

        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgone.setColor(Color.parseColor("#3FD0AD"));
                bgtwo.setColor(Color.parseColor("#FFFFFF"));
            }
        });
        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgtwo.setColor(Color.parseColor("#EE85C1"));
                bgone.setColor(Color.parseColor("#FFFFFF"));
            }
        });
        qiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgthree.setColor(Color.parseColor("#31BDF3"));
                bgfour.setColor(Color.parseColor("#FFFFFF"));
            }
        });
        ruo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgfour.setColor(Color.parseColor("#31BDF3"));
                bgthree.setColor(Color.parseColor("#FFFFFF"));
            }
        });
        return view;
    }

    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(getActivity(), R.attr.qmui_config_color_gray_6);
        mTabSegment.setDefaultNormalColor(normalColor);
        mTabSegment.setDefaultSelectedColor(ContextCompat.getColor(getActivity(), R.color.app_color_blue));
        mTabSegment.setHasIndicator(false);
        QMUITabSegment.Tab light = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.e),
                ContextCompat.getDrawable(getContext(), R.mipmap.f),
                "打分", false
        );
        QMUITabSegment.Tab music = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.a),
                ContextCompat.getDrawable(getContext(), R.mipmap.d),
                "扮演", false
        );
        QMUITabSegment.Tab setting = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.c),
                ContextCompat.getDrawable(getContext(), R.mipmap.b),
                "气质", false
        );
        mTabSegment.addTab(light).addTab(music).addTab(setting);
        mTabSegment.notifyDataChanged();
    }

}
