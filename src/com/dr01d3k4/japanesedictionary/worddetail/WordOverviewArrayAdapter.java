package com.dr01d3k4.japanesedictionary.worddetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dr01d3k4.japanesedictionary.R;
import com.dr01d3k4.japanesedictionary.Word;


public class WordOverviewArrayAdapter extends ArrayAdapter<Word> {
	private final Context context;
	private final Word[] words;
	private static final int layout = R.layout.word_overview;
	
	
	private static class ViewHolder {
		public TextView kanji, kana, english;
		public RatingBar learningState;
	}
	
	
	public WordOverviewArrayAdapter(final Context context, final Word[] words) {
		super(context, layout, words);
		this.context = context;
		this.words = words;
	}
	
	
	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		View rowView = convertView;
		if (rowView == null) {
			final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(layout, parent, false);
			
			final ViewHolder viewHolder = new ViewHolder();
			viewHolder.kanji = (TextView) rowView.findViewById(R.id.tvKanji);
			viewHolder.kana = (TextView) rowView.findViewById(R.id.tvKana);
			viewHolder.english = (TextView) rowView.findViewById(R.id.tvEnglish);
			viewHolder.learningState = (RatingBar) rowView.findViewById(R.id.rbLearningState);
			
			rowView.setTag(viewHolder);
		}
		
		final ViewHolder holder = (ViewHolder) rowView.getTag();
		final Word word = words[position];
		holder.kanji.setText(word.getKanji());
		holder.kana.setText(word.getKana());
		holder.english.setText(word.getEnglish());
		holder.learningState.setRating(word.getLearningState().getValue());
		//  holder.learningState.setText(word.getLearningState().toString());
		
		return rowView;
	}
}
