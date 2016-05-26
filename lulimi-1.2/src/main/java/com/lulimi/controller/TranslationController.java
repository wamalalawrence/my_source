package com.lulimi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lulimi.dao.PhrasesRepository;
import com.lulimi.model.BackLog;
import com.lulimi.model.PhrasesDictionary;
import com.lulimi.model.Translation;
import com.lulimi.service.BackLogService;
import com.lulimi.service.TranslationService;
import com.lulimi.util.Utilities;

@RestController
public class TranslationController {

	static final Logger logger = Logger.getLogger(TranslationController.class);

	@Autowired
	private TranslationService translationService;
	
	@Autowired
	private BackLogService backLogService;
	
//	@Value("${app.name}")
//	private String appName;

	/**
	 * Check if service is up
	 * 
	 * @return status String
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String getStatus() {
		String statusMessage = "Lulimi service is up and running... ";
//		if (logger.isDebugEnabled()) {
//			logger.debug(">>>>>>>>>>>>>>>>>>>> " + appName);
//		}
		return statusMessage;
	}

	/**
	 * 
	 * @param {sourceLanguage}/{targetLanguage}/{sourceText}
	 * @return
	 */
	@RequestMapping(value = "/translate/{sourceLanguage}/{targetLanguage}/{sourceText}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getTranslation(@PathVariable String sourceLanguage,
			@PathVariable String targetLanguage, @PathVariable String sourceText) {
		try 
		{
			PhrasesDictionary dictionary = translationService.findByCollectionNameAndKey(Utilities.generateCollectionName(sourceLanguage, targetLanguage), sourceText.toLowerCase());
			if (dictionary == null) 
			{
				logger.warn(PhrasesRepository.NO_RESULT + sourceLanguage + " " + targetLanguage + " " + sourceText);
				writeToBackLog(sourceLanguage, targetLanguage, sourceText);
				List<String> result = new ArrayList<String>();
				result.add(sourceText);
				return new ResponseEntity<List<String>>(result, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<String>>(dictionary.getValue(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e);
			return new ResponseEntity<List<String>>(HttpStatus.PRECONDITION_FAILED);
		}
	}

	@RequestMapping(value = "/translate/", method = RequestMethod.POST)
	public ResponseEntity<Void> addTranslation(@RequestBody Translation translation) {
		try 
		{
			String collectionName = Utilities.generateCollectionName(translation.getSourceLanguage(), translation.getTargetLanguage());

			phrasesLoop: 
				for (PhrasesDictionary phrase : translation.getPhrases()) 
				{
					PhrasesDictionary existing = translationService.findByCollectionNameAndKey(collectionName, phrase.getKey());
					if (existing != null) {
						continue phrasesLoop;
					}
					translationService.saveByCollectionName(collectionName, phrase);
				}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/translate/{oldKey}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateTranslation(@PathVariable("oldKey") String oldKey,
			@RequestBody Translation translation) {
		try 
		{
			String collectionName = Utilities.generateCollectionName(translation.getSourceLanguage(), translation.getTargetLanguage());

			PhrasesDictionary existing = translationService.findByCollectionNameAndKey(collectionName, oldKey);
			if (existing == null) {
				return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
			}
			HashSet<String> wordList = new HashSet<String>(existing.getValue()); // trying
																					// to
																					// avoid
																					// duplicates
			for (String data : existing.getValue()) {
				wordList.add(data);
			}
			existing.setValue(new ArrayList<String>(wordList));
			translationService.saveByCollectionName(collectionName, existing);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
		}

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	private void writeToBackLog(String sourceLanguage, String targetLanguage, String sourceText) {
		// TODO:- should we throw-up or just return same object with translation
		// made
		// i think i have an idea :), lets collect all that is not translated
		// keep it somewhere in a BackLog collection for reference - then we
		// know what to translate
		// in the future!
		BackLog backLog = new BackLog();
		backLog.setSourceLanguage(sourceLanguage);
		backLog.setTargetLanguage(targetLanguage);
		backLog.setSourceText(sourceText);
		backLogService.save(backLog);
	}

}
