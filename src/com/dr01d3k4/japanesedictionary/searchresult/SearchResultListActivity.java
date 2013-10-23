package com.dr01d3k4.japanesedictionary.searchresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.dr01d3k4.japanesedictionary.R;
import com.dr01d3k4.japanesedictionary.Word;
import com.dr01d3k4.japanesedictionary.kanachart.KanaChartActivity;


public class SearchResultListActivity extends FragmentActivity implements SearchResultListFragment.Callbacks {
	private boolean mTwoPane;
	
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchresult_list);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		if (findViewById(R.id.flSearchResultDetailContainer) != null) {
			mTwoPane = true;
			((SearchResultListFragment) getSupportFragmentManager().findFragmentById(R.id.fgSearchResultList))
				.setActivateOnItemClick(true);
		}
		
		// TODO: Pass words to search to fragment
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
		// TODO: Implement onItemSelected
		if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			/* final Bundle arguments = new Bundle();
			 * arguments.putString(WordDetailFragment.ARG_ITEM_ID, id);
			 * final WordDetailFragment fragment = new WordDetailFragment();
			 * fragment.setArguments(arguments);
			 * getSupportFragmentManager().beginTransaction().replace(R.id.searchresult_detail_container, fragment)
			 * .commit(); */
			
		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			/* final Intent detailIntent = new Intent(this, WordDetailActivity.class);
			 * detailIntent.putExtra(WordDetailFragment.ARG_ITEM_ID, id);
			 * startActivity(detailIntent); */
		}
	}
}
