package com.dr01d3k4.japanesedictionary.searchresult;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dr01d3k4.japanesedictionary.R;
import com.dr01d3k4.japanesedictionary.dummy.DummyContent;


public class WordDetailFragment extends Fragment {
	public static final String ARG_ITEM_ID = "item_id";
	private DummyContent.DummyItem mItem;
	
	
	public WordDetailFragment() {}
	
	
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (getArguments().containsKey(ARG_ITEM_ID)) {
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
	}
	
	
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_word_detail, container, false);
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.tvSearchResultDetail)).setText(mItem.content);
		}
		return rootView;
	}
}
