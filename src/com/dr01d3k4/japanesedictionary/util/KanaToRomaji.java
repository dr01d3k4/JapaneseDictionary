package com.dr01d3k4.japanesedictionary.util;

public class KanaToRomaji {
	/**
	 * Returns the consonant part of a kana if it ends with an -i
	 * 
	 * @param kana
	 *            the kana to check
	 * @return the consonant part of the kana, or "" if not -i
	 */
	private static String isIEndingKana(final String kana) {
		String consonant = "";
		if (kana.equals("き") || kana.equals("キ")) {
			consonant = "k";
		} else if (kana.equals("し") || kana.equals("シ")) {
			consonant = "sh";
		} else if (kana.equals("ち") || kana.equals("チ")) {
			consonant = "ch";
		} else if (kana.equals("に") || kana.equals("ニ")) {
			consonant = "n";
		} else if (kana.equals("ひ") || kana.equals("ヒ")) {
			consonant = "h";
		} else if (kana.equals("み") || kana.equals("ミ")) {
			consonant = "m";
		} else if (kana.equals("り") || kana.equals("リ")) {
			consonant = "r";
		} else if (kana.equals("ぎ") || kana.equals("ギ")) {
			consonant = "g";
		} else if (kana.equals("じ") || kana.equals("ジ")) {
			consonant = "j";
		} else if (kana.equals("ぢ") || kana.equals("ヂ")) {
			consonant = "dz";
		} else if (kana.equals("び") || kana.equals("ビ")) {
			consonant = "b";
		} else if (kana.equals("ぴ") || kana.equals("ピ")) {
			consonant = "p";
		}
		return consonant;
	}
	
	
	private static String getKanaToRomajiAt(final String kana, final int c) {
		if ((c < 0) || (c >= kana.length())) {
			return "";
		}
		final String kanaChar = kana.substring(c, c + 1);
		String charToAdd = "";
		
		// Vowels
		if (kanaChar.equals("あ") || kanaChar.equals("ア") || kanaChar.equals("ぁ") || kanaChar.equals("ァ")) {
			charToAdd = "a";
		} else if (kanaChar.equals("い") || kanaChar.equals("イ") || kanaChar.equals("ぃ") || kanaChar.equals("ィ")) {
			charToAdd = "i";
		} else if (kanaChar.equals("う") || kanaChar.equals("ウ") || kanaChar.equals("ぅ") || kanaChar.equals("ゥ")) {
			charToAdd = "u";
		} else if (kanaChar.equals("え") || kanaChar.equals("エ") || kanaChar.equals("ぇ") || kanaChar.equals("ェ")) {
			charToAdd = "e";
		} else if (kanaChar.equals("お") || kanaChar.equals("オ") || kanaChar.equals("ぉ") || kanaChar.equals("ォ")) {
			charToAdd = "o";
			
			// K set
		} else if (kanaChar.equals("か") || kanaChar.equals("カ")) {
			charToAdd = "ka";
		} else if (kanaChar.equals("く") || kanaChar.equals("ク")) {
			charToAdd = "ku";
		} else if (kanaChar.equals("け") || kanaChar.equals("ケ")) {
			charToAdd = "ke";
		} else if (kanaChar.equals("こ") || kanaChar.equals("コ")) {
			charToAdd = "ko";
			
			// G set
		} else if (kanaChar.equals("が") || kanaChar.equals("ガ")) {
			charToAdd = "ga";
		} else if (kanaChar.equals("ぐ") || kanaChar.equals("グ")) {
			charToAdd = "gu";
		} else if (kanaChar.equals("げ") || kanaChar.equals("ゲ")) {
			charToAdd = "ge";
		} else if (kanaChar.equals("ご") || kanaChar.equals("ゴ")) {
			charToAdd = "go";
			
			// S set
		} else if (kanaChar.equals("さ") || kanaChar.equals("サ")) {
			charToAdd = "sa";
		} else if (kanaChar.equals("す") || kanaChar.equals("ス")) {
			charToAdd = "su";
		} else if (kanaChar.equals("せ") || kanaChar.equals("セ")) {
			charToAdd = "se";
		} else if (kanaChar.equals("そ") || kanaChar.equals("ソ")) {
			charToAdd = "so";
			
			// Z set
		} else if (kanaChar.equals("ざ") || kanaChar.equals("ザ")) {
			charToAdd = "za";
		} else if (kanaChar.equals("ず") || kanaChar.equals("ズ")) {
			charToAdd = "zu";
		} else if (kanaChar.equals("ぜ") || kanaChar.equals("ゼ")) {
			charToAdd = "ze";
		} else if (kanaChar.equals("ぞ") || kanaChar.equals("ゾ")) {
			charToAdd = "zo";
			
			// T set
		} else if (kanaChar.equals("た") || kanaChar.equals("タ")) {
			charToAdd = "ta";
		} else if (kanaChar.equals("つ") || kanaChar.equals("ツ")) {
			charToAdd = "tsu";
		} else if (kanaChar.equals("て") || kanaChar.equals("テ")) {
			if ((c + 1) < kana.length()) {
				final String next = kana.substring(c + 1, c + 2);
				if (next.equals("ぁ") || next.equals("ァ") || next.equals("ぃ") || next.equals("ィ") || next.equals("ぅ")
					|| next.equals("ゥ") || next.equals("ぇ") || next.equals("ェ") || next.equals("ぉ") || next.equals("ォ")) {
					charToAdd = "t";
				} else {
					charToAdd = "te";
				}
			} else {
				charToAdd = "te";
			}
		} else if (kanaChar.equals("と") || kanaChar.equals("ト")) {
			charToAdd = "to";
			
			// D set
		} else if (kanaChar.equals("だ") || kanaChar.equals("ダ")) {
			charToAdd = "da";
		} else if (kanaChar.equals("づ") || kanaChar.equals("ヅ")) {
			charToAdd = "dzu";
		} else if (kanaChar.equals("で") || kanaChar.equals("デ")) {
			charToAdd = "de";
		} else if (kanaChar.equals("ど") || kanaChar.equals("ド")) {
			charToAdd = "do";
			
			// N set
		} else if (kanaChar.equals("な") || kanaChar.equals("ナ")) {
			charToAdd = "na";
		} else if (kanaChar.equals("ぬ") || kanaChar.equals("ヌ")) {
			charToAdd = "nu";
		} else if (kanaChar.equals("ね") || kanaChar.equals("ネ")) {
			charToAdd = "ne";
		} else if (kanaChar.equals("の") || kanaChar.equals("ノ")) {
			charToAdd = "no";
			
			// H set
		} else if (kanaChar.equals("は") || kanaChar.equals("ハ")) {
			charToAdd = "ha";
		} else if (kanaChar.equals("ふ") || kanaChar.equals("フ")) {
			if ((c + 1) < kana.length()) {
				final String next = kana.substring(c + 1, c + 2);
				if (next.equals("ぁ") || next.equals("ァ") || next.equals("ぃ") || next.equals("ィ") || next.equals("ぅ")
					|| next.equals("ゥ") || next.equals("ぇ") || next.equals("ェ") || next.equals("ぉ") || next.equals("ォ")) {
					charToAdd = "f";
				} else {
					charToAdd = "fu";
				}
			} else {
				charToAdd = "fu";
			}
		} else if (kanaChar.equals("へ") || kanaChar.equals("ヘ")) {
			charToAdd = "he";
		} else if (kanaChar.equals("ほ") || kanaChar.equals("ホ")) {
			charToAdd = "ho";
			
			// B set
		} else if (kanaChar.equals("ば") || kanaChar.equals("バ")) {
			charToAdd = "ba";
		} else if (kanaChar.equals("ぶ") || kanaChar.equals("ブ")) {
			charToAdd = "bu";
		} else if (kanaChar.equals("べ") || kanaChar.equals("ベ")) {
			charToAdd = "be";
		} else if (kanaChar.equals("ぼ") || kanaChar.equals("ボ")) {
			charToAdd = "bo";
			
			// M set
		} else if (kanaChar.equals("ま") || kanaChar.equals("マ")) {
			charToAdd = "ma";
		} else if (kanaChar.equals("む") || kanaChar.equals("ム")) {
			charToAdd = "mu";
		} else if (kanaChar.equals("め") || kanaChar.equals("メ")) {
			charToAdd = "me";
		} else if (kanaChar.equals("も") || kanaChar.equals("モ")) {
			charToAdd = "mo";
			
			// P set
		} else if (kanaChar.equals("ぱ") || kanaChar.equals("パ")) {
			charToAdd = "pa";
		} else if (kanaChar.equals("ぷ") || kanaChar.equals("プ")) {
			charToAdd = "pu";
		} else if (kanaChar.equals("ぺ") || kanaChar.equals("ペ")) {
			charToAdd = "pe";
		} else if (kanaChar.equals("ぽ") || kanaChar.equals("ポ")) {
			charToAdd = "po";
			
			// Y set
		} else if (kanaChar.equals("や") || kanaChar.equals("ヤ")) {
			charToAdd = "ya";
		} else if (kanaChar.equals("ゆ") || kanaChar.equals("ユ")) {
			charToAdd = "yu";
		} else if (kanaChar.equals("よ") || kanaChar.equals("ヨ")) {
			charToAdd = "yo";
			
			// Little ya/yu/yo
		} else if (kanaChar.equals("ゃ") || kanaChar.equals("ャ")) {
			charToAdd = "a";
		} else if (kanaChar.equals("ゅ") || kanaChar.equals("ュ")) {
			charToAdd = "u";
		} else if (kanaChar.equals("ょ") || kanaChar.equals("ョ")) {
			charToAdd = "o";
			
			// R set
		} else if (kanaChar.equals("ら") || kanaChar.equals("ラ")) {
			charToAdd = "ra";
		} else if (kanaChar.equals("る") || kanaChar.equals("ル")) {
			charToAdd = "ru";
		} else if (kanaChar.equals("れ") || kanaChar.equals("レ")) {
			charToAdd = "re";
		} else if (kanaChar.equals("ろ") || kanaChar.equals("ロ")) {
			charToAdd = "ro";
			
			// W set
		} else if (kanaChar.equals("わ") || kanaChar.equals("ワ")) {
			charToAdd = "wa";
		} else if (kanaChar.equals("ゐ") || kanaChar.equals("ヰ")) {
			charToAdd = "wi";
		} else if (kanaChar.equals("ゑ") || kanaChar.equals("ヱ")) {
			charToAdd = "we";
		} else if (kanaChar.equals("を") || kanaChar.equals("ヲ")) {
			charToAdd = "wo";
			
			// Single N
		} else if (kanaChar.equals("ん") || kanaChar.equals("ン")) {
			final String next = getKanaToRomajiAt(kana, c + 1);
			if (next.length() == 0) {
				charToAdd = "n";
			} else {
				final String start = next.substring(0, 1);
				if (start.equals("m")) {
					charToAdd = "m";
				} else if (start.equals("y")) {
					charToAdd = "n'";
				} else {
					charToAdd = "n";
				}
			}
			
			// V
		} else if (kanaChar.equals("ゔ") || kanaChar.equals("ヴ")) {
			if ((c + 1) < kana.length()) {
				final String next = kana.substring(c + 1, c + 2);
				if (next.equals("ぁ") || next.equals("ァ") || next.equals("ぃ") || next.equals("ィ") || next.equals("ぅ")
					|| next.equals("ゥ") || next.equals("ぇ") || next.equals("ェ") || next.equals("ぉ") || next.equals("ォ")) {
					charToAdd = "v";
				} else {
					charToAdd = "vu";
				}
			} else {
				charToAdd = "vu";
			}
			
			// Little tsu
		} else if (kanaChar.equals("っ") || kanaChar.equals("ッ")) {
			final String next = getKanaToRomajiAt(kana, c + 1);
			if (next.length() == 0) {
				charToAdd = "'";
			} else {
				final String start = next.substring(0, 1);
				if (isKanaConsonantInRomaji(start)) {
					charToAdd = start;
				} else {
					charToAdd = "'";
				}
			}
			
			// Punctuation
		} else if (kanaChar.equals("ー") || kanaChar.equals("-")) {
			final String previous = getKanaToRomajiAt(kana, c - 1);
			if (previous.length() > 0) {
				final String lastChar = previous.substring(previous.length() - 1);
				if (lastChar.equals("a") || lastChar.equals("e") || lastChar.equals("i") || lastChar.equals("o")
					|| lastChar.equals("u")) {
					charToAdd = lastChar;
				} else {
					charToAdd = "-";
				}
			} else {
				charToAdd = "-";
			}
		} else if (kanaChar.equals("。")) {
			charToAdd = ".";
		} else if (kanaChar.equals("！")) {
			charToAdd = "!";
		} else if (kanaChar.equals("？")) {
			charToAdd = "?";
		} else if (kanaChar.equals("「") || kanaChar.equals("」")) {
			charToAdd = "\"";
			
			// Other cases
		} else {
			// -i syllable (ki, gi, shi etc)
			final String consonant = isIEndingKana(kanaChar);
			if (!consonant.equals("")) {
				if ((c + 1) < kana.length()) {
					final String next = kana.substring(c + 1, c + 2);
					if (next.equals("ゃ") || next.equals("ゅ") || next.equals("ょ") || next.equals("ャ")
						|| next.equals("ュ") || next.equals("ョ") || next.equals("ぇ") || next.equals("ェ")) {
						charToAdd = consonant + (((consonant.length() == 1) && !consonant.equals("j")) ? "y" : "");
					} else {
						charToAdd = consonant + "i";
					}
				} else {
					charToAdd = consonant + "i";
				}
				
				// Everything else such as punctuation
			} else {
				charToAdd = kanaChar;
			}
		}
		return charToAdd;
	}
	
	
	private static boolean isKanaConsonantInRomaji(final String s) {
		return (s.equals("k") || s.equals("g") //
			|| s.equals("s") || s.equals("z") || s.equals("j") //
			|| s.equals("t") || s.equals("c") || s.equals("d") //
			|| s.equals("n") //
			|| s.equals("h") || s.equals("b") //
			|| s.equals("m") || s.equals("p") //
			|| s.equals("y") //
		|| s.equals("w"));
	}
	
	
	public static String kanaToRomaji(final String kana) {
		final StringBuilder romaji = new StringBuilder();
		
		for (int c = 0; c < kana.length(); c++) {
			romaji.append(getKanaToRomajiAt(kana, c));
		}
		
		return romaji.toString();
	}
}
