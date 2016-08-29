package com.ctsig.rdo.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import icepick.Icepick;
import nucleus.presenter.Presenter;
import nucleus.view.NucleusAppCompatActivity;

/**
 * @des: Activity基类
 * @author: shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016-05-19 16:24
 */
public abstract class BaseActivity <P extends Presenter> extends NucleusAppCompatActivity<P> implements IBaseActivity {
    protected final String TAG = getClass().getSimpleName();
//    @Nullable
//    @BindView(R.id.toolbar)
//    Toolbar toolbarView;
//
//    @Nullable
//    @BindView(R.id.toolbar_title)
//    public TextView toolbarTitleView;

    /**当前Activity渲染的视图View**/
    private View mContextView = null;
    /**当前Activity的弱引用，防止内存泄露**/
    private WeakReference<Activity> context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        injectorPresenter();
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 屏幕方向固定
        if(getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        //将当前Activity压入栈
        context = new WeakReference<Activity>(this);

        mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
        setContentView(mContextView);

//        injectModule(((App)getApplication()).getAppComponent());

        // 注解绑定
        ButterKnife.bind(this);

        setPresenterFactory(getPresenterFactory());

//        initializeToolbar();

        //初始化参数
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

        }else{
            bundle = new Bundle();
        }
        getBundleExtras(bundle);

//        // 开启沉浸式状态栏
//        StatusBarCompat.compat(this);

        //初始化控件
        initViewsAndEvents(mContextView);

        //业务操作
        doBusiness(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (!isChild()) {
            onTitleChanged(getTitleName(), getTitleColor());
        }
    }


//    @Override
//    protected void onTitleChanged(CharSequence title, int color) {
//        super.onTitleChanged(title, color);
//        if (toolbarTitleView == null) {
//            return;
//        }
//        toolbarTitleView.setText(title);
//    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

//    protected void initializeToolbar() {
//        if (toolbarView == null) {
//            return;
//        }
//        setSupportActionBar(toolbarView);
//        if (toolbarTitleView != null) {
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//        }
//        if (!TextUtils.isEmpty(NavUtils.getParentActivityName(this))) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_back);
//            toolbarView.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finish();
//                }
//            });
//        }
//    }


    @Override
    public Context getContext() {
        return this;
    }

    protected CharSequence getTitleName() {
        return getTitle();
    }

//    protected AppComponent getAppComponent() {
//        return ((App) getApplication()).getAppComponent();
//    }
//
//    protected ApiComponent getApiComponent() {
//        return ((App) getApplication()).getApiComponent();
//    }
//
//    protected ActivityModule getActivityModule() {
//        return new ActivityModule(this);
//    }

    protected void injectorPresenter() {}

    @CallSuper
    @Override
    public void onDestroy() {
        super.onDestroy();
//        RefWatcher refWatcher = App.getRefWatcher();
//        refWatcher.watch(this);
    }


    /**********************************************************************************************/
    /*****************                   Activity跳转                   ***************************/
    /**********************************************************************************************/
    /**
     * startActivity
     *
     * @param clazz
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
    /**********************************************************************************************/
    /*****************                   Activity跳转                   ***************************/
    /**********************************************************************************************/

}
