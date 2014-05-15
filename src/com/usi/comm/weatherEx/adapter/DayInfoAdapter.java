package com.usi.comm.weatherEx.adapter;

import java.util.Calendar;
import java.util.Locale;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weatherEx.R;

public class DayInfoAdapter extends BaseAdapter {

	private Context mContext = null;

	private String[] hours = new String[] { "星期一", "星期二", "星期三", "星期四", "星期五",
			"星期六", "星期日" };

	public DayInfoAdapter(Context c) {
		mContext = c;
	}

	@Override
	public int getCount() {
		return hours.length - 4;
	}

	@Override
	public Object getItem(int position) {
		if (position > getCount() - 1) {
			return null;
		}
		return hours[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		

		if (null == convertView) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.day_info, parent, false);
		} else {
			// TODO customization
		}

		TextView txt_hour = (TextView) convertView.findViewById(R.id.txt_week);
		txt_hour.setText(getItem(position).toString());

		
		
		return convertView;
	}

}
