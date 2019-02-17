package com.example.baseproject.utils.helper;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;


/**
 * Created by Administrator on 2018/7/24/024.
 */

public class UiActivty {
    private static  float sNoncomtDensity;
    private static  float sNoncompatScaledDensity;

    public static void setCustomDensity(@NonNull Activity activity, @NonNull final Application application){
        final DisplayMetrics appDesplayMetrics=application.getResources().getDisplayMetrics();

        if (sNoncomtDensity==0){
            sNoncomtDensity=appDesplayMetrics.density;
            sNoncompatScaledDensity=appDesplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig!=null && newConfig.fontScale>0){
                        sNoncompatScaledDensity=application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
        final float targetDensity = appDesplayMetrics.widthPixels / 360;
        final float taggetScaledDensity = targetDensity * (sNoncompatScaledDensity / sNoncomtDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        appDesplayMetrics.density = targetDensity;
        appDesplayMetrics.scaledDensity = taggetScaledDensity;
        appDesplayMetrics.densityDpi = targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics=activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density=targetDensity;
        activityDisplayMetrics.scaledDensity=taggetScaledDensity;
        activityDisplayMetrics.densityDpi=targetDensityDpi;
    }
}
