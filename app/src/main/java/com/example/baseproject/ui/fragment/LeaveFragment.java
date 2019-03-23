package com.example.baseproject.ui.fragment;

import android.content.res.TypedArray;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.utils.CommonUtils;
import com.example.baseproject.utils.utils.ShareUtils;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class LeaveFragment extends BaseFragment {
    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.btn_refresh)
    Button btn_refresh;
    @BindView(R.id.user_grade_one)
    ImageView user_grade_one;
    @BindView(R.id.user_grade_two)
    ImageView user_grade_two;
    @BindView(R.id.user_grade_three)
    ImageView user_grade_three;
    @BindView(R.id.user_grade_four)
    ImageView user_grade_four;
    @BindView(R.id.user_grade_fire)
    ImageView user_grade_fire;
    @BindView(R.id.user_grade_six)
    ImageView user_grade_six;
    @BindView(R.id.us_head)
    CircleImageView us_head;
    @BindView(R.id.txt_grade)
    TextView txt_grade;// 评分
    @BindView(R.id.txt_grade_num)// h
            TextView txt_grade_num;// 评分人数
    private   int index = 0;
    List<Integer> list;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            txt_grade_num.setText("" + ShareUtils.getLong(ShareUtils.USER_USE_DURATION, 0));
        }
    }

    private void refreshUser() {
        TypedArray userHeads = getResources().obtainTypedArray(R.array.user_head_list);
        // 获取随机6个不重复的下标值
        //接收产生的随机数
        int temp = 0;
        list = new ArrayList<Integer>();
        for (int i = 1; i <= 6; i++) {
            //将产生的随机数作为被抽数组的索引
            temp = CommonUtils.getRandomNum(0, userHeads.length() - 1);
            if (!(list.contains(temp))) {
                list.add(temp);
            } else {
                i--;
            }
        }

        user_grade_one.setImageResource(userHeads.getResourceId(list.get(0).intValue(), 0));
        user_grade_two.setImageResource(userHeads.getResourceId(list.get(1).intValue(), 0));
        user_grade_three.setImageResource(userHeads.getResourceId(list.get(2).intValue(), 0));
        user_grade_four.setImageResource(userHeads.getResourceId(list.get(3).intValue(), 0));
        user_grade_fire.setImageResource(userHeads.getResourceId(list.get(4).intValue(), 0));
        user_grade_six.setImageResource(userHeads.getResourceId(list.get(5).intValue(), 0));
    }

    private void initView() {
        us_head.setImageURI(Uri.parse(ShareUtils.getString(ShareUtils.USER_HEAD_URI, "")));
        txt_grade.setText("" + CommonUtils.getRandomNum(1, 10));
    }

    private void setListener() {
        refreshUser();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_refresh:
                break;
            default:
                int index = 0;
                switch (v.getId()) {

                }
//                StartUtils.startActivityById(getActivity(),R.id.user_grade_one);
                break;
        }
    }

    @Override
    protected View onCreateView() {
        View view = View.inflate(getActivity(), R.layout.fragment_leave, null);
        ButterKnife.bind(this, view);
        initView();
        setListener();
        setTopbar(mtopbar,"陌陌优化大师");
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshUser();
            }
        });
//        initData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @OnClick({R.id.user_grade_one, R.id.user_grade_two, R.id.user_grade_three, R.id.user_grade_four, R.id.user_grade_fire, R.id.user_grade_six})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_grade_one:
                index = list.get(0).intValue();
                break;
            case R.id.user_grade_two:
                index = list.get(1).intValue();
                break;
            case R.id.user_grade_three:
                index = list.get(2).intValue();
                break;
            case R.id.user_grade_four:
                index = list.get(3).intValue();
                break;
            case R.id.user_grade_fire:
                index = list.get(4).intValue();
                break;
            case R.id.user_grade_six:
                index = list.get(5).intValue();
                break;
            default:
                break;
        }
        ShareUtils.putInt(ShareUtils.GRADE_USER_INDEX, index);
        startFragment(new GradeFragment());
    }
}
