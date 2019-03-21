package com.example.baseproject.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.baseproject.R;
import com.example.baseproject.adapter.RecommentAdapter;
import com.example.baseproject.enity.InTheatersBean;
import com.example.baseproject.enity.MovieDetailBean;
import com.example.baseproject.mvp.movie.MoviePresenter;
import com.example.baseproject.mvp.movie.MovieView;
import com.example.baseproject.mvp.ui.AbstractMvpFragment;
import com.qmuiteam.qmui.widget.QMUIEmptyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecommendFragment extends AbstractMvpFragment<MovieView, MoviePresenter> implements MovieView {


    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    @BindView(R.id.emptyview) QMUIEmptyView emptyview;
    private List<InTheatersBean.SubjectsBean> subjectsBeanList=new ArrayList<>();
    private RecommentAdapter recommentAdapter;
    private static final String TAG = "RecommendFragment";

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommend, null);
        ButterKnife.bind(this, view);
        emptyview.show(true);
        getPresenter().clickInthe();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        recommentAdapter=new RecommentAdapter(subjectsBeanList);
        recyclerview.setAdapter(recommentAdapter);
        recommentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle=new Bundle();
                MovieDetailFragment movieDetailFragment=new MovieDetailFragment();
                bundle.putString("id",recommentAdapter.getData().get(position).getId());
                Log.e(TAG, "onItemClick: "+recommentAdapter.getData().get(position).getId() );
                movieDetailFragment.setArguments(bundle);
                startFragment(movieDetailFragment);
            }
        });
        return view;
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void successgetIntheat(InTheatersBean inTheatersBean) {
        emptyview.show(false);
        emptyview.setVisibility(View.GONE);
        recommentAdapter.setNewData(inTheatersBean.getSubjects());
    }

    @Override
    public void successgetMovieDetai(MovieDetailBean movieDetailBean) {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void requestLoading() {

    }

    @Override
    public MoviePresenter createPresenter() {
        return new MoviePresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
