package com.dr01d3k4.japanesedictionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.dr01d3k4.japanesedictionary.kanachart.KanaChartActivity;
import com.dr01d3k4.japanesedictionary.searchresult.SearchResultListActivity;


public class MainActivity extends Activity {
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText searchText = (EditText) findViewById(R.id.etSearchText);
		searchText.setFocusableInTouchMode(true);
		searchText.requestFocus();
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void onSearchClicked(final View view) {
		startActivity(new Intent(this, SearchResultListActivity.class));
	}
	
	
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_kana_chart:
				startActivity(new Intent(this, KanaChartActivity.class));
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	
	public void onTestRomanizationClicked(final View view) {
		startActivity(new Intent(this, RomanizationTest.class));
	}
}
