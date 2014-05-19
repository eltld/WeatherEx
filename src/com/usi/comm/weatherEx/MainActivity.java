package com.usi.comm.weatherEx;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.weatherEx.R;
import com.usi.comm.weatherEx.Fragment.CityFragment;
import com.usi.comm.weatherEx.adapter.SectionsPagerAdapter;

public class MainActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	Activity citesActivity;
	
	ViewGroup mContainer = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContainer = (ViewGroup) findViewById(R.id.container);
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		((ImageView) findViewById(R.id.img_cites))
				.setOnClickListener(cityListClick);

		mViewPager.setOnPageChangeListener(pageChangeListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static final int requestCode = 0xfe;
	private OnClickListener cityListClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent t = new Intent(MainActivity.this, CityListActivity.class);
			startActivityForResult(t, requestCode);
			overridePendingTransition(R.anim.slide_up_in, R.anim.slide_up_out);
		}
	};

	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		if(arg0 == requestCode && null != arg2) {
			int pos = arg2.getIntExtra("POS", -1);
			if(-1 != pos){
				mViewPager.setCurrentItem(pos);
			}
		}
	};
	
	private OnPageChangeListener pageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

}
