package com.ctsig.rdo.ui.login.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.ctsig.rdo.R;
import com.ctsig.rdo.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void getBundleExtras(Bundle parms) {

    }

    @Override
    public void initViewsAndEvents(View view) {
        new Handler().postDelayed(new Runnable(){

            public void run() {

                readyGoThenKill(LoginActivity.class);

            }

        }, 2000);
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
