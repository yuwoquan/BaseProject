package com.example.baseproject.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.adapter.XinshiAdapter;
import com.example.baseproject.enity.XinshiBean;
import com.example.baseproject.eventbus.MessageEvent;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.ui.fragment.dianjingbao.BaoMingFragment;
import com.example.baseproject.ui.fragment.dianjingbao.MyReleaseFragment;
import com.example.baseproject.ui.fragment.dianjingbao.NearByClubFragment;
import com.example.baseproject.utils.weight.XCollapsingToolbarLayout;
import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.arch.QMUIFragmentPagerAdapter;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class XinshiFragment extends BaseFragment {

    @BindView(R.id.ctl_test_bar) XCollapsingToolbarLayout ctlTestBar;
    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    @BindView(R.id.pager) QMUIViewPager mViewPager;
    @BindView(R.id.tabs) QMUITabSegment mTabSegment;
    @BindView(R.id.btn) FloatingActionButton floatingActionButton;
    private List<XinshiBean> xinshiBeans;
    private static final String TAG = "XinshiFragment";
    private LinearLayoutManager linearLayoutManager;
    private XinshiAdapter xinshiAdapter;
    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_xinshi, null);
        ButterKnife.bind(this, view);
        ctlTestBar.setOnScrimsListener(new XCollapsingToolbarLayout.OnScrimsListener() {
            @Override
            public void onScrimsStateChange(boolean shown) {
                Log.e(TAG, "onScrimsStateChange: " + shown);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new PostFragment());
            }
        });
        linearLayoutManager =new LinearLayoutManager(MyApplication.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(linearLayoutManager);

        xinshiBeans = new ArrayList<>();
        xinshiBeans.add(new XinshiBean("缓解抑郁", "只要不放弃，就永远有希望在", "huanjie.json", R.drawable.huanjieyuyi, "huanjienew.json",1224));
        xinshiBeans.add(new XinshiBean("婚恋挽回", "爱若如水，就别让爱覆水难收", "hunlianwanhui.json", R.drawable.huanlianwanhui, "hunlianwanhuinew.json",8575));
        xinshiBeans.add(new XinshiBean("减轻焦虑", "克服焦虑，才能做生活的主人", "jianlue.json", R.drawable.jianqingjiaolue, "jianluenew.json",6636));
        xinshiBeans.add(new XinshiBean("脱离性瘾", "凡事需有度，成瘾就不好了", "jiantuoxingyin.json", R.drawable.tuolixingyin, "jiantuoxingyinnew.json",2345));
        xinshiBeans.add(new XinshiBean("改变自卑", "自卑的同时必然伴随着超越的力量", "gaibianzibei.json", R.drawable.gaibianzibei, "gaibianzibeinew.json",4255));
        xinshiBeans.add(new XinshiBean("脱单攻略", "单身可以是一种选择，但不是被迫选择", "tuodangonglue.json", R.drawable.tuodangonglue, "tuodangongluenew.json",6554));
        xinshiBeans.add(new XinshiBean("同性恋", "真爱的世界不分性别", "tongxinglian.json", R.drawable.tongxinglian, "tongxingliannew.json",5535));
        xinshiBeans.add(new XinshiBean("争吵分析", "争吵是分歧，也是提升关系的机遇", "zhengcaofenxi.json", R.drawable.zhengchaofenxi, "zhengcaofenxinew.json",4635));
        xinshiBeans.add(new XinshiBean("婆媳关系", "念好这本难念的经，是一种处世智慧", "poxiguanxi.json", R.drawable.poxiguanxi, "poxiguanxinew.json",2689));
        xinshiBeans.add(new XinshiBean("问题小孩", "被视为有问题的小孩可能有巨大的潜能", "wentixiaohai.json", R.drawable.wentixiaohai, "wentixiaohainew.json",9743));
        xinshiBeans.add(new XinshiBean("父母冲突", "每一个成长中的我们都绕不开父母的关心", "fuwuchongtu.json", R.drawable.fumuchongtu, "fuwuchongtunew.json",5432));
        xinshiBeans.add(new XinshiBean("胜退小三", "在爱情的争夺中，掌握充分的主动权", "shengtuixiaosan.json", R.drawable.shengtuixiaosan, "fuwuchongtunew.json",6432));

        xinshiAdapter=new XinshiAdapter(xinshiBeans);
        recyclerview.setAdapter(xinshiAdapter);

        xinshiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                first=xinshiAdapter.getData().get(position).getJingxuan();
                two=xinshiAdapter.getData().get(position).getNewxuan();
//                EventBus.getDefault().register(this);
                EventBus.getDefault().postSticky(new MessageEvent(first,two));
                Log.e(TAG, "onItemClick: "+first+two );
                bundle.putSerializable("all",xinshiAdapter.getData().get(position));
                XinshiDetailFragment xinshiDetailFragment=new XinshiDetailFragment();
                xinshiDetailFragment.setArguments(bundle);
                startFragment(xinshiDetailFragment);
            }
        });

        mTabSegment.setMode(QMUITabSegment.MODE_SCROLLABLE);

        initPagers();
        return view;
    }
    private void initPagers() {

        QMUIFragmentPagerAdapter pagerAdapter = new QMUIFragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public QMUIFragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return new BaoMingFragment();
                    case 1:
                        return new MyReleaseFragment();
                    case 2:
                    default:
                        return new NearByClubFragment();
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
    public void onDestroyView() {
        super.onDestroyView();
    }
}
