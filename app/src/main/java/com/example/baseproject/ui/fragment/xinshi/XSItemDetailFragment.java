package com.example.baseproject.ui.fragment.xinshi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XSItemDetailFragment extends BaseFragment {


    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.title) TextView titleve;
    @BindView(R.id.hea) ImageView hea;
    @BindView(R.id.type) TextView typee;
    @BindView(R.id.viewlo) TextView viewlo;
    private Bundle bundle;
    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_xsitem_detail, null);
        ButterKnife.bind(this, view);
        setTopbar(mtopbar,"帖子详情");
        bundle=getArguments();
        String title=bundle.getString("title");
        String type=bundle.getString("type");
        String msg=bundle.getString("msg");
        titleve.setText(title);
        typee.setText("#"+type+"#");
        viewlo.setText(msg);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
