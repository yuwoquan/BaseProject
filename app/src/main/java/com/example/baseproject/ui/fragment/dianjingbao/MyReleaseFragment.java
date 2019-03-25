package com.example.baseproject.ui.fragment.dianjingbao;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baseproject.R;
import com.example.baseproject.adapter.ReleaseAdapter;
import com.example.baseproject.db.GreenDaoManager;
import com.example.baseproject.db.MyReleaseBean;
import com.example.baseproject.db.MyReleaseBeanDao;
import com.example.baseproject.db.MyReleaseController;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.weight.CustomLoadMoreView;
import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyReleaseFragment extends BaseFragment {

    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    @BindView(R.id.emptyView) QMUIEmptyView emptyView;
    private MyReleaseController myReleaseController;
    private List<MyReleaseBean> myReleaseBeans;
    private ReleaseAdapter releaseAdapter;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_my_release, null);
        ButterKnife.bind(this, view);
        myReleaseController =new MyReleaseController();
        myReleaseBeans = GreenDaoManager.getInstance().getSession().getMyReleaseBeanDao().queryBuilder()
                .offset(0)
                .limit(300)
                .orderAsc(MyReleaseBeanDao.Properties.Id)
                .build()
                .list();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);

        releaseAdapter =new ReleaseAdapter(myReleaseBeans);
        View foot = getLayoutInflater().inflate(R.layout.bottom, (ViewGroup) recyclerview.getParent(), false);
        QMUIRoundButton qmuiRoundButton=foot.findViewById(R.id.signout);
        qmuiRoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new CreateActivitiesFragment());
            }
        });
        releaseAdapter.addFooterView(foot);
        recyclerview.setAdapter(releaseAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        myReleaseBeans = GreenDaoManager.getInstance().getSession().getMyReleaseBeanDao().queryBuilder()
                .offset(0)
                .limit(300)
                .orderAsc(MyReleaseBeanDao.Properties.Id)
                .build()
                .list();
        if (myReleaseBeans.size() != 0) {
            recyclerview.setVisibility(View.VISIBLE);
            emptyView.show(false);
            emptyView.setVisibility(View.GONE);
        }else {
            recyclerview.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
            emptyView.show(false, "还没有组建活动？先组建一个", null, "创建活动", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startFragment(new CreateActivitiesFragment());
                }
            });
        }
        releaseAdapter.setNewData(myReleaseBeans);
    }
}
