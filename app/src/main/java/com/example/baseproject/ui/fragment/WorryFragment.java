package com.example.baseproject.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.baseproject.R;
import com.example.baseproject.adapter.RecommentAdapter;
import com.example.baseproject.adapter.WorryAdapter;
import com.example.baseproject.enity.WorryBean;
import com.example.baseproject.mvp.ui.AbstractMvpFragment;
import com.example.baseproject.mvp.worry.WorryPresenter;
import com.example.baseproject.mvp.worry.WorryView;
import com.example.baseproject.utils.holder.BannerViewHolder;
import com.example.baseproject.utils.weight.NoConflictRecyclerView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WorryFragment extends AbstractMvpFragment<WorryView, WorryPresenter> implements WorryView {

    @BindView(R.id.banner) MZBannerView banner;
    @BindView(R.id.recyclerview) NoConflictRecyclerView recyclerview;
    private List<String> list = new ArrayList<>();
    private List<WorryBean.ListBean> listBeans=new ArrayList<>();
    private WorryAdapter worryAdapter;
    private static final String TAG = "WorryFragment";

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_worry, null);
        ButterKnife.bind(this, view);
        list.add("http://img3.imgtn.bdimg.com/it/u=648162724,303298073&fm=26&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=941407802,418029548&fm=11&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=224623377,2653970089&fm=26&gp=0.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=903409440,2612704670&fm=26&gp=0.jpg");
        // 设置数据
        banner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        worryAdapter=new WorryAdapter(listBeans);
        recyclerview.setAdapter(worryAdapter);
        worryAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
//        recyclerview.setNestedScrollingEnabled(false);
        getPresenter().clickWorry();
        return view;
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public WorryPresenter createPresenter() {
        return new WorryPresenter();
    }

    @Override
    public void successgetWorry(WorryBean worryBean) {
        worryAdapter.setNewData(worryBean.getList());
    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "resultFailure: "+result );
    }

    @Override
    public void requestLoading() {

    }
}
