package com.example.baseproject.utils.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * @author Ambrose
 * @date 2018/12/7 3:14 PM
 * @desc
 */
public class GlideUtil {

    public static void loadImage(Context context, Object imgUrl, SimpleTarget<Drawable> target) {
        Glide.with(context)
                .load(imgUrl)
                .into(target);
    }

    public static void loadImage(Context context, Object imgUrl, ImageView imageView) {
        Glide.with(context)
                .load(imgUrl)
                .into(imageView);
    }
}
