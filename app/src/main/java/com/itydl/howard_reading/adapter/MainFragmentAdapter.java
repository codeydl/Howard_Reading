package com.itydl.howard_reading.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itydl.howard_reading.base.BaseFragment;
import com.itydl.howard_reading.fragment.FragmentFactory;

/**
 * @author ydl
 */

public class MainFragmentAdapter extends FragmentPagerAdapter{

    private int count;

    public MainFragmentAdapter(FragmentManager fm,int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment = FragmentFactory.getFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return count;
    }
}
