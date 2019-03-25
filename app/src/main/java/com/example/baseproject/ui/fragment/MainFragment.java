package com.example.baseproject.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.ui.fragment.RecommendFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainFragment extends BaseFragment {


    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.listview) QMUIGroupListView mGroupListView;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        initListView();
        mtopbar.setTitle("Home");
        return view;
    }

    private void initListView() {
        QMUICommonListItemView one = mGroupListView.createItemView("one");
        one.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView two = mGroupListView.createItemView("two");
        two.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView three = mGroupListView.createItemView("three");
        three.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView four = mGroupListView.createItemView("four");
        four.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView five = mGroupListView.createItemView("five");
        five.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUIGroupListView.newSection(getContext())
                .addItemView(one, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startFragment(new RecommendFragment());
                    }
                })
                .addItemView(two, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startFragment(new LeaveFragment());
                    }
                })
                .addItemView(three, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startFragment(new BlackboardFragment());
                    }
                })
                .addItemView(four, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startFragment(new ZhiyinFragment());
                    }
                })
                .addItemView(five, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startFragment(new ZhuboFragment());
                    }
                })
                .addTo(mGroupListView);
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
