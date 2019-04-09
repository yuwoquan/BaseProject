package com.example.baseproject.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.baseproject.R;
import com.example.baseproject.adapter.ApplyAdapter;
import com.example.baseproject.enity.ApplyBean;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.utils.GetJsonUtil;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ApplyFragment extends BaseFragment {

    private static final String TAG = "ApplyFragment";

    @BindView(R.id.spinner)
    Spinner spinner;
    Unbinder unbinder;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.apply_image)
    ImageView applyImage;

    private ApplyAdapter applyAdapter;



    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_apply, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        String[] games = {"华语局","外语局","全语种"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, games);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        applyAdapter = new ApplyAdapter();
        recyclerView.setAdapter(applyAdapter);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        setDate("PUBG",0);
                        applyImage.setImageResource(R.drawable.pubg);
                        break;
                    case 1:
                        setDate("Dota2",1);
                        applyImage.setImageResource(R.drawable.dota2);
                        break;
                    case 2:
                        setDate("LOL",2);
                        applyImage.setImageResource(R.drawable.lol);
                        break;
//                    case 3:
//                        setDate("OW",3);
//                        applyImage.setImageResource(R.drawable.ow);
//                        break;
                        default:
                            break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setDate(String s,int type) {
        String json = GetJsonUtil.getJson(this.getContext(), "apply.json");
        Gson gson = new Gson();
        ApplyBean applyBean = gson.fromJson(json, ApplyBean.class);
        List<ApplyBean.DataBean> datas = applyBean.getDate();
        for (ApplyBean.DataBean dataBean : datas) {
            if (s.equals(dataBean.getType())) {
                applyAdapter.setData(dataBean.getContext(),type);
                applyAdapter.notifyDataSetChanged();
            }
        }

    }
}
