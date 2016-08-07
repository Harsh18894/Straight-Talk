package com.straighttalk.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.straighttalk.fragments.BrowseFragment;
import com.straighttalk.fragments.BrowseFragmentGuest;
import com.straighttalk.fragments.CommunityFragment;
import com.straighttalk.fragments.CommunityFragmentGuest;
import com.straighttalk.fragments.HomeFragment;
import com.straighttalk.fragments.HomeFragmentGuest;

/**
 * Created by Harsh on 8/6/2016.
 */
public class PagerAdapterGuest extends FragmentStatePagerAdapter {
    public PagerAdapterGuest(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragmentGuest();
                break;
            case 1:
                fragment = new BrowseFragmentGuest();
                break;
            case 2:
                fragment = new CommunityFragmentGuest();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "";
            case 1:
                return "";
            case 2:
                return "";
            default:
                return null;
        }
    }


}
