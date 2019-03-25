package com.example.baseproject.utils.weight;

import android.content.Context;

/**
 * @author Ambrose
 * @date 2019/3/25 1:26 PM
 * @desc
 */
public class TimerDialog extends RxDialog {
    public TimerDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public TimerDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public TimerDialog(Context context) {
        super(context);
    }

    public TimerDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
    }
}
