package com.example.baseproject.ui.fragment.dianjingbao;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.baseproject.R;
import com.example.baseproject.adapter.NearByClubAdapter;
import com.example.baseproject.enity.ClubBean;
import com.example.baseproject.mvp.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NearByClubFragment extends BaseFragment {


    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    private List<ClubBean> clubBeans;
    private NearByClubAdapter nearByClubAdapter;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_near_by_club, null);
        ButterKnife.bind(this, view);
        init();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        nearByClubAdapter=new NearByClubAdapter(clubBeans);
        recyclerview.setAdapter(nearByClubAdapter);
        return view;
    }

    private void init() {
        clubBeans=new ArrayList<>();
        clubBeans.add(new ClubBean(R.mipmap.club,5,"雷霆网咖","休闲娱乐","网咖","南山区"));
        clubBeans.add(new ClubBean(R.mipmap.clubone,5,"魔戒电竞","吃喝玩乐","网咖","南山区"));
        clubBeans.add(new ClubBean(R.mipmap.clubtwo,5,"超神网咖","休闲娱乐","网咖","南山区"));
        clubBeans.add(new ClubBean(R.mipmap.clubthree,5,"冲击网咖","休闲娱乐","网咖","南山区"));
        clubBeans.add(new ClubBean(R.mipmap.clubfour,5,"无敌网咖","休闲娱乐","网咖","南山区"));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
