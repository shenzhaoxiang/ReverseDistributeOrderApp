package com.ctsig.rdo.ui.main.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ctsig.rdo.R;
import com.ctsig.rdo.base.BaseFragment;
import com.ctsig.rdo.ui.login.activity.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-05-27 17:20
 */
public class MeFragment extends BaseFragment {
    @BindView(R.id.btn_logout)
    Button btnLogout;

    @Override
    public int bindLayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void initViews(View view, Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }


    @OnClick(R.id.btn_logout)
    public void onClick() {
        Intent it = new Intent() ;
        it.setClass(getActivity(), LoginActivity.class) ;
        startActivity(it);
        getActivity().finish();
    }
}
