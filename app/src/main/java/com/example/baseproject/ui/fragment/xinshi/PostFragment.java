package com.example.baseproject.ui.fragment.xinshi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.weight.LinedEditText;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PostFragment extends BaseFragment {


    @BindView(R.id.topbar) QMUITopBar topbar;
    @BindView(R.id.liedtext) LinedEditText liedtext;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_post, null);
        ButterKnife.bind(this, view);
        setTopbar(topbar,"帖子详情");
        topbar.addRightTextButton("发布",R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(liedtext.getText().toString())){
                    Toast.makeText(MyApplication.getContext(), "文字为空，暂未发布成功。", Toast.LENGTH_SHORT).show();
                    return;
                }
                popBackStack();
                Toast.makeText(MyApplication.getContext(), "发布成功", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
