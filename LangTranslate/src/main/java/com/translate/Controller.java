package com.translate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@Configuration
//Controller
@RestController
public class Controller {
	@Autowired
	private MessageSource messageSource;

	


//passing a path variable 
//hello-world/path/ASTRING
	@PostMapping(path = "/save")
	public String EnglishWord(@RequestParam("word") String word, @RequestParam("translation") String translation, @RequestHeader(name = "from") Locale from, @RequestHeader(name = "to", required=false) Locale to) {

		return ctrl.saveCtrl(word, translation, from, to);
		
	}

//I18N 
	@GetMapping(path = "/translate")
	public String helloWorldInternationalized(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale,
			@RequestParam(value = "word") String word) {
		
		
			if (WordSaver.checkSpanishWord(word)) {
				return ctrl.spanishCtrl(word, locale);
			}

			
		
			else if (WordSaver.checkEnglishWord(word)) {
				
				return ctrl.englishCtrl(word, locale);
			}

		
		else {
			
			return "{\"Translation\":\" " + (messageSource.getMessage(word+".message", null, locale)+ "\"");
		}
		
		
	}
	
}