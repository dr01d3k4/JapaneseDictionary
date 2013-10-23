package com.dr01d3k4.japanesedictionary.kanachart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dr01d3k4.japanesedictionary.R;


public class KanaChartFragment extends Fragment {
	public static final String ARG_CHART_TYPE = "chart_type";
	
	
	public KanaChartFragment() {}
	
	
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		final ChartType chartType = ChartType.values()[getArguments().getInt(ARG_CHART_TYPE)];
		final String[] chartTitles = getActivity().getResources().getStringArray(R.array.kana_type);
		final String chartTitle = chartTitles[chartType.ordinal()];
		
		final View rootView = inflater.inflate(R.layout.fragment_kana_chart, container, false);
		final TextView dummyTextView = (TextView) rootView.findViewById(R.id.tvSectionLabel);
		dummyTextView.setText(chartTitle);
		return rootView;
	}
}