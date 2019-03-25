package com.example.baseproject.ui.fragment;

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

import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.adapter.WorryAdapter;
import com.example.baseproject.enity.WorryBean;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.google.gson.Gson;
import com.qmuiteam.qmui.widget.QMUIEmptyView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WorryOnFragment extends BaseFragment {

    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    private int part;
    public static final String PATH = "args_page";
    private static Bundle args;
    private static final String TAG = "WorryOnFragment";
    private List<WorryBean.ListBean> worryBeans=new ArrayList<>();
    private WorryAdapter worryAdapter;
    private WorryBean worryBean;
    private int pos=1;
    public static WorryOnFragment newInstance(int position) {
        args = new Bundle();
        args.putInt(PATH, position);
        WorryOnFragment fragment = new WorryOnFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_worry_on,null);
        ButterKnife.bind(this, view);
        Log.e(TAG, "onCreateView: " );
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        part = getArguments().getInt(PATH);
        Log.e(TAG, "onCreateView: "+part );
        switch (part){
            case 0:
                Log.e(TAG, "onCreateView: "+two );
                getJson(two);
                break;
            case 1:
                Log.e(TAG, "onCreateView: "+first );
                getJson(first);
                break;
                default:
                    break;
        }
        for (int i = 0; i <worryBean.getList().size() ; i++) {
            worryBeans.add(worryBean.getList().get(i));
        }
        worryAdapter=new WorryAdapter(worryBeans);
        recyclerview.setAdapter(worryAdapter);
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
}
