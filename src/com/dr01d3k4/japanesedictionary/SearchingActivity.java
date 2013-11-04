package com.dr01d3k4.japanesedictionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.dr01d3k4.japanesedictionary.worddetail.WordOverviewListActivity;


public class SearchingActivity extends Activity {
	public static final String ARG_SEARCH_TERM = "search_term";
	
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searching);

		final Bundle searchArguments = getIntent().getExtras();
		final String searchTerm = searchArguments.getString(SearchingActivity.ARG_SEARCH_TERM);
		
		getActionBar().setTitle("Searching for \"" + searchTerm + "\"...");
		
		(new Thread() {
			@Override
			public void run() {
				try {
					sleep(2000);
				} catch (final InterruptedException e) {
					e.printStackTrace();
				} finally {
					final Word[] words = SearchDictionary.searchDictionary(searchTerm);
					final Bundle wordBundle = new Bundle();
					wordBundle.putParcelableArray(WordOverviewListActivity.ARG_WORD_LIST, words);
					
					final Intent showWords = new Intent(SearchingActivity.this, WordOverviewListActivity.class);
					showWords.putExtras(wordBundle);
					
					startActivity(showWords);
				}
			}
		}).start();
		
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
}
