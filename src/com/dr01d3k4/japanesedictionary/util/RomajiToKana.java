package com.dr01d3k4.japanesedictionary.util;

public class RomajiToKana {
	private static String[] hiragana = {"", //
		"あ", "い", "う", "え", "お", // 
		"か", "き", "く", "け", "こ", //
		"が", "ぎ", "ぐ", "げ", "ご", //
		"さ", "し", "す", "せ", "そ", // 
		"ざ", "じ", "ず", "ぜ", "ぞ", //
		"た", "ち", "つ", "て", "と", //
		"だ", "ぢ", "づ", "で", "ど", //
		"な", "に", "ぬ", "ね", "の", //
		"は", "ひ", "ふ", "へ", "ほ", //
		"ば", "び", "ぶ", "べ", "ぼ", //
		"ま", "み", "む", "め", "も", //
		"ぱ", "ぴ", "ぷ", "ぺ", "ぽ", //
		"や", "い", "ゆ", "いぇ", "よ", //
		"ら", "り", "る", "れ", "ろ", // 
		"わ", "うぃ", "う", "うぇ", "を", // 
		"ん", "", "", "", "", //
		"きゃ", "きぃ", "きゅ", "きぇ", "きょ", //
		"ちゃ", "ち", "ちゅ", "ちぇ", "ちょ"};
	
	private static String[] katakana = { };
	
	
	public static String romajiToKana(String romaji, KanaType kanaType) {
		StringBuilder kana = new StringBuilder();
		StringBuilder currentKana = new StringBuilder();
		String previousKana = "";
		
		int vowelColumn = -1;
		int consonantRow = -1;
		
		for (int c = 0; c < romaji.length(); c++) {
			String current = romaji.substring(c, c + 1);
			
			if (current.equals("a") || current.equals("i") || current.equals("u") || current.equals("e")
				|| current.equals("o")) {
				if (current.equals("a")) {
					vowelColumn = 1;
				} else if (current.equals("i")) {
					vowelColumn = 2;
				} else if (current.equals("u")) {
					vowelColumn = 3;
				} else if (current.equals("e")) {
					vowelColumn = 4;
				} else if (current.equals("o")) {
					vowelColumn = 5;
				}
				
				String currentKanaString = currentKana.toString();
				// Check for double consonants for little tsu
				if (currentKanaString.equals("kk")
					|| currentKanaString.equals("gg") //
					|| currentKanaString.equals("ss") || currentKanaString.equals("zz")
					|| currentKanaString.equals("jj")) {
					if (kanaType.equals(KanaType.HIRAGANA)) {
						kana.append("っ");
					} else {
						kana.append("ッ");
					}
					currentKanaString = currentKanaString.substring(1);
				}
				
				if (currentKanaString.equals("")) {
					consonantRow = 0;
				} else if (currentKanaString.equals("k")) {
					consonantRow = 1;
				} else if (currentKanaString.equals("g")) {
					consonantRow = 2;
				} else if (currentKanaString.equals("s")) {
					consonantRow = 3;
				} else if (currentKanaString.equals("z")) {
					consonantRow = 4;
				} else if (currentKanaString.equals("t")) {
					consonantRow = 5;
				} else if (currentKanaString.equals("d")) {
					consonantRow = 6;
				} else if (currentKanaString.equals("n")) {
					consonantRow = 7;
				} else if (currentKanaString.equals("h")) {
					consonantRow = 8;
				} else if (currentKanaString.equals("b")) {
					consonantRow = 9;
				} else if (currentKanaString.equals("m")) {
					consonantRow = 10;
				} else if (currentKanaString.equals("p")) {
					consonantRow = 11;
				} else if (currentKanaString.equals("y")) {
					consonantRow = 12;
				} else if (currentKanaString.equals("r")) {
					consonantRow = 13;
				} else if (currentKanaString.equals("w")) {
					consonantRow = 14;
				} else if (currentKanaString.equals("ky")) {
					consonantRow = 16;
				} else if (currentKanaString.equals("ch")) {
					consonantRow = 17;
				}
				
				if ((vowelColumn > -1) && (consonantRow > -1)) {
					int kanaLocation = vowelColumn + (consonantRow * 5); // 2d -> 1d array
					String kanaFromTable = "";
					if (kanaType.equals(KanaType.HIRAGANA)) {
						kanaFromTable = hiragana[kanaLocation];
					} else {
						kanaFromTable = katakana[kanaLocation];
					}
					kana.append(kanaFromTable);
					previousKana = currentKana.toString();
				} else {
					if (currentKana.length() > 1) {
						kana.append(currentKana.toString().substring(0, 1));
						currentKana.delete(0, 1);
						c--;
						continue;
					} else {
						kana.append(currentKana.toString());
						kana.append(current);
					}
				}
				currentKana.delete(0, currentKana.length() + 1);
				vowelColumn = consonantRow = -1;
				
				// Consonant
			} else if (current.equals("k") || current.equals("g") // 
				|| current.equals("s") || current.equals("j") || current.equals("z") // 
				|| current.equals("t") || current.equals("c") || current.equals("d") //
				|| current.equals("n") // 
				|| current.equals("h") || current.equals("f") || current.equals("b") //
				|| current.equals("m") || current.equals("p") //
				|| current.equals("y") //
				|| current.equals("r") //
				|| current.equals("w")) {
				currentKana.append(current);
				
				// Punctuation
			} else if (current.equals(".")) {
				kana.append("。");
			} else if (current.equals("!")) {
				kana.append("！");
			} else if (current.equals("?")) {
				kana.append("?");
				
				// Anything else
			} else {
				kana.append(current);
			}
		}
		kana.append(currentKana);
		
		return kana.toString();
	}
}
