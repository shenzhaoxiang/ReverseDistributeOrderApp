package com.ctsig.rdo.ui.login.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ctsig.rdo.R;
import com.ctsig.rdo.base.BaseActivity;
import com.ctsig.rdo.ui.main.activity.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void getBundleExtras(Bundle parms) {

    }

    @Override
    public void initViewsAndEvents(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }


    @OnClick(R.id.btn_login)
    public void onClick() {
        readyGoThenKill(MainActivity.class);
    }
}
