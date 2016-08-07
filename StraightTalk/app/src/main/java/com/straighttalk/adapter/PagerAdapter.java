package com.straighttalk.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.straighttalk.fragments.BrowseFragment;
import com.straighttalk.fragments.CommunityFragment;
import com.straighttalk.fragments.HomeFragment;
import com.straighttalk.fragments.MessagesFragment;
import com.straighttalk.fragments.NotificationsFragment;

/**
 * Created by Harsh on 8/6/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new BrowseFragment();
                break;
            case 2:
                fragment = new CommunityFragment();
                break;
            case 3:
                fragment = new MessagesFragment();
                break;
            case 4:
                fragment = new NotificationsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
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
            case 3:
                return "";
            case 4:
                return "";
            default:
                return null;
        }
    }


}
