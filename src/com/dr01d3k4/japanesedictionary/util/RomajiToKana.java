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
		"わ", "ゐ", "う", "ゑ", "を", // 
		"きゃ", "きぃ", "きゅ", "きぇ", "きょ", //
		"ぎゃ", "ぎぃ", "ぎゅ", "ぎぇ", "ぎょ", //
		"しゃ", "し", "しゅ", "しぇ", "しょ", //
		"じゃ", "じ", "じゅ", "じぇ", "じょ", //
		"ちゃ", "ち", "ちゅ", "ちぇ", "ちょ", //
		"つぁ", "つぃ", "つ", "つぇ", "つぉ", //
		"つゃ", "つぃ", "つゅ", "つぃぇ", "つょ", //
		"ぢゃ", "ぢぃ", "ぢゅ", "ぢぇ", "ぢょ", //
		"づぁ", "づぃ", "づ", "づぇ", "づぉ", //
		"づゃ", "づぃ", "づゅ", "づぃぇ", "づょ", //
		"にゃ", "にぃ", "にゅ", "にぇ", "にょ", //
		"ひゃ", "ひぃ", "ひゅ", "ひぇ", "ひょ", //
		"ふぁ", "ふぃ", "ふ", "ふぇ", "ふぉ", //
		"ふゃ", "ふぃ", "ふゅ", "ふぇ", "ふょ", //
		"びゃ", "びぃ", "びゅ", "びぇ", "びょ", //
		"みゃ", "みぃ", "みゅ", "みぇ", "みょ", //
		"ぴゃ", "ぴぃ", "ぴゅ", "ぴぇ", "ぴょ", //
		"りゃ", "りぃ", "りゅ", "りぇ", "りょ", //
		"うゃ", "ゐ", "うゅ", "ゑ", "うょ", //
		"ぁ", "ぃ", "ぅ", "ぇ", "ぉ", //
		"ヴぁ", "ヴぃ", "ヴ", "ヴぇ", "ヴぉ", //
		"ヴゃ", "ヴぃ", "ヴゅ", "ヴぃぇ", "ヴょ" //
	};
	
	private static String[] katakana = {"", // 
		"ア", "イ", "ウ", "エ", "オ", //
		"カ", "キ", "久", "ケ", "コ", //
		"ガ", "ギ", "グ", "ゲ", "ゴ", //
		"サ", "シ", "ス", "セ", "オ", //
		"ザ", "ジ", "ズ", "ゼ", "ゾ", //
		"タ", "チ", "ツ", "テ", "ト", //
		"ダ", "ヂ", "ヅ", "デ", "ド", //
		"ナ", "ニ", "ヌ", "ネ", "ノ", //
		"ハ", "ヒ", "フ", "ヘ", "ホ", //
		"バ", "ビ", "ブ", "ベ", "ボ", //
		"マ", "ミ", "ム", "メ", "モ", //
		"パ", "ピ", "プ", "ペ", "ポ", //
		"ヤ", "イ", "ユ", "イェ", "ヨ", //
		"ラ", "リ", "ル", "レ", "ロ", //
		"ワ", "ヰ", "ウ", "ヱ", "ヲ", //
		"キャ", "キィ", "キュ", "キェ", "キョ", //
		"ギャ", "ギィ", "ギュ", "ギェ", "ギョ", //
		"シャ", "シ", "シュ", "シェ", "ショ", //
		"ジャ", "ジ", "ジュ", "ジェ", "ジョ", //
		"チャ", "チ", "チュ", "チェ", "チョ", //
		"ツァ", "ツィ", "ツ", "ツェ", "ツォ", //
		"ツャ", "ツィ", "ツュ", "ツィェ", "ツョ", //
		"ヂャ", "ヂィ", "ヂュ", "ヂェ", "ヂョ", //
		"ヅァ", "ヅィ", "ヅ", "ヅェ", "ヅォ", //
		"ヅャ", "ヅィ", "ヅュ", "ヅィェ", "ヅョ", //
		"ニャ", "ニィ", "ニュ", "ニェ", "ニョ", //
		"ヒャ", "ヒィ", "ヒュ", "ヒェ", "ヒョ", //
		"ファ", "フィ", "フ", "フェ", "フォ", //
		"フャ", "フィ", "フュ", "フェ", "フョ", //
		"ビャ", "ビィ", "ビュ", "ビェ", "ビョ", //
		"ミャ", "ミィ", "ミュ", "ミェ", "ミョ", //
		"ピャ", "ピィ", "ピュ", "ピェ", "ピョ", //
		"リャ", "リィ", "リュ", "リェ", "リョ", //
		"ウャ", "ヰ", "ウュ", "ヱ", "ウョ", //
		"ァ", "ィ", "ゥ", "ェ", "ォ", //
		"ヴァ", "ヴィ", "ヴ", "ヴェ", "ヴョ", //
		"ヴャ", "ヴィ", "ヴュ", "ヴィェ", "ヴョ" //
	};
	
	
	public static String romajiToKana(String romaji, KanaType kanaType) {
		StringBuilder kana = new StringBuilder();
		StringBuilder currentKana = new StringBuilder();
		String currentRomaji = "";
		String previousRomaji = "";
		
		int vowelColumn = -1;
		int consonantRow = -1;
		
		for (int c = 0; c < romaji.length(); c++) {
			currentRomaji = romaji.substring(c, c + 1);
			
			if (currentRomaji.equals("a") || currentRomaji.equals("i") || currentRomaji.equals("u")
				|| currentRomaji.equals("e") || currentRomaji.equals("o")) {
				if (currentRomaji.equals("a")) {
					vowelColumn = 1;
				} else if (currentRomaji.equals("i")) {
					vowelColumn = 2;
				} else if (currentRomaji.equals("u")) {
					vowelColumn = 3;
				} else if (currentRomaji.equals("e")) {
					vowelColumn = 4;
				} else if (currentRomaji.equals("o")) {
					vowelColumn = 5;
				}
				
				String currentKanaString = currentKana.toString();
				// Check for double consonants for little tsu
				if (((currentKanaString.length() >= 2) && currentKanaString.substring(0, 1).equals(
					currentKanaString.substring(1, 2)))
					|| currentKanaString.equals("tch")) {
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
					consonantRow = 15;
				} else if (currentKanaString.equals("gy")) {
					consonantRow = 16;
					
				} else if (currentKanaString.equals("sh")) {
					consonantRow = 17;
				} else if (currentKanaString.equals("j")) {
					consonantRow = 18;
					
				} else if (currentKanaString.equals("ch")) {
					consonantRow = 19;
				} else if (currentKanaString.equals("ts")) {
					consonantRow = 20;
				} else if (currentKanaString.equals("tsy")) {
					consonantRow = 21;
				} else if (currentKanaString.equals("dy") || currentKanaString.equals("dj")) {
					consonantRow = 22;
				} else if (currentKanaString.equals("dz")) {
					consonantRow = 23;
				} else if (currentKanaString.equals("dzy")) {
					consonantRow = 24;
					
				} else if (currentKanaString.equals("ny")) {
					consonantRow = 25;
					
				} else if (currentKanaString.equals("hy")) {
					consonantRow = 26;
				} else if (currentKanaString.equals("f")) {
					consonantRow = 27;
				} else if (currentKanaString.equals("fy")) {
					consonantRow = 28;
				} else if (currentKanaString.equals("by")) {
					consonantRow = 29;
					
				} else if (currentKanaString.equals("my")) {
					consonantRow = 30;
				} else if (currentKanaString.equals("py")) {
					consonantRow = 31;
					
				} else if (currentKanaString.equals("ry")) {
					consonantRow = 32;
				} else if (currentKanaString.equals("wy")) {
					consonantRow = 33;
					
				} else if (currentKanaString.equals("l") || currentKanaString.equals("x")) {
					consonantRow = 34;
				} else if (currentKanaString.equals("v")) {
					consonantRow = 35;
				} else if (currentKanaString.equals("vy")) {
					consonantRow = 36;
				}
				
				if ((vowelColumn > -1) && (consonantRow > -1)) {
					String kanaFromTable = "";
					if (kanaType.equals(KanaType.KATAKANA) // 
						&& (consonantRow == 0) //
						&& (currentRomaji.length() > 0) //
						&& (previousRomaji.length() > 0) //
						&& currentRomaji.equals(previousRomaji.substring(previousRomaji.length() - 1))) {
						kanaFromTable = "ー";
					} else {
						int kanaLocation = vowelColumn + (consonantRow * 5); // 2d -> 1d array
						if (kanaType.equals(KanaType.HIRAGANA)) {
							kanaFromTable = hiragana[kanaLocation];
						} else {
							kanaFromTable = katakana[kanaLocation];
						}
						previousRomaji = currentKana.toString() + currentRomaji;
					}
					kana.append(kanaFromTable);
				} else {
					if (currentKana.length() > 1) {
						kana.append(currentKana.toString().substring(0, 1));
						currentKana.delete(0, 1);
						c--;
						continue;
					} else {
						kana.append(currentKana.toString());
						kana.append(currentRomaji);
						previousRomaji = currentRomaji;
					}
				}
				currentKana.delete(0, currentKana.length() + 1);
				vowelColumn = consonantRow = -1;
				
				// Consonant
			} else if (currentRomaji.equals("k") || currentRomaji.equals("g") // 
				|| currentRomaji.equals("s") || currentRomaji.equals("j") || currentRomaji.equals("z") // 
				|| currentRomaji.equals("t") || currentRomaji.equals("c") || currentRomaji.equals("d") //
				|| currentRomaji.equals("h") || currentRomaji.equals("f") || currentRomaji.equals("b") //
				|| currentRomaji.equals("m") || currentRomaji.equals("p") //
				|| currentRomaji.equals("y") //
				|| currentRomaji.equals("r") //
				|| currentRomaji.equals("w") //
				|| currentRomaji.equals("l") || currentRomaji.equals("x") || currentRomaji.equals("v")) {
				currentKana.append(currentRomaji);
				
			} else if (currentRomaji.equals("n")) {
				if ((c + 1) < romaji.length()) {
					String next = romaji.substring(c + 1, c + 2);
					if (next.equals("a") || next.equals("i") || next.equals("u") || next.equals("e")
						|| next.equals("o") || next.equals("y")) {
						currentKana.append("n");
					} else {
						kana.append(currentKana);
						currentKana.delete(0, currentKana.length());
						if (kanaType.equals(KanaType.HIRAGANA)) {
							kana.append("ん");
						} else {
							kana.append("ン");
						}
						if (next.equals("'")) {
							c++;
						}
						previousRomaji = currentRomaji;
					}
				} else {
					if (kanaType.equals(KanaType.HIRAGANA)) {
						kana.append("ん");
					} else {
						kana.append("ン");
					}
				}
			} else {
				kana.append(currentKana);
				currentKana.delete(0, currentKana.length());
				
				// Punctuation
				if (currentRomaji.equals(".")) {
					kana.append("。");
				} else if (currentRomaji.equals("!")) {
					kana.append("！");
				} else if (currentRomaji.equals("?")) {
					kana.append("?");
					
					// Anything else
				} else {
					kana.append(currentRomaji);
				}
				previousRomaji = currentRomaji;
			}
		}
		kana.append(currentKana);
		
		return kana.toString();
	}
}
