package com.usi.comm.weatherEx.Fragment;

import it.sephiroth.android.library.widget.HListView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.city_fragment, container,
				false);
		HListView hlv = (HListView) rootView
				.findViewById(R.id.hlv_12h);
		hlv.setAdapter(new HourInfoAdapter(getActivity()));
		
		
		ListView dayList = (ListView) rootView.findViewById(R.id.weather_day);
		dayList.setAdapter(new DayInfoAdapter(getActivity()));
		
		return rootView;
	}
}
