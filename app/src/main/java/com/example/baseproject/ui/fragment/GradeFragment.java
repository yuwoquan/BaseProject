package com.example.baseproject.ui.fragment;

import android.content.res.TypedArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baseproject.MyApplication;
import com.example.baseproject.R;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.utils.utils.ShareUtils;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GradeFragment extends BaseFragment {
    @BindView(R.id.mtopbar) QMUITopBar mtopbar;
    @BindView(R.id.grade_num)
    TextView grade_num;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.btn_sure)
    QMUIRoundButton btn_sure;
    @BindView(R.id.user_head)
    ImageView user_head;


    private void initView() {
        TypedArray userHeads = getResources().obtainTypedArray(R.array.user_head_list);
        int index = ShareUtils.getInt(ShareUtils.GRADE_USER_INDEX, 0);
        user_head.setImageResource(userHeads.getResourceId(index, 0));
    }

    private void setListener() {
        grade_num.setText("0");
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MyApplication.getContext(), "打分成功！", Toast.LENGTH_SHORT).show();
                TimerTask task =    new TimerTask() {
                    @Override
                    public void run() {
                       popBackStack();
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, 500);
            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                grade_num.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    protected View onCreateView() {
        View view = View.inflate(getActivity(), R.layout.fragment_grade, null);
        ButterKnife.bind(this, view);
        initView();
        setTopbar(mtopbar,"用户打分");
        setListener();
        return view;
    }
}
