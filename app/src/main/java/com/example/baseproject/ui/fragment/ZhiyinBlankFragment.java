package com.example.baseproject.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;

import butterknife.ButterKnife;

public class ZhiyinBlankFragment extends BaseFragment {




    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_zhiyin_blank, null);
        ButterKnife.bind(this, view);
        return view;
    }

}
