package com.example.studentinformationsystem.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.studentinformationsystem.DetailedGradeFrag;
import com.example.studentinformationsystem.R;
import com.example.studentinformationsystem.SummaryGradeFrag;

import java.util.Map;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    private Bundle summaryGradeInfo;
    private Bundle detailedGradeInfo;

    public SectionsPagerAdapter(Context context, FragmentManager fm, Bundle summaryGradeInfo, Bundle detailedGradeInfo) {
        super(fm);
        mContext = context;
        this.summaryGradeInfo = summaryGradeInfo;
        this.detailedGradeInfo = detailedGradeInfo;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment frag = null;
        switch (position){
            case 0:
                frag = new SummaryGradeFrag();
                frag.setArguments(summaryGradeInfo);
                break;
            case 1:
                frag = new DetailedGradeFrag();
                frag.setArguments(detailedGradeInfo);
                break;
        }
        return frag;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Özet Not durumu";
            case 1:
                return "Detaylı Not Durumu";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}