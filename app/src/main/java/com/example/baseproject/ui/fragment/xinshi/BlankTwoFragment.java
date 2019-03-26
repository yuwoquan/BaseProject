package com.example.baseproject.ui.fragment.xinshi;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.baseproject.R;
import com.example.baseproject.adapter.WorryAdapter;
import com.example.baseproject.enity.WorryBean;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BlankTwoFragment extends BaseFragment {

    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    private List<WorryBean.ListBean> worryBeans=new ArrayList<>();
    private WorryAdapter worryAdapter;
    private WorryBean worryBean;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank_two, null);
        ButterKnife.bind(this, view);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        getJson("listnew.json");
        for (int i = 0;  i <worryBean.getList().size() ; i++) {
            worryBeans.add(worryBean.getList().get(i));
        }
        worryAdapter=new WorryAdapter(worryBeans);
        recyclerview.setAdapter(worryAdapter);
        worryAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putString("title",worryAdapter.getData().get(position).getQuestionTitle());
                bundle.putString("type",worryAdapter.getData().get(position).getQuestionCat());
                bundle.putString("msg",worryAdapter.getData().get(position).getQuestionDes());
                XSItemDetailFragment xsItemDetailFragment=new XSItemDetailFragment();
                xsItemDetailFragment.setArguments(bundle);
                startFragment(xsItemDetailFragment);
            }
        });
        return view;
    }

    private WorryBean getJson(String name) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = getActivity().getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(name)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        worryBean = new Gson().fromJson(stringBuilder.toString(), WorryBean.class);
        return worryBean;
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }
}
