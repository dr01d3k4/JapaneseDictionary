package com.dr01d3k4.japanesedictionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.dr01d3k4.japanesedictionary.kanachart.KanaChartActivity;


public class MainActivity extends Activity {
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText searchText = (EditText) findViewById(R.id.etSearchText);
		searchText.setFocusableInTouchMode(true);
		searchText.requestFocus();
		
		searchText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if ((actionId & EditorInfo.IME_MASK_ACTION) == EditorInfo.IME_ACTION_DONE) {
					performSearch();
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void performSearch() {
		final EditText searchTextView = (EditText) findViewById(R.id.etSearchText);
		final String searchText = searchTextView.getText().toString();
		
		final Intent intent = new Intent(this, SearchingActivity.class);
		final Bundle extras = new Bundle();
		extras.putString(SearchingActivity.ARG_SEARCH_TERM, searchText);
		intent.putExtras(extras);
		startActivity(intent);
		// startActivity(new Intent(this, SearchResultListActivity.class));
	}
	
	
	public void onSearchClicked(final View view) {
		performSearch();
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
	
	
	public void onTestToKanaClicked(final View view) {
		startActivity(new Intent(this, ToKanaTest.class));
	}
}
