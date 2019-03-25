package com.example.baseproject.ui.fragment.dianjingbao;

import android.view.LayoutInflater;
import android.view.View;

import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.weight.spinner.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BaoMingFragment extends BaseFragment {


    @BindView(R.id.spinner) NiceSpinner spinner;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_bao_ming, null);
        ButterKnife.bind(this, view);
        List<String> dataset = new LinkedList<>(Arrays.asList("PUBG", "英雄联盟", "王者荣耀", "QQ飞车", "阴阳师"));
        spinner.attachDataSource(dataset);
        return view;
    }

}
