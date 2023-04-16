package com.example.bookapp.ui.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.bookapp.HymnsFragment;
import com.example.bookapp.R;
import com.example.bookapp.FavFragment;
import com.example.bookapp.MoreFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private TabLayout tabLayout;

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3};
    private final Context mContext;


    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
       //Returning all current tabs
        switch(position){
            case 0:
                HymnsFragment tab1=new HymnsFragment();
                return tab1;
            case 1:
                FavFragment tab2=new FavFragment();
                return tab2;
            case 2:
                MoreFragment tab3=new MoreFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }


    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }


}