package com.dr01d3k4.japanesedictionary.worddetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.dr01d3k4.japanesedictionary.R;
import com.dr01d3k4.japanesedictionary.Word;
import com.dr01d3k4.japanesedictionary.kanachart.KanaChartActivity;


public class WordOverviewListActivity extends FragmentActivity implements WordOverviewListFragment.Callbacks {
	public static final String ARG_WORD_LIST = "word_list";
	public static final String ARG_WORD_SELECTED = "word_selected";
	public static final String ARG_TITLE = "title";
	private boolean mTwoPane;
	
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_overview_list);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Bundle extras = getIntent().getExtras();
		if (extras.getString(ARG_TITLE) != null) {
			getActionBar().setTitle(extras.getString(ARG_TITLE));
		}
		
		if (findViewById(R.id.flWordDetailContainer) != null) {
			mTwoPane = true;
			((WordOverviewListFragment) getSupportFragmentManager().findFragmentById(R.id.fgWordOverviewList))
				.setActivateOnItemClick(true);
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(this);
				return true;
			case R.id.action_kana_chart:
				startActivity(new Intent(this, KanaChartActivity.class));
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	
	@Override
	public void onItemSelected(final Word word) {
		Bundle arguments = new Bundle();
		arguments.putParcelable(ARG_WORD_SELECTED, word);
		
		if (mTwoPane) {
			WordDetailFragment fragment = new WordDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().replace(R.id.flWordDetailContainer, fragment).commit();
			
		} else {
			Intent detailIntent = new Intent(this, WordDetailActivity.class);
			detailIntent.putExtras(arguments);
			startActivity(detailIntent);
		}
	}
}
