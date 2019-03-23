package com.example.baseproject.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.adapter.CommentAdapter;
import com.example.baseproject.db.CommentBean;
import com.example.baseproject.db.CommentBeanDao;
import com.example.baseproject.db.CommentController;
import com.example.baseproject.db.GreenDaoManager;
import com.example.baseproject.enity.BoardBean;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BoardDetailFragment extends BaseFragment {

    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.msg) TextView msg;
    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    @BindView(R.id.image) QMUIRadiusImageView image;
    private List<CommentBean> commentBeans;
    private Bundle bundle;
    private BoardBean boardBean;
    private CommentController commentController;
    private CommentAdapter commentAdapter;
    private CommentBean commentBean=new CommentBean();
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_board_detail, null);
        ButterKnife.bind(this, layout);
        bundle = getArguments();
        boardBean = (BoardBean) bundle.getSerializable("k");
//        mtopbar.addLeftImageButton(R.drawable.back, R.id.topbar_view_left).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                popBackStack();
//            }
//        });
        setTopbar(mtopbar,boardBean.getMsg());
        Glide.with(MyApplication.getContext()).load(boardBean.getPhoto()).into(image);
        msg.setText("\u3000"+boardBean.getConntent());
//        mtopbar.setTitle(boardBean.getMsg());
        commentController=CommentController.getInstance();
        commentBeans= GreenDaoManager.getInstance().getSession().getCommentBeanDao().queryBuilder()
                .offset(0)
                .limit(300)
                .orderAsc(CommentBeanDao.Properties.Id)
                .build()
                .list();
        Collections.shuffle(commentBeans);
//        commentBeans.subList(15,30);
        GreenDaoManager.getInstance().getSession().getCommentBeanDao().save(commentBean);
        commentAdapter= new CommentAdapter(commentBeans.subList(1,30));
//        recyclerview.addItemDecoration(new GridDividerItemDecoration(MyApplication.getContext(), 1));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        recyclerview.setAdapter(commentAdapter);
        commentAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView tvNotFocus = view.findViewById(R.id.zan);//默认未关注
                Drawable nav_up=getResources().getDrawable(R.drawable.zan_select);
                tvNotFocus.setText(String.valueOf(commentAdapter.getData().get(position).getZannum()+1));
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                tvNotFocus.setCompoundDrawables(nav_up, null, null, null);
            }
        });
        return layout;
    }


}
