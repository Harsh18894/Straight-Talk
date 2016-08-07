package com.straighttalk.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.pageindicator.indicator.FlycoPageIndicaor;
import com.straighttalk.R;
import com.straighttalk.adapter.AppInfoSlidingImageAdapter;
import com.straighttalk.ui.button.ButtonPlus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harsh on 8/6/2016.
 */
public class AppInfoActivity extends AppCompatActivity {

    @Bind(R.id.btnLogin)
    ButtonPlus btnLogin;
    @Bind(R.id.btnGuest)
    ButtonPlus btnGuest;
    @Bind(R.id.indicator)
    FlycoPageIndicaor indicaor;
    @Bind(R.id.pager)
    ViewPager pager;

    @OnClick(R.id.btnLogin) void login(){
        startActivity(new Intent(AppInfoActivity.this, LoginActivity.class));
    }

    @OnClick(R.id.btnGuest) void guest(){
       Intent intent = new Intent(AppInfoActivity.this, DashboardActivityGuest.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_app_info);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);

        AppInfoSlidingImageAdapter appInfoSlidingImageAdapter = new AppInfoSlidingImageAdapter(this);
        pager.setAdapter(appInfoSlidingImageAdapter);
        indicaor.setViewPager(pager);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnLogin.setBackgroundResource(R.drawable.ripple);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnGuest.setBackgroundResource(R.drawable.ripple);
        }
    }
}
