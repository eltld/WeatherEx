package com.usi.comm.weatherEx;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weatherEx.R;


public class CitesActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city_list);
		setListAdapter(listAdapter);
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
				convertView = LayoutInflater.from(CitesActivity.this).inflate(
						R.layout.city, parent, false);
			}
			((TextView) convertView.findViewById(R.id.txt_city_name))
					.setText(cites[position]);

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
}
