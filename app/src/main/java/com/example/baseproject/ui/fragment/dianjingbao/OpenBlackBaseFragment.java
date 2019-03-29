package com.example.baseproject.ui.fragment.dianjingbao;

import android.view.LayoutInflater;
import android.view.View;

import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.ui.fragment.ApplyFragment;
import com.example.baseproject.ui.fragment.NearbyFragment;
import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.arch.QMUIFragmentPagerAdapter;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OpenBlackBaseFragment extends BaseFragment {


    @BindView(R.id.pager) QMUIViewPager mViewPager;
    @BindView(R.id.tabs) QMUITabSegment mTabSegment;
    @BindView(R.id.mtopbar) QMUITopBar mtopbar;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_open_black_base, null);
        ButterKnife.bind(this, view);
        mtopbar.setTitle("电竞宝");
        initPagers();

        return view;
    }

    private void initPagers() {

        QMUIFragmentPagerAdapter pagerAdapter = new QMUIFragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public QMUIFragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return new ApplyFragment();
//                        return new BaoMingFragment();
                    case 1:
                        return new MyReleaseFragment();
                    case 2:
                    default:
                        return new NearbyFragment();
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
                        return "报名";
                    case 1:
                        return "我的发布";
                    case 2:
                    default:
                        return "附近网吧";
                }
            }
        };
        mViewPager.setAdapter(pagerAdapter);
        mTabSegment.setupWithViewPager(mViewPager);
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

}
