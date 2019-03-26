package com.example.baseproject.utils.weight;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;

import com.example.baseproject.R;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

/**
 * @author Ambrose
 * @date 2019/3/26 11:49 AM
 * @desc
 */
public class TimeDialog extends RxDialog {
    private float mShadowAlpha = 0.25f;
    private int mShadowElevationDp = 6;
    private int mRadius;
    public TimeDialog(Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    public TimeDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    public TimeDialog(Context context) {
        super(context);
        init();
    }

    public TimeDialog(Activity activity){
        super(activity);
        init();
    }
    public TimeDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        init();
    }

    private void init() {

        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.time_dialog, null);
        Chronometer chronometer=dialogView.findViewById(R.id.timee);
        chronometer.start();
        mRadius = QMUIDisplayHelper.dp2px(getContext(), 6);
        QMUILinearLayout  mTestLayout=dialogView.findViewById(R.id.lo);
        mTestLayout.setShadowColor(0xff0000ff);
        mTestLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(getContext(), mShadowElevationDp),
                mShadowAlpha);
        ImageView imageView=dialogView.findViewById(R.id.closw);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
        setContentView(dialogView);
        mLayoutParams.gravity = Gravity.CENTER;
    }
}
