package com.dr01d3k4.japanesedictionary.worddetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.dr01d3k4.japanesedictionary.R;
import com.dr01d3k4.japanesedictionary.Word;


public class WordDetailActivity extends Activity {
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_detail);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Word word = (Word) getIntent().getExtras().getParcelable(WordOverviewListActivity.ARG_WORD_SELECTED);
		getActionBar().setTitle(word.getKanji());
		
		if (savedInstanceState == null) {
			// final Bundle arguments = new Bundle();
			// arguments.putString(WordDetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(
			// WordDetailFragment.ARG_ITEM_ID));
			// final WordDetailFragment fragment = new WordDetailFragment();
			// fragment.setArguments(arguments);
			// getSupportFragmentManager().beginTransaction().add(R.id.flWordDetailContainer, fragment).commit();
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.word_detail_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				NavUtils.navigateUpTo(this, new Intent(this, WordOverviewListActivity.class));
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
