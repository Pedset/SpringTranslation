package com.translate;

import java.util.ArrayList;

import com.translate.WordSaver;

public class WordSaver {
	
	private static ArrayList<String> word = new ArrayList<>();
	private static ArrayList<String> translation = new ArrayList<>();

	
	
	public static void saveWord(String theWord, String translation) {
		word.add(theWord);
		WordSaver.translation.add(translation);
		}
	
	public static void removeWord(String theWord) {
		for (int x = 0; x < word.size(); x++) {
			if (word.get(x).equals(theWord)) {
				word.remove(x);
				translation.remove(x);
				break;
			}
		}
	}
	
	public static boolean checkEnglishWord(String theWord) {
		for (String x : word) {
			if (x.equals(theWord)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkSpanishWord(String theWord) {
		for (String x : translation) {
			if (x.equals(theWord)) {
				return true;
			}
		}
		return false;
	}
	
	public static String getSpanishWord(String theWord) {
		for (int x = 0; x < translation.size(); x++) {
			if (translation.get(x).equals(theWord)) {
				return (word.get(x));
			}
		}
		return "nothing";
	}
	
	public static String getEnglishWord(String theWord) {
		for (int x = 0; x < word.size(); x++) {
			if (word.get(x).equals(theWord)) {
				return (translation.get(x));
			}
		}
		return "nothing";
	}
	
}