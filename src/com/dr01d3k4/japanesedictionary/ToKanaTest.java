package com.dr01d3k4.japanesedictionary;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dr01d3k4.japanesedictionary.util.KanaType;
import com.dr01d3k4.japanesedictionary.util.RomajiToKana;


public class ToKanaTest extends Activity {
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_romanization_test);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// getActionBar().setTitle(R.string.title_activity_to_kana_test);
		
		final EditText toRomanizeEditText = (EditText) findViewById(R.id.etToRomanizeText);
		toRomanizeEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(final Editable s) {
				convertKanaToRomaji();
			}
			
			
			@Override
			public void beforeTextChanged(final CharSequence s, final int start, final int before, final int count) {}
			
			
			@Override
			public void onTextChanged(final CharSequence arg0, final int start, final int before, final int count) {}
		});
		toRomanizeEditText.setHint(R.string.to_kana_hint);
		toRomanizeEditText.setFocusableInTouchMode(true);
		toRomanizeEditText.requestFocus();
	}
	
	
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(this);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	private void convertKanaToRomaji() {
		final EditText toRomanizeEditText = (EditText) findViewById(R.id.etToRomanizeText);
		final TextView romanizedDisplay = (TextView) findViewById(R.id.tvDisplayRomanized);
		
		romanizedDisplay.setText(RomajiToKana.romajiToKana(toRomanizeEditText.getText().toString(), KanaType.HIRAGANA));
	}
	
	
	public void onEnterClicked(final View view) {
		convertKanaToRomaji();
	}
}
