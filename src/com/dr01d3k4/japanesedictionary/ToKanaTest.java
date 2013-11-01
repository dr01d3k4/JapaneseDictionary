package com.dr01d3k4.japanesedictionary;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.dr01d3k4.japanesedictionary.util.KanaType;
import com.dr01d3k4.japanesedictionary.util.RomajiToKana;


public class ToKanaTest extends Activity {
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_to_kana_test);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		final EditText toKanaEditText = (EditText) findViewById(R.id.etToKanaText);
		toKanaEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(final Editable s) {
				convertRomajiToKana();
			}
			
			
			@Override
			public void beforeTextChanged(final CharSequence s, final int start, final int before, final int count) {}
			
			
			@Override
			public void onTextChanged(final CharSequence arg0, final int start, final int before, final int count) {}
		});
		toKanaEditText.setFocusableInTouchMode(true);
		toKanaEditText.requestFocus();
		
		final Switch kanaSwitch = (Switch) findViewById(R.id.swHiraganaOrKatakana);
		kanaSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				convertRomajiToKana();
			}
		});
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
	
	
	private void convertRomajiToKana() {
		final EditText toKanaEditText = (EditText) findViewById(R.id.etToKanaText);
		final TextView kanaDisplay = (TextView) findViewById(R.id.tvDisplayKana);
		final Switch kanaSwitch = (Switch) findViewById(R.id.swHiraganaOrKatakana);
		final KanaType kanaType = (kanaSwitch.isChecked()) ? KanaType.HIRAGANA : KanaType.KATAKANA;
		
		kanaDisplay.setText(RomajiToKana.romajiToKana(toKanaEditText.getText().toString(), kanaType));
	}
	
	
	public void onEnterClicked(final View view) {
		convertRomajiToKana();
	}
}
