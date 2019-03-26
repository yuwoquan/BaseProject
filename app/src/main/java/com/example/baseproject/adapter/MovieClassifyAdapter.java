package com.example.baseproject.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.example.baseproject.ui.fragment.xinshi.WorryOnFragment;


/**
 * fragment使用viewpager则需要使用FragmentStatePagerAdapter
 * activity下则可以使用FragmentPagerAdapter。否则界面在第二进来无法重新刷新界面
 */
public class MovieClassifyAdapter extends FragmentStatePagerAdapter {

    public final int MovieCOUNT=2;
    private String[] type=new String[]{"最新","精选"};

    public MovieClassifyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) WorryOnFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return MovieCOUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return type[position];
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.e("--", "destroyItem: " );
        super.destroyItem(container, position, object);
    }
}

