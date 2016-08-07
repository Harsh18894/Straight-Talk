package com.straighttalk.fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.straighttalk.R;
import com.straighttalk.activities.LoginActivity;
import com.straighttalk.ui.CustomTitle;
import com.straighttalk.ui.button.ButtonPlus;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragmentGuest extends Fragment {

    private View parentView;
    @Bind(R.id.btnFollow)
    ButtonPlus btnFollow;
    @Bind(R.id.txtPeople)
    TextView txtPeople;

    public CommunityFragmentGuest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_community_guest, container, false);
        ButterKnife.bind(this, parentView);
        populate();
        return parentView;
    }

    private void populate() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnFollow.setBackgroundResource(R.drawable.ripple_rounded);
        }


        txtPeople.setText(CustomTitle.getTitle(getActivity(), "Some of our Popular Members"));
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(getActivity())
                        .title(R.string.title_follow)
                        .content(R.string.content)
                        .positiveText(R.string.ok).onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        ActivityCompat.finishAffinity(getActivity());
                    }
                })
                        .show();
            }
        });
    }

}
