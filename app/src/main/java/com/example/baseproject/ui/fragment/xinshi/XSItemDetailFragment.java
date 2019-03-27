package com.example.baseproject.ui.fragment.xinshi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.weight.InputTextMsgDialog;
import com.qmuiteam.qmui.layout.QMUIButton;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XSItemDetailFragment extends BaseFragment {


    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.title) TextView titleve;
    @BindView(R.id.hea) ImageView hea;
    @BindView(R.id.type) TextView typee;
    @BindView(R.id.viewlo) TextView viewlo;
    @BindView(R.id.text) TextView textView;
    @BindView(R.id.com) QMUIButton com;

    private Bundle bundle;
    InputTextMsgDialog inputTextMsgDialog;
    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_xsitem_detail, null);
        ButterKnife.bind(this, view);
        setTopbar(mtopbar, "帖子详情");
        bundle = getArguments();
        String title = bundle.getString("title");
        String type = bundle.getString("type");
        String msg = bundle.getString("msg");
        titleve.setText(title);
        typee.setText("#" + type + "#");
        viewlo.setText(msg);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputTextMsgDialog==null){
                    inputTextMsgDialog = new InputTextMsgDialog(getActivity(), R.style.dialog_center);
                }

                inputTextMsgDialog.show();
                inputTextMsgDialog.setmOnTextSendListener(new InputTextMsgDialog.OnTextSendListener() {
                    @Override
                    public void onTextSend(String msg) {
                        Toast.makeText(MyApplication.getContext(), "评论成功。", Toast.LENGTH_SHORT).show();
                        inputTextMsgDialog.dismiss();
                    }
                });

            }
        });
        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputTextMsgDialog==null){
                    inputTextMsgDialog = new InputTextMsgDialog(getActivity(), R.style.dialog_center);
                }

                inputTextMsgDialog.show();
                inputTextMsgDialog.setmOnTextSendListener(new InputTextMsgDialog.OnTextSendListener() {
                    @Override
                    public void onTextSend(String msg) {
                        Toast.makeText(MyApplication.getContext(), "评论成功。", Toast.LENGTH_SHORT).show();
                        inputTextMsgDialog.dismiss();
                    }
                });
            }
        });
        return view;
    }

}
