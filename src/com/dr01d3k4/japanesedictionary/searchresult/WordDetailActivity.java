package com.dr01d3k4.japanesedictionary.searchresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.dr01d3k4.japanesedictionary.R;


public class WordDetailActivity extends FragmentActivity {
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_detail);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		if (savedInstanceState == null) {
			final Bundle arguments = new Bundle();
			arguments.putString(WordDetailFragment.ARG_ITEM_ID,
				getIntent().getStringExtra(WordDetailFragment.ARG_ITEM_ID));
			final WordDetailFragment fragment = new WordDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().add(R.id.flSearchResultDetailContainer, fragment).commit();
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
				NavUtils.navigateUpTo(this, new Intent(this, SearchResultListActivity.class));
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
