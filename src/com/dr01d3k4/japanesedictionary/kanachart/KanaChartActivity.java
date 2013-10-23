package com.dr01d3k4.japanesedictionary.kanachart;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.dr01d3k4.japanesedictionary.R;


public class KanaChartActivity extends FragmentActivity implements ActionBar.OnNavigationListener {
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	
	private ChartType chartType = ChartType.HIRAGANA;
	
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kana_chart);
		
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		actionBar.setListNavigationCallbacks(new ArrayAdapter<String>(actionBar.getThemedContext(),
			android.R.layout.simple_list_item_1, android.R.id.text1, getResources().getStringArray(R.array.kana_type)),
			this);
	}
	
	
	@Override
	public void onRestoreInstanceState(final Bundle savedInstanceState) {
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			final int selectedItem = savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM);
			chartType = ChartType.values()[selectedItem];
			getActionBar().setSelectedNavigationItem(selectedItem);
		}
	}
	
	
	@Override
	public void onSaveInstanceState(final Bundle outState) {
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar().getSelectedNavigationIndex());
	}
	
	
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(this);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	@Override
	public boolean onNavigationItemSelected(final int position, final long id) {
		chartType = ChartType.values()[position];
		
		final KanaChartFragment kanaChart = new KanaChartFragment();
		final Bundle arguments = new Bundle();
		arguments.putInt(KanaChartFragment.ARG_CHART_TYPE, chartType.ordinal());
		kanaChart.setArguments(arguments);
		getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, kanaChart).commit();
		
		return true;
	}
}
