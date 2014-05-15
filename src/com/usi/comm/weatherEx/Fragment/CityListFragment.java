package com.usi.comm.weatherEx.Fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weatherEx.R;

public class CityListFragment extends ListFragment {



	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(listAdapter);
		
	}

	BaseAdapter listAdapter = new BaseAdapter() {

		private String[] cites = new String[] { "合肥", "上海", "南京", "东京" };

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (null == convertView) {
				convertView = LayoutInflater.from(getActivity()).inflate(
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
