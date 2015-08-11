package com.example.viewpager;


import java.util.ArrayList;

import com.example.scrolldemo.R;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class ViewPagerActivity extends Activity { 

	private ViewPager mViewPager;  
    private ViewPagerAdapter mAdapter;  
    private ActionBar mTabBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        
        mViewPager = (ViewPager) findViewById(R.id.viewpager);  
        mAdapter = new ViewPagerAdapter(this, mViewPager);  
        mTabBar = getActionBar();
        
        mAdapter.addTab(mTabBar.newTab().setIcon(R.drawable.tab_icon_qworld),  
                FirstFragment.class, null);  
        mAdapter.addTab(mTabBar.newTab().setIcon(R.drawable.tab_icon_group),  
                SecondFragment.class, null);  
        mAdapter.addTab(mTabBar.newTab().setIcon(R.drawable.tab_icon_friends),  
                ThreeFragment.class, null);  
        mAdapter.addTab(mTabBar.newTab().setIcon(R.drawable.tab_icon_recent),  
                FourFragment.class, null);  
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	} 
	
    private static class ViewPagerAdapter extends FragmentPagerAdapter 
    				implements TabListener, OnPageChangeListener {
		private Context mContext;  
        private ActionBar mActionBar = null;  
        private ViewPager mViewPager = null;  
        private ArrayList<TabInfo> mTabList = new ArrayList<TabInfo>();  
        
		public ViewPagerAdapter(Activity activity, ViewPager viewPager) {
			super(activity.getFragmentManager());
			
			mContext = activity;
			mActionBar = activity.getActionBar();  
			
			 mActionBar.setDisplayOptions(mActionBar.getDisplayOptions()  
	                    ^ ActionBar.DISPLAY_SHOW_HOME  
	                    ^ ActionBar.DISPLAY_SHOW_TITLE, ActionBar.DISPLAY_SHOW_HOME  
	                    | ActionBar.DISPLAY_SHOW_TITLE);  
            mActionBar.setDisplayShowHomeEnabled(false);  
            mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);  
            mViewPager = viewPager;  
            mViewPager.setAdapter(this);  
            mViewPager.setOnPageChangeListener(this);
		}

		
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			mActionBar.setSelectedNavigationItem(position);
		}



		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			Object tag = tab.getTag();  
            for (int i = 0; i < mTabList.size(); i++) {  
                if (mTabList.get(i) == tag) {  
                    mViewPager.setCurrentItem(i);  
                }  
            } 
		}



		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			TabInfo tab = mTabList.get(position);  
            if (tab.fragment == null) {  
                tab.fragment = Fragment.instantiate(mContext,  
                        tab.clazz.getName(), tab.bundle);  
            }  
            return tab.fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mTabList.size();
		}
    	
		public void addTab(Tab tab, Class<?> clazz, Bundle bundle) {  
            TabInfo tabInfo = new TabInfo(clazz, bundle);  
            tab.setTag(tabInfo);  
            tab.setTabListener(this);  
            mTabList.add(tabInfo);  
            mActionBar.addTab(tab);  
            notifyDataSetChanged();  
        }  
  
        private static final class TabInfo {  
            private final Class<?> clazz;  
            private final Bundle bundle;  
            Fragment fragment;  
  
            TabInfo(Class<?> clazz, Bundle bundle) {  
                this.clazz = clazz;  
                this.bundle = bundle;  
            }  
        } 
    }
}