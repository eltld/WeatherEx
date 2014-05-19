package com.usi.comm.weatherEx.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.usi.comm.weatherEx.Fragment.CityFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private String[] cites = new String[] { "合肥", "上海", "南京", "东京" };
    
    @Override
    public CityFragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a CityFragement (defined as a static inner class
        // below) with the page number as its lone argument.
    	CityFragment fragment = new CityFragment();
        Bundle args = new Bundle();
        args.putInt(CityFragment.ARG_SECTION_NUMBER, position);
        args.putString("CITY", cites[position]);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return cites.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       // Locale l = Locale.getDefault();
//        switch (position) {
//            case 0:
//                return getString(R.string.title_section1).toUpperCase(l);
//            case 1:
//                return getString(R.string.title_section2).toUpperCase(l);
//            case 2:
//                return getString(R.string.title_section3).toUpperCase(l);
//        }
        return "CityName";
    }



}