package com.dr01d3k4.japanesedictionary.worddetail;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dr01d3k4.japanesedictionary.Word;


public class WordOverviewListFragment extends ListFragment {
	private static final String STATE_ACTIVATED_POSITION = "activated_position";
	private Callbacks mCallbacks = sDummyCallbacks;
	private int mActivatedPosition = ListView.INVALID_POSITION;
	
	private Word words[];
	
	
	public interface Callbacks {
		public void onItemSelected(Word word);
	}
	
	private static Callbacks sDummyCallbacks = new Callbacks() {
		@Override
		public void onItemSelected(final Word word) {}
	};
	
	
	public WordOverviewListFragment() {}
	
	
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Parcelable[] parcelables = getActivity().getIntent().getExtras().getParcelableArray(
			WordOverviewListActivity.ARG_WORD_LIST);
		words = new Word[parcelables.length];
		for (int i = 0; i < parcelables.length; i++) {
			words[i] = (Word) parcelables[i];
		}
		setListAdapter(new WordOverviewArrayAdapter(getActivity(), words));
	}
	
	
	@Override
	public void onViewCreated(final View view, final Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		if ((savedInstanceState != null) && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
			setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
		}
	}
	
	
	@Override
	public void onAttach(final Activity activity) {
		super.onAttach(activity);
		
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("Activity must implement fragment's callbacks.");
		}
		
		mCallbacks = (Callbacks) activity;
	}
	
	
	@Override
	public void onDetach() {
		super.onDetach();
		
		mCallbacks = sDummyCallbacks;
	}
	
	
	@Override
	public void onListItemClick(final ListView listView, final View view, final int position, final long id) {
		super.onListItemClick(listView, view, position, id);
		Log.d("Selected", "" + position);
		mCallbacks.onItemSelected(words[position]);
	}
	
	
	@Override
	public void onSaveInstanceState(final Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mActivatedPosition != AdapterView.INVALID_POSITION) {
			outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
		}
	}
	
	
	public void setActivateOnItemClick(final boolean activateOnItemClick) {
		getListView()
			.setChoiceMode(activateOnItemClick ? AbsListView.CHOICE_MODE_SINGLE : AbsListView.CHOICE_MODE_NONE);
	}
	
	
	private void setActivatedPosition(final int position) {
		if (position == AdapterView.INVALID_POSITION) {
			getListView().setItemChecked(mActivatedPosition, false);
		} else {
			getListView().setItemChecked(position, true);
		}
		
		mActivatedPosition = position;
	}
}
