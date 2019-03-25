package com.example.baseproject.ui.fragment.dianjingbao;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.ui.fragment.RecommendFragment;
import com.example.baseproject.ui.fragment.TestFragment;
import com.example.baseproject.ui.fragment.WorryFragment;
import com.example.baseproject.utils.weight.NoScrollViewPager;
import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.arch.QMUIFragmentPagerAdapter;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DianJingBaseFragment extends BaseFragment {

    @BindView(R.id.pager) NoScrollViewPager mViewPager;
    @BindView(R.id.tabs) QMUITabSegment mTabSegment;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dian_jing_base, null);
        ButterKnife.bind(this, view);
        initTabs();
        initPagers();
        return view;
    }
    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(getActivity(), R.attr.qmui_config_color_gray_6);
//        int selectColor = QMUIResHelper.getAttrColor(getActivity(), R.attr.app_color_blue);
        mTabSegment.setDefaultNormalColor(normalColor);
//        mTabSegment.setDefaultSelectedColor(selectColor);
        //选中时文字颜色
        mTabSegment.setDefaultSelectedColor(ContextCompat.getColor(getActivity(), R.color.app_color_blue));
        mTabSegment.setHasIndicator(false);
        QMUITabSegment.Tab light = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.kaihei),
                ContextCompat.getDrawable(getContext(), R.mipmap.kaiheiselect),
                "匹配", false
        );
        QMUITabSegment.Tab music = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.pipei),
                ContextCompat.getDrawable(getContext(), R.mipmap.pipeiselect),
                "开黑", false
        );
        mTabSegment.addTab(light).addTab(music);
        mTabSegment.notifyDataChanged();
    }
    private void initPagers() {
        QMUIFragmentPagerAdapter pagerAdapter = new QMUIFragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public QMUIFragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return new PipeiFragment();
                    case 1:
                    default:
                        return new OpenBlackBaseFragment();
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "light";
                    case 1:
                    default:
                        return "music";
                }
            }
        };
        mViewPager.setAdapter(pagerAdapter);
        mTabSegment.setupWithViewPager(mViewPager,false);
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

}
