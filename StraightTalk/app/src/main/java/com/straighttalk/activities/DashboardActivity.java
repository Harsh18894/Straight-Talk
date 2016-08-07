package com.straighttalk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.straighttalk.R;
import com.straighttalk.adapter.PagerAdapter;
import com.straighttalk.ui.CustomTitle;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Harsh on 8/6/2016.
 */
public class DashboardActivity extends AppCompatActivity {

    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        populate();

    }

    private void populate() {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(CustomTitle.getTitle(this, "HCL Straight Talk"));

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.browse);
        tabLayout.getTabAt(2).setIcon(R.mipmap.community);
        tabLayout.getTabAt(3).setIcon(R.mipmap.messages);
        tabLayout.getTabAt(4).setIcon(R.mipmap.ac_notifications);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuLogout:
                Intent intent = new Intent(this, AppInfoActivity.class);
                startActivity(intent);
                ActivityCompat.finishAffinity(this);
                break;
        }

        return super.onOptionsItemSelected(item);
    }



}
