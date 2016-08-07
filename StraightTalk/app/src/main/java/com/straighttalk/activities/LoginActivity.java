package com.straighttalk.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.straighttalk.R;
import com.straighttalk.ui.CustomTitle;
import com.straighttalk.ui.Snackbar;
import com.straighttalk.ui.button.ButtonPlus;
import com.straighttalk.ui.edittext.CustomEditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Harsh on 8/6/2016.
 */
public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.etEmail)
    CustomEditText etEmail;
    @Bind(R.id.etPassword)
    CustomEditText etPassword;
    @Bind(R.id.btnLogin)
    ButtonPlus btnLogin;
    @Bind(R.id.etHclMember)
    TextView txtHclMember;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.txtForgotPassword)
    TextView txtForgotPassword;

    @OnClick(R.id.txtForgotPassword)
    void show() {
        startActivity(new Intent(this, ForgotPasswordActivity.class));
    }

    @OnClick(R.id.etHclMember)
    void alert() {
        new MaterialDialog.Builder(LoginActivity.this)
                .title("HCL Membership Id").inputType(InputType.TYPE_CLASS_TEXT)
                .input("Enter Your Membership Id", null, new MaterialDialog.InputCallback() {

                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        String data = input.toString();
                        txtHclMember.setText(data);
                    }
                }).typeface("Whitney-Semibold-Bas.otf", "Whitney-Semibold-Bas.otf").show();

    }

    @OnClick(R.id.btnLogin)
    void login() {

        if (etEmail.getText().toString().equals("")) {
            Snackbar.show(this, "Please Enter your Email");
            return;
        }

        if (etPassword.getText().toString().equals("")) {
            Snackbar.show(this, "Please enter Password");
            return;
        }

        if (!txtHclMember.getText().toString().equals("")) {
            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            ActivityCompat.finishAffinity(LoginActivity.this);
        } else {
            startActivity(new Intent(LoginActivity.this, DashboardActivityGuest.class));
            ActivityCompat.finishAffinity(LoginActivity.this);
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(CustomTitle.getTitle(this, "Login"));
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnLogin.setBackgroundResource(R.drawable.ripple_rounded);
        }

    }
}
