package com.example.baseproject.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.ui.fragment.dianjingbao.DianJingBaseFragment;
import com.example.baseproject.ui.fragment.xinshi.XinshiFragment;
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
        QMUICommonListItemView one = mGroupListView.createItemView("电影");
        one.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView two = mGroupListView.createItemView("用户打分");
        two.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView three = mGroupListView.createItemView("大学时光");
        three.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView four = mGroupListView.createItemView("知音");
        four.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView five = mGroupListView.createItemView("粉丝群");
        five.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView six = mGroupListView.createItemView("电竞宝");
        six.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView seven = mGroupListView.createItemView("心事圈");
        seven.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

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
                .addItemView(six, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startFragment(new DianJingBaseFragment());
                    }
                })
                .addItemView(seven, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startFragment(new XinshiFragment());
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
