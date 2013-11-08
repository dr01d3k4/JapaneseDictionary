package com.dr01d3k4.japanesedictionary.worddetail;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dr01d3k4.japanesedictionary.R;


public class WordDetailFragment extends Fragment {
	public static final String ARG_ITEM_ID = "item_id";
	
	
	// private DummyContent.DummyItem mItem;
	
	public WordDetailFragment() {}
	
	
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
			// mItem = DummyContent.ITEMS.get(0);
		}
	}
	
	
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_word_detail, container, false);
		// if (mItem != null) {
		// 	((TextView) rootView.findViewById(R.id.tvWordDetail)).setText(mItem.content);
		// }
		return rootView;
	}
}
