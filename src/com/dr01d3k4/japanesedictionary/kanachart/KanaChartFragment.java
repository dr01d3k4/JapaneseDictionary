package com.dr01d3k4.japanesedictionary.kanachart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.dr01d3k4.japanesedictionary.R;
import com.dr01d3k4.japanesedictionary.util.KanaType;
import com.dr01d3k4.japanesedictionary.util.RomajiToKana;


public class KanaChartFragment extends Fragment {
	public static final String ARG_KANA_TYPE = "kana_type";
	
	private static final String[][] mainTable = { //
	{"a", "i", "u", "e", "o"}, //
		{"ka", "ki", "ku", "ke", "ko"}, //
		{"sa", "shi", "su", "se", "so"}, //
		{"ta", "chi", "tsu", "te", "to"}, //
		{"na", "ni", "nu", "ne", "no"}, //
		{"ha", "hi", "fu", "he", "ho"}, //
		{"ma", "mi", "mu", "me", "mo"}, //
		{"ya", "", "yu", "", "yo"}, //
		{"ra", "ri", "ru", "re", "ro"}, //
		{"wa", "wi", "", "we", "wo"}, //
		{"", "", "n"} //
	};
	
	private static final String[][] dakutenTable = { //
	{"ga", "gi", "gu", "ge", "go"}, //
		{"za", "ji", "zu", "ze", "zo"}, //
		{"da", "di", "dzu", "de", "do"}, // 
		{"ba", "bi", "bu", "be", "bo"},// 
		{"pa", "pi", "pu", "pe", "po"} //
	};
	private static final String[][] dakutenTableGaps = { //
	{""}, //
		{"ga", "gi", "gu", "ge", "go"}, //
		{"za", "ji", "zu", "ze", "zo"}, //
		{"da", "di", "dzu", "de", "do"}, // 
		{""}, //
		{"ba", "bi", "bu", "be", "bo"},// 
		{"pa", "pi", "pu", "pe", "po"} //
	};
	
	private static final String[][] yTable = { //
	{"kya", "kyu", "kyo"}, //
		{"sha", "shu", "sho"}, //
		{"cha", "chu", "cho"}, //
		{"nya", "nyu", "nyo"}, //
		{"hya", "hyu", "hyo"}, // 
		{"mya", "myu", "myo"}, //
		{"rya", "ryu", "ryo"} //
	};
	
	private static final String[][] yDakutenTable = { //
		{"gya", "gyu", "gyo"}, //
		{"ja", "ju", "jo"}, //
		{"dja", "dju", "djo"}, //
		{"bya", "byu", "byo"}, //
		{"pya", "pyu", "pyo"}, //
	};
	

	private static final String[][] yDakutenTableGaps = { //
		{"gya", "gyu", "gyo"}, //
		{"ja", "ju", "jo"}, //
		{"dja", "dju", "djo"}, //
		{""}, //
		{"bya", "byu", "byo"}, //
		{"pya", "pyu", "pyo"}, //
	};
	
	private TableRow.LayoutParams rowLayoutParams;
	
	
	public KanaChartFragment() {
		rowLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
			TableRow.LayoutParams.WRAP_CONTENT);
	}
	
	
	private void fillInTable(String tableName, String[][] table, KanaType kanaType, TableLayout tableLayout,
		LayoutInflater inflater, ViewGroup container) {
		TableRow titleRow = new TableRow(getActivity());
		titleRow.setLayoutParams(rowLayoutParams);
		TextView titleText = new TextView(getActivity());
		titleText.setText(tableName);
		titleText.setTextSize(32);
		titleText.setGravity(Gravity.CENTER);
		TableRow.LayoutParams titleLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
			TableRow.LayoutParams.WRAP_CONTENT);
		titleText.setLayoutParams(titleLayoutParams);
		titleLayoutParams.span = 5;
		titleRow.addView(titleText);
		tableLayout.addView(titleRow);
		
		for (int consonant = 0; consonant < table.length; consonant++) {
			TableRow row = new TableRow(getActivity());
			row.setLayoutParams(rowLayoutParams);
			for (int vowel = 0; vowel < table[consonant].length; vowel++) {
				View kanaItem = inflater.inflate(R.layout.kana_chart_item, container, false);
				kanaItem.setLayoutParams(rowLayoutParams);
				
				((TextView) kanaItem.findViewById(R.id.tvKanaChar)).setText(RomajiToKana.romajiToKana(
					table[consonant][vowel], kanaType));
				((TextView) kanaItem.findViewById(R.id.tvRomajiChar)).setText(table[consonant][vowel]);
				
				row.addView(kanaItem);
			}
			tableLayout.addView(row);
		}
	}
	
	
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		final KanaType kanaType = KanaType.values()[getArguments().getInt(ARG_KANA_TYPE)];
		final View rootView = inflater.inflate(R.layout.fragment_kana_chart, container, false);
		
		RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rlKanaChartLayout);
		String layoutType = (String) relativeLayout.getTag();
		
		TableLayout mainTableLayout = (TableLayout) rootView.findViewById(R.id.tlMainTable);
		fillInTable("Main", mainTable, kanaType, mainTableLayout, inflater, container);
		
		TableLayout dakutenTableLayout = (TableLayout) rootView.findViewById(R.id.tlDakutenTable);
		fillInTable("Dakuten", layoutType.equals("wide_portrait") ? dakutenTableGaps : dakutenTable, kanaType,
			dakutenTableLayout, inflater, container);
		
		TableLayout yTableLayout = (TableLayout) rootView.findViewById(R.id.tlYTable);
		fillInTable("Y Table", yTable, kanaType, yTableLayout, inflater, container);
		
		TableLayout yDakutenTableLayout = (TableLayout) rootView.findViewById(R.id.tlYDakutenTable);
		fillInTable("Y Dakuten", layoutType.equals("wide_portrait") ? yDakutenTableGaps : yDakutenTable, kanaType,
			yDakutenTableLayout, inflater, container);
		
		return rootView;
	}
}