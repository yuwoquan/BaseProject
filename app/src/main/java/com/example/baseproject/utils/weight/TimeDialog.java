package com.example.baseproject.utils.weight;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

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
    public TimeDialog(Context context, int themeResId,String txt,String color) {
        super(context, themeResId);
        init(txt,color);
    }

    public TimeDialog(Context context, boolean cancelable, OnCancelListener cancelListener,String txt,String color) {
        super(context, cancelable, cancelListener);
        init(txt,color);
    }

    public TimeDialog(Context context,String txt,String color) {
        super(context);
        init(txt,color);
    }

    public TimeDialog(Activity activity,String txt,String color){
        super(activity);
        init(txt,color);
    }
    public TimeDialog(Context context, float alpha, int gravity,String txt,String color) {
        super(context, alpha, gravity);
        init(txt,color);
    }

    private void init(String txt,String color) {

        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.time_dialog, null);
        Chronometer chronometer=dialogView.findViewById(R.id.timee);
        TextView textView=dialogView.findViewById(R.id.tex);
        textView.setText(txt);
        textView.setTextColor(Color.parseColor(color));
        chronometer.setTextColor(Color.parseColor(color));
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
