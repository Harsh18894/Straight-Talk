package com.straighttalk.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.straighttalk.R;
import com.straighttalk.adapter.PagerAdapterGuest;
import com.straighttalk.ui.CustomTitle;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Harsh on 8/6/2016.
 */
public class DashboardActivityGuest extends AppCompatActivity {

    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_guest);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(CustomTitle.getTitle(this, "HCL Straight Talk"));

        PagerAdapterGuest pagerAdapterGuest = new PagerAdapterGuest(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapterGuest);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.browse);
        tabLayout.getTabAt(2).setIcon(R.mipmap.community);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard_guest, menu);
        return true;
    }
}
