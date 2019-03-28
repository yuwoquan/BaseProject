package com.example.baseproject.ui.fragment;

import android.graphics.Color;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.weight.TimeDialog;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButtonDrawable;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


public class ZhiyinFragment extends BaseFragment {

    @BindView(R.id.tabs) QMUITabSegment mTabSegment;
    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.sex) TextView sex;
    @BindView(R.id.man) QMUIRoundButton man;
    @BindView(R.id.woman) QMUIRoundButton woman;
    @BindView(R.id.xing) TextView xing;
    @BindView(R.id.qiang) QMUIRoundButton qiang;
    @BindView(R.id.ruo) QMUIRoundButton ruo;
    @BindView(R.id.ceyice) QMUIRoundButton ceyice;
    @BindView(R.id.qmui_layout) QMUILinearLayout qmuiLayout;
    @BindView(R.id.im) ImageView im;
    private float mShadowAlpha = 0.48f;
    private int mShadowElevationDp = 8;
    private int mRadius = 28;
    private QMUITipDialog tipDialog;
    private Boolean isBoy = true;
    private Boolean isQiang = true;
    private TimeDialog timeDialog;

    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_zhiyin, null);
        ButterKnife.bind(this, view);
        initTabs();
        mtopbar.setTitle("知音");
        qmuiLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(MyApplication.getContext(), mShadowElevationDp),
                mShadowAlpha);
        final QMUIRoundButtonDrawable bgone = (QMUIRoundButtonDrawable) man.getBackground();
        final QMUIRoundButtonDrawable bgtwo = (QMUIRoundButtonDrawable) woman.getBackground();
        final QMUIRoundButtonDrawable bgthree = (QMUIRoundButtonDrawable) qiang.getBackground();
        final QMUIRoundButtonDrawable bgfour = (QMUIRoundButtonDrawable) ruo.getBackground();

        ceyice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoy) {
                    Toast.makeText(MyApplication.getContext(), "请选择性别", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (isQiang) {
                    Toast.makeText(MyApplication.getContext(), "请选择性格", Toast.LENGTH_SHORT).show();
                    return;
                }
                tipDialog = new QMUITipDialog.Builder(getContext())
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                        .setTipWord("正在测试")
                        .create();
                tipDialog.show();
                Observable.timer(3, TimeUnit.SECONDS)
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                Looper.prepare();
                                tipDialog.dismiss();
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MyApplication.getContext(), "正太音～～", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
            }
        });

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeDialog=new TimeDialog(getActivity(),"正在录音","#FFCF47");
                final WindowManager.LayoutParams params = timeDialog.getWindow().getAttributes();
                params.width = 600;
                params.height = 600;
                timeDialog.getWindow().setAttributes(params);
                timeDialog.show();
            }
        });
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBoy = false;
                bgone.setColor(Color.parseColor("#3FD0AD"));
                bgtwo.setColor(Color.parseColor("#FFFFFF"));
            }
        });
        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBoy = false;
                bgtwo.setColor(Color.parseColor("#EE85C1"));
                bgone.setColor(Color.parseColor("#FFFFFF"));
            }
        });
        qiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isQiang = false;
                bgthree.setColor(Color.parseColor("#31BDF3"));
                bgfour.setColor(Color.parseColor("#FFFFFF"));
            }
        });
        ruo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isQiang = false;
                bgfour.setColor(Color.parseColor("#31BDF3"));
                bgthree.setColor(Color.parseColor("#FFFFFF"));
            }
        });

        return view;
    }


    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(getActivity(), R.attr.qmui_config_color_gray_6);
        mTabSegment.setDefaultNormalColor(normalColor);
        mTabSegment.setDefaultSelectedColor(ContextCompat.getColor(getActivity(), R.color.app_color_blue));
        mTabSegment.setHasIndicator(false);
        QMUITabSegment.Tab light = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.e),
                ContextCompat.getDrawable(getContext(), R.mipmap.f),
                "打分", false
        );
        QMUITabSegment.Tab music = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.a),
                ContextCompat.getDrawable(getContext(), R.mipmap.d),
                "扮演", false
        );
        QMUITabSegment.Tab setting = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(getContext(), R.mipmap.c),
                ContextCompat.getDrawable(getContext(), R.mipmap.b),
                "气质", false
        );
        mTabSegment.addTab(light).addTab(music).addTab(setting);
        mTabSegment.notifyDataChanged();
    }

}
