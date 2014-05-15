package com.usi.comm.weatherEx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weatherEx.R;

public class HourInfoAdapter extends BaseAdapter {

	private Context mContext = null;

	private String[] hours = new String[] { "下午1时", "下午2时", "下午3时", "下午4时",
			"下午5时", "下午6时", "下午7时", "下午8时", "下午9时", "下午10时", "下午11时", "下午12时" };

	public HourInfoAdapter(Context c) {
		mContext = c;
	}

	@Override
	public int getCount() {
		return hours.length;
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
					R.layout.hour_info, parent, false);
		} else {
			// TODO customization
		}

		TextView txt_hour = (TextView) convertView.findViewById(R.id.txt_time);
		txt_hour.setText(getItem(position).toString());

		
		TextView txt_temperature = (TextView) convertView.findViewById(R.id.txt_h_temp);
		txt_temperature.setText("22°");
		return convertView;
	}

}
