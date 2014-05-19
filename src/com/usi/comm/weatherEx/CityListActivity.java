package com.usi.comm.weatherEx;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weatherEx.R;


public class CityListActivity extends ListActivity {
	GestureDetector mGesture ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city_list);
		setListAdapter(listAdapter);
		
		getListView().setOnItemClickListener(listViewClick);
		
		mGesture = new GestureDetector(this, gestureListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.cites, menu);
		return true;
	}

	BaseAdapter listAdapter = new BaseAdapter() {

		private String[] cites = new String[] { "合肥", "上海", "南京", "东京" };

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (null == convertView) {
				convertView = LayoutInflater.from(CityListActivity.this).inflate(
						R.layout.city, parent, false);
			}
			((TextView) convertView.findViewById(R.id.txt_city_name))
					.setText(cites[position]);

			int resId = R.drawable.bg_l_sunny;
			switch (position) {
			case 0:
				resId = R.drawable.bg_l_sunny;
				break;
			case 1:
				resId = R.drawable.bg_l_snow;
				break;
			case 2:
				resId = R.drawable.bg_l_rain;
				break;
			case 3:
				resId = R.drawable.bg_l_overcast;
				break;

			default:
				break;
			}
			
			convertView.findViewById(R.id.city_container).setBackgroundResource(resId);
			convertView.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					return mGesture.onTouchEvent(event);
				}
			});
			return convertView;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return cites[position];
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return cites.length;
		}
	};
	
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.slide_down_in, R.anim.slide_down_out);
	}
	
	private OnItemClickListener listViewClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
			
			Intent t = new Intent();
			t.putExtra("POS", position);
			CityListActivity.this.setResult(RESULT_OK, t);
			CityListActivity.this.finish();
			overridePendingTransition(R.anim.slide_down_in, R.anim.slide_down_out);
		}
	};
	

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return this.mGesture.onTouchEvent(event);
	};
	
	private OnGestureListener gestureListener = new OnGestureListener(){

		@Override
		public boolean onDown(MotionEvent e) {
			Log.d("onDown","onDown");
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			Log.d("onShowPress","onShowPress");
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			Log.d("onSingleTapUp","onSingleTapUp");
			return false;
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			Log.d("onScroll","onScroll");
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			Log.d("onLongPress","onLongPress");

			
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			Log.d("onFling","onFling");
			return false;
		}
		
	};
}
