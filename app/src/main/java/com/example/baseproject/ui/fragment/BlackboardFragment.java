package com.example.baseproject.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.adapter.BoardAdapter;
import com.example.baseproject.enity.BoardBean;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.decorator.GridDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BlackboardFragment extends BaseFragment {
    private List<BoardBean> boardBeans;
    private BoardAdapter boardAdapter;
    @BindView(R.id.recyclerview) RecyclerView recyclerview;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blackboard, null);
        ButterKnife.bind(this, layout);
        boardBeans=new ArrayList<>();
        boardBeans.add(new BoardBean(R.drawable.sa,"怎样做才能不虚度大学的时光","一，进入大学第一件事，先正确的认识你的家庭的阶层，之后有的放矢的去努力。二，保持一个好体魄，注意牙齿的保健，并且适当的学一下穿搭，完成中学生向成人的转变。三，大学里的社交，点到为止最好",189));
        boardBeans.add(new BoardBean(R.drawable.sb,"我们难忘的大学生活","我记得有一次老师交代我们要买书，新华书店第二天才开门，很多同学和我一起，晚上就去了北京市新华书店门口排队——就是因为很兴奋、想要尽快拿到书开始学习。我们那个时候就是这样，不会去想成绩好了能得到什么，只是一种自我要求。",229));
        boardBeans.add(new BoardBean(R.drawable.sc,"陪你聊聊大学时光","我之前对大学校园有过千种万种的想象，但是这些想象都巧妙地避开了我真实学校的样子，所以那一天我的心里充满着一种出乎意料的失望。接下来这个坑爹的地方被我和其他同学吐槽了四年。我们可以从宿舍没有空调骂到操场太小，再从选课系统如何卡慢喷到老师多么奇葩。聊起学校，平时一个个阳光和气的同学可以立马变得戾气满满。",139));
        boardBeans.add(new BoardBean(R.drawable.sd,"忆我的大学时光"," 毕业后，生活并不像我们期望的那样，走出大学门的那一刹那，摆在我们面前的都是荆棘，我们怀着一腔热血头也不回的扎进了荆棘丛中，我们在走，在前进，我们的身体被划破而不自知，一直走一直走，却发现慢慢的只剩下自己一个人，伤口越来越多，越来越多。。。。。。当你想要反抗的时候，却发现，伤的更深，当你想要呼喊的时候，却发现只能听到自己的回声，开始想要回去，但是，早已回不去了。。。",112));
        boardAdapter = new BoardAdapter(boardBeans);
        recyclerview.addItemDecoration(new GridDividerItemDecoration(MyApplication.getContext(), 1));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        recyclerview.setAdapter(boardAdapter);
        boardAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("k",boardAdapter.getData().get(position));
                        BoardDetailFragment boardDetailFragment=new BoardDetailFragment();
                        boardDetailFragment.setArguments(bundle);
                        startFragment(boardDetailFragment);
            }
        });
        return layout;
    }


}
