package com.example.androidbti.exemploaulaswipeview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter  extends FragmentStatePagerAdapter {


    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.nerInstance(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "TAB "+(position + 1);
    }
}
