package com.dr01d3k4.japanesedictionary.kanachart;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

import com.dr01d3k4.japanesedictionary.R;
import com.dr01d3k4.japanesedictionary.util.KanaType;


public class KanaChartActivity extends FragmentActivity {
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	
	private KanaType chartType = KanaType.HIRAGANA;
	
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_kana_chart);
		
		changeChart();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.kana_chart, menu);
		Switch kanaToggle = (Switch) menu.findItem(R.id.action_kana_toggle).getActionView();
		kanaToggle.setChecked(chartType == KanaType.HIRAGANA);
		kanaToggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					chartType = KanaType.HIRAGANA;
				} else {
					chartType = KanaType.KATAKANA;
				}
				changeChart();
			}
			
		});
		
		return super.onCreateOptionsMenu(menu);
	}
	
	
	private void changeChart() {
		KanaChartFragment kanaChart = new KanaChartFragment();
		Bundle arguments = new Bundle();
		arguments.putInt(KanaChartFragment.ARG_KANA_TYPE, chartType.ordinal());
		kanaChart.setArguments(arguments);
		getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, kanaChart).commit();
	}
	
	
	@Override
	public void onRestoreInstanceState(final Bundle savedInstanceState) {
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			chartType = KanaType.values()[savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM)];
			changeChart();
		}
	}
	
	
	@Override
	public void onSaveInstanceState(final Bundle outState) {
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, chartType.ordinal());
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
}