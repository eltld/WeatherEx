package com.usi.comm.weatherEx;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.weatherEx.R;
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

	
	Fragment citesList ;
	
	View citesView;
	View bottom;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        
        ((ImageView)findViewById(R.id.img_cites)).setOnClickListener(cityListClick);

        citesView = findViewById(R.id.fg_container);
        citesList = getSupportFragmentManager().findFragmentById(R.id.cityListFragment);
        
        bottom = findViewById(R.id.bottom);

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private OnClickListener cityListClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			mViewPager.setVisibility(View.GONE);
			bottom.setVisibility(View.GONE);
//			citesView.setAnimation(new TranslateAnimation(0, 400, 0, 600));
//			citesView.startAnimation(new TranslateAnimation(0, 400, 0, 600));
			citesView.setVisibility(View.VISIBLE);
			
			
			
		}
	};

}
