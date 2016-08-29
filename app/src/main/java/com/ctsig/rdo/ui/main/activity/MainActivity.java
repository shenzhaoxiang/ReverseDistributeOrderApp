package com.ctsig.rdo.ui.main.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctsig.rdo.R;
import com.ctsig.rdo.base.BaseActivity;
import com.ctsig.rdo.ui.main.fragment.RecommendedFragment;
import com.ctsig.rdo.ui.main.fragment.TopicsFragment;
import com.ctsig.rdo.ui.main.fragment.WikiFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.viewpagertab)
    SmartTabLayout viewpagerTab;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void getBundleExtras(Bundle parms) {
    }

    @Override
    public void initViewsAndEvents(View view) {
        setupTabView();
    }

    @Override
    public void doBusiness(Context mContext) {

    }


    protected void setupTabView() {
        final LayoutInflater inflater = LayoutInflater.from(this);
        final int[] tabIcons = {R.drawable.ic_recommended, R.drawable.ic_topics, R.drawable.ic_wiki};
        final int[] tabText = {R.string.module_order_box, R.string.module_search, R.string.module_me};
        FragmentPagerItems pages = FragmentPagerItems.with(this)
                .add(R.string.module_order_box, RecommendedFragment.class)
                .add(R.string.module_search, TopicsFragment.class)
                .add(R.string.module_me, WikiFragment.class)
                //.add(R.string.me, MeFragment.class)
                .create();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                pages);

        viewPager.setOffscreenPageLimit(pages.size());
        viewPager.setAdapter(adapter);
        viewpagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter pagerAdapter) {
                View view = inflater.inflate(R.layout.custom_tab_icon, container, false);
                ImageView iconView = (ImageView) view.findViewById(R.id.iv_icon);
                iconView.setBackgroundResource(tabIcons[position % tabIcons.length]);
                TextView textView = (TextView) view.findViewById(R.id.tv_tab_text);
                textView.setText(tabText[position % tabText.length]);
                return view;
            }
        });
        viewpagerTab.setViewPager(viewPager);
    }
}
