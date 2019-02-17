package com.example.baseproject.utils.vlayout;

import android.view.View;

/**
 * 条目子View点击
 */
public interface OnItemChildClickListener<T> {
    void onItemChildClick(View view, int position, T mData);
}
