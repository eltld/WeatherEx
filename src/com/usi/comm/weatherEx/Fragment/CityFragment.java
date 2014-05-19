package com.usi.comm.weatherEx.Fragment;

import it.sephiroth.android.library.widget.HListView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.weatherEx.R;
import com.usi.comm.weatherEx.adapter.DayInfoAdapter;
import com.usi.comm.weatherEx.adapter.HourInfoAdapter;

public class CityFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public CityFragment() {
	}

	View mConatiner = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.city_fragment, container,
				false);
		mConatiner = rootView.findViewById(R.id.city_fg_container);

		int resId = R.drawable.bg_default;
		switch (getArguments().getInt(ARG_SECTION_NUMBER) + 1) {
		case 1:
			resId = R.drawable.bg_sunny;
			break;
		case 2:
			resId = R.drawable.bg_snow;
			break;
		case 3:
			resId = R.drawable.bg_rain;
			break;
		case 4:
			resId = R.drawable.bg_overcast;
			break;
		default:
			break;
		}

		mConatiner.setBackgroundResource(resId);

		((TextView) rootView.findViewById(R.id.txt_city))
				.setText(getArguments().getString("CITY"));

		HListView hlv = (HListView) rootView.findViewById(R.id.hlv_12h);
		hlv.setAdapter(new HourInfoAdapter(getActivity()));

		ListView dayList = (ListView) rootView.findViewById(R.id.weather_day);
		dayList.setAdapter(new DayInfoAdapter(getActivity()));

		dayList.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_MOVE) {
					return true;
				}
				return false;
			}
		});

		return rootView;
	}

	public void setBG() {
		if (null == mConatiner) {
//			mConatiner = getView().findViewById(R.id.city_fg_container);
		}
		if (null == mConatiner) {
			return;
		}
		mConatiner.setBackgroundResource(android.R.color.transparent);
	}
}
