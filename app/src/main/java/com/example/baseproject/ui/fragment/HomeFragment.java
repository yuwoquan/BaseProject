package com.example.baseproject.ui.fragment;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;

import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.ui.fragment.xinshi.WorryFragment;
import com.example.baseproject.utils.weight.NoScrollViewPager;
import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.arch.QMUIFragmentPagerAdapter;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends BaseFragment {




    @BindView(R.id.pager) NoScrollViewPager mViewPager;
    @BindView(R.id.tabs) QMUITabSegment mTabSegment;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
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
                ContextCompat.getDrawable(getContext(), R.mipmap.e),
                ContextCompat.getDrawable(getContext(), R.mipmap.f),
                "心事圈", false
        );
        QMUITabSegment.Tab music = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.a),
                ContextCompat.getDrawable(getContext(), R.mipmap.d),
                "测试", false
        );
        QMUITabSegment.Tab setting = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.c),
                ContextCompat.getDrawable(getContext(), R.mipmap.b),
                "推荐", false
        );
        mTabSegment.addTab(light).addTab(music).addTab(setting);
        mTabSegment.notifyDataChanged();
    }
    private void initPagers() {
        QMUIFragmentPagerAdapter pagerAdapter = new QMUIFragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public QMUIFragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return new WorryFragment();
                    case 1:
                        return new TestFragment();
                    case 2:
                    default:
                        return new RecommendFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "light";
                    case 1:
                        return "music";
                    case 2:
                    default:
                        return "setting";
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
