package com.dr01d3k4.japanesedictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;


public final class SearchDictionary {
	private static final Pattern wordPattern = Pattern
		.compile("^(.+?) (\\Q[\\E(.+?)\\Q]\\E )?/(.+?)/(EntL[0-9]{7}X?)/*$");
	
	
	public static Word[] searchDictionary(final Context context, final String searchTerm) {
		if (searchTerm.equals("")) {
			return new Word[] { };
		}
		final ArrayList<Word> words = new ArrayList<Word>();
		final AssetManager assetManager = context.getAssets();
		InputStream inputStream;
		BufferedReader bufferedReader;
		try {
			inputStream = assetManager.open("edict2");
			Log.d("Loaded", "Loaded edict2");
			
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = bufferedReader.readLine()) != null) {
				if (inputLine.contains(searchTerm)) {
					final Matcher matcher = SearchDictionary.wordPattern.matcher(inputLine);
					String kanji = "", kana = "", english = "", id = "";
					if (matcher.find()) {
						Log.d("Matches", inputLine);
						// for (int i = 0; i < matcher.groupCount(); i++) {
						// 	Log.d("" + i, "\t" + matcher.group(i));
						// }
						kanji = matcher.group(1);
						kana = matcher.group(3);
						english = matcher.group(4);
						id = matcher.group(5);
					} else {
						Log.d("No match", inputLine);
					}
					kanji.replace(";", ", ");
					english.replace("/", ", ");
					if (kana == null) {
						kana = "";
					} else {
						kana.replace(";", ", ");
					}
					if (!kanji.equals("") && !kana.equals("") && !english.equals("")) {
						words.add(new Word(kanji, kana, english, id));
					}
					// words.add(new Word(inputLine, "", "", ""));
				}
			}
			bufferedReader.close();
			inputStream.close();
			return words.toArray(new Word[words.size()]);
		} catch (final IOException e) {
			return new Word[] { };
		}
	}
}