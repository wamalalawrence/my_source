package com.lulimi.service;


import org.springframework.stereotype.Service;

import com.lulimi.dao.AbstractDao;
import com.lulimi.dao.PhrasesRepository;
import com.lulimi.model.PhrasesDictionary;

@Service
public class TranslationService extends AbstractDao implements PhrasesRepository {


	public PhrasesDictionary findByCollectionNameAndKey(String collectionName, String key) {
		return mongoTemplate.findById(key, PhrasesDictionary.class, collectionName);
	}

	public void saveByCollectionName(String collectionName, PhrasesDictionary phrasesDictionary) {
		mongoTemplate.save(phrasesDictionary, collectionName);
		
	}


}
