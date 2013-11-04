package com.dr01d3k4.japanesedictionary;

import java.util.Random;

import android.os.Parcel;
import android.os.Parcelable;


public final class Word implements Parcelable {
	// private final int lineInDictionary;
	//
	// Form of dictionary:
	// KANJI-1;KANJI-2 [KANA-1;KANA-2]/(general-information) gloss/gloss/.../EntLnnnnnnnX/
	// The EntLnnnnnnn is the UID for the entry. May end with X if sound file on JapanesePod101.com
	//
	// TODO: Finish this regex
	// In general information section, (1), (2) etc may be used to show multiple senses
	// [kanji]-(;[kanji]-)* *
	// \[[kana]-(;[kana])*\] */
	// (( *\([general_information]\))*( *[english]+)+)+ */
	//  *EntL[0-9]{8}X? */
	
	// Kanji and kana = Special unicode
	// General information = Either (adj-i)|(adj-na)|(adj-no)|...|(vs-c)|(vs-i)|(vs-s)|(vt)
	//						Or [A-Za-z0-9\-]+
	//						Also include (1), (2) etc and (See ...)
	// English = .+
	
	// [kanji]-(;[kanji]-)* *\[[kana]-(;[kana])*\] */(( *\([general_information]\))*( *[english]+)+)+ */ *EntL[0-9]{8}X? */
	// private final String dataFromDictionary;
	
	private final String kanji, kana, english;
	private final WordLearningState learningState;
	
	private static Random random = new Random();
	
	
	public Word(final String kanji, final String kana, final String english) {
		// final int lineInDictionary, final String dataFromDictionary) {
		// this.lineInDictionary = lineInDictionary;
		// this.dataFromDictionary = dataFromDictionary;
		
		this.kanji = kanji;
		this.kana = kana;
		this.english = english;
		learningState = WordLearningState.values()[Word.random.nextInt(3)];
		// WordLearningState.NOT_LEARNT;
	}
	
	
	public String getKanji() {
		return kanji; // "重力\nTest\nTest2\nLolol";
	}
	
	
	public String getKana() {
		return kana; // "じゅうりょく";
	}
	
	
	public String getEnglish() {
		return english; // "(n) Gravity";
	}
	
	
	public WordLearningState getLearningState() {
		return learningState;
	}
	
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	
	@Override
	public void writeToParcel(final Parcel out, final int flags) {
		out.writeString(kanji);
		out.writeString(kana);
		out.writeString(english);
		out.writeInt(learningState.ordinal());
		// out.writeInt(lineInDictionary);
		// out.writeString(dataFromDictionary);
	}
	
	public static final Parcelable.Creator<Word> CREATOR = new Parcelable.Creator<Word>() {
		@Override
		public Word createFromParcel(final Parcel in) {
			return new Word(in);
		}
		
		
		@Override
		public Word[] newArray(final int size) {
			return new Word[size];
		}
	};
	
	
	private Word(final Parcel in) {
		kanji = in.readString();
		kana = in.readString();
		english = in.readString();
		learningState = WordLearningState.values()[in.readInt()];
		// lineInDictionary = in.readInt();
		// dataFromDictionary = in.readString();
	}
}