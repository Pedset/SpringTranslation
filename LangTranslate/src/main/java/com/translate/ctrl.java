package com.translate;



import java.util.Locale;

public class ctrl {
	
	
	public static String spanishCtrl(String word, Locale locale) {
		
			System.out.println("checkpoint 4");
			return ("{\"spanish\":\"" + word + "\" \n \"english\":\"" + WordSaver.getSpanishWord(word) + "\"}");
		

	}
	public static String englishCtrl(String word, Locale locale) {
		System.out.println("checkpoint 1");
		return ("{\"english\":\"" + word + "\" \n \"spanish\":\"" + WordSaver.getEnglishWord(word) + "\"}");
		
	}
		

	public static String saveCtrl(String word, String translation, Locale from, Locale to){
		
		if (from.toLanguageTag().equals("us") && to.toLanguageTag().equals("sp")) {
			if (WordSaver.checkEnglishWord(word)) {
				
				return ("{ \"messagg\":\"Word Already exist (type:1)\"}");
			}
			else {
				WordSaver.saveWord(word, translation);
				return "{ \"messagg\":\"Word saved\"}"; 
			}
		}
		else if (from.toLanguageTag().equals("sp") && to.toLanguageTag().equals("us")) {
			if (WordSaver.checkSpanishWord(word)) {
				return "{ \"messagg\":\"Word Already exist (type:2)\"}";
			}
			else {
				WordSaver.saveWord(translation, word);
				return "{ \"messagg\":\"Word saved\"}"; 
			}
		}
		return ("Can not save");
	}
	
		
	
}
