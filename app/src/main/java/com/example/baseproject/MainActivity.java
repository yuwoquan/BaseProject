package com.example.baseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.baseproject.mvp.ui.base.BaseActivity;
import com.example.baseproject.mvp.ui.base.BaseFragment;
import com.example.baseproject.ui.fragment.HomeFragment;
import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class MainActivity extends BaseActivity {

    private static final String KEY_FRAGMENT = "key_fragment";
    private static final String KEY_URL = "key_url";
    private static final String KEY_TITLE = "key_title";
    private static final int VALUE_FRAGMENT_HOME = 0;
    private static final int VALUE_FRAGMENT_NOTCH_HELPER = 1;
    private static final int VALUE_FRAGMENT_ARCH_TEST = 2;
    private static final int VALUE_FRAGMENT_WEB_EXPLORER_TEST = 3;
    private static final int VALUE_FRAGMENT_SURFACE_TEST = 4;

    @Override
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        if (savedInstanceState == null) {
            QMUIFragment fragment = new HomeFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(getContextViewId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commit();
        }
    }

}
