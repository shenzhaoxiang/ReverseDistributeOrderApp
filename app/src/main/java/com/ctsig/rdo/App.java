package com.ctsig.rdo;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-22 14:20
 */
public class App extends Application {
    private static RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void init(){
        // 内存泄漏检测工具
        refWatcher = LeakCanary.install(this);
        // 调试模式
        ButterKnife.setDebug(BuildConfig.DEBUG);
        // 浏览器调试
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
//        initializeInjector();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }
}
