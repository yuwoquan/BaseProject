package com.example.baseproject.ui.fragment.dianjingbao;

import android.content.DialogInterface;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.weight.TimeDialog;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;


public class PipeiFragment extends BaseFragment {


    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.groupListView) QMUIGroupListView mGroupListView;
    @BindView(R.id.signout) QMUIRoundButton signout;
    private int mCurrentDialogStyle = com.qmuiteam.qmui.R.style.QMUI_Dialog;
    final String[] itemone = new String[]{"华语", "外语", "全语种"};
    final String[] itemtwo = new String[]{"男生", "女生", "不限"};
    final String[] itemthree = new String[]{"唱歌小白", "K房麦霸", "我是歌手"};
    final String[] itemfour = new String[]{"清新", "空灵", "沧桑","低沉"};
    private QMUITipDialog tipDialog;
    private TimeDialog timeDialog;
    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_pipei, null);
        ButterKnife.bind(this, view);
        mtopbar.setTitle("匹配");
        initListview();
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeDialog=new TimeDialog(getActivity(),"正在匹配","#FE6D4B");
                final WindowManager.LayoutParams params = timeDialog.getWindow().getAttributes();
                params.width = 600;
                params.height = 600;
                timeDialog.getWindow().setAttributes(params);
                timeDialog.show();

                Observable.timer(15, TimeUnit.SECONDS)
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                Looper.prepare();
                                timeDialog.dismiss();
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MyApplication.getContext(), "匹配失败，暂无符合匹配的在线用户～", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
            }

        });
        return view;
    }

    private void initListview() {  View.OnClickListener onClickListener = null;
        final QMUICommonListItemView itemWithChevron4 = mGroupListView.createItemView("语种");
        itemWithChevron4.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron4.setImageDrawable(getResources().getDrawable(R.drawable.xiangmu));
        itemWithChevron4.setDetailText("华语");
        itemWithChevron4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSingleChoiceDialog(itemWithChevron4,itemone);
            }
        });
        final QMUICommonListItemView itemWithChevron5 = mGroupListView.createItemView("性别");
        itemWithChevron5.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron5.setDetailText("男生");
        itemWithChevron5.setImageDrawable(getResources().getDrawable(R.drawable.xingbie));
        itemWithChevron5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSingleChoiceDialog(itemWithChevron5,itemtwo);
            }
        });
        final QMUICommonListItemView itemWithChevron6 = mGroupListView.createItemView("实力");
        itemWithChevron6.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron6.setDetailText("唱歌小白");
        itemWithChevron6.setImageDrawable(getResources().getDrawable(R.drawable.power));
        itemWithChevron6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSingleChoiceDialog(itemWithChevron6,itemthree);
            }
        });
        final  QMUICommonListItemView itemWithChevron7 = mGroupListView.createItemView("音色");
        itemWithChevron7.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron7.setDetailText("清新");
        itemWithChevron7.setImageDrawable(getResources().getDrawable(R.drawable.kaiheivoice));
        itemWithChevron7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSingleChoiceDialog(itemWithChevron7,itemfour);
            }
        });
        QMUIGroupListView
                .newSection(getContext())
                .addItemView(itemWithChevron4, onClickListener)
                .addItemView(itemWithChevron5, onClickListener)
                .addItemView(itemWithChevron6,  onClickListener)
                .addItemView(itemWithChevron7,  onClickListener)
                .addTo(mGroupListView);
    }

    private void showSingleChoiceDialog(final QMUICommonListItemView itemView, final String[] items ) {
        final int checkedIndex = 1;
        new QMUIDialog.CheckableDialogBuilder(getActivity())
                .setCheckedIndex(checkedIndex)
                .addItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getActivity(), "你选择了 " + items[which], Toast.LENGTH_SHORT).show();
                        itemView.setDetailText(items[which].toString());
                        dialog.dismiss();
                    }
                })
                .create(mCurrentDialogStyle).show();
    }
}
