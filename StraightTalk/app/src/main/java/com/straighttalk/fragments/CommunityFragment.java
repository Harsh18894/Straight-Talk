package com.straighttalk.fragments;


import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.datetimepicker.date.DatePickerDialog;
import com.straighttalk.R;
import com.straighttalk.ui.Snackbar;
import com.straighttalk.ui.button.ButtonPlus;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends android.support.v4.app.Fragment implements com.android.datetimepicker.date.DatePickerDialog.OnDateSetListener {


    private View parentView;

    @Bind(R.id.txtDate)
    TextView txtDate;
    @Bind(R.id.btnSchedule)
    ButtonPlus btnSchedule;
    @Bind(R.id.btnOrganise)
    ButtonPlus btnOrganise;

    @OnClick(R.id.txtDate)
    void date() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show(getActivity().getFragmentManager(), "datePicker");
    }

    @OnClick(R.id.btnSchedule)
    void schedule() {
        if (txtDate.getText().toString().equals("Schedule A Meeting")) {
            Snackbar.show(getActivity(), "Please Select A Date.");
            return;
        }
        Snackbar.show(getActivity(), "Meeting Scheduled.");
    }

    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_community, container, false);
        ButterKnife.bind(this, parentView);
        populate();
        return parentView;
    }

    private void populate() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnSchedule.setBackgroundResource(R.drawable.ripple_rounded);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnOrganise.setBackgroundResource(R.drawable.ripple_rounded);
        }

        btnOrganise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri skypeUri = Uri.parse("skype:");
                Intent myIntent = new Intent(Intent.ACTION_VIEW, skypeUri);
                myIntent.setComponent(new ComponentName("com.skype.raider", "com.skype.raider.Main"));
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(myIntent);
            }
        });
    }


    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
        String dateString = dayOfMonth + " - " + (monthOfYear + 1) + " - " + year;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
        Date now = new Date();
        now = getDateWithOutTime(now);

        Date date = gregorianCalendar.getTime();

        if (date.compareTo(now) == -1) {
            Snackbar.show(getActivity(), getResources().getString(R.string.invalid_date));
            return;
        }
        txtDate.setText(dateString);
    }


    private Date getDateWithOutTime(Date targetDate) {
        Calendar newDate = Calendar.getInstance();
        newDate.setLenient(false);
        newDate.setTime(targetDate);
        newDate.set(Calendar.HOUR_OF_DAY, 0);
        newDate.set(Calendar.MINUTE, 0);
        newDate.set(Calendar.SECOND, 0);
        newDate.set(Calendar.MILLISECOND, 0);

        return newDate.getTime();

    }

}
