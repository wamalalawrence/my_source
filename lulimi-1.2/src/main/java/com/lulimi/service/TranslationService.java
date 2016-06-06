package com.lulimi.service;

/**
 * @author wamalalawrence
 */

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import com.lulimi.dao.AbstractDao;
import com.lulimi.dao.PhrasesRepository;
import com.lulimi.model.PhrasesDictionary;

@Service
public class TranslationService extends AbstractDao implements PhrasesRepository {

	
	public PhrasesDictionary find(String collectionName, String key) {
		return mongoTemplate.findById(key, PhrasesDictionary.class, collectionName);
	}
	
	/**
	 * Find translation using mongo's full-text search capability
	 */
	public List<PhrasesDictionary> findWithFullTextSearch(String collectionName, String key) {
		// query top 5 translations matching the key
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matching(key);
		Query query = TextQuery.queryText(criteria)
				  .sortByScore()
				  .with(new PageRequest(0, 5));
		return mongoTemplate.find(query, PhrasesDictionary.class, collectionName);
	}

	public void saveByCollectionName(String collectionName, PhrasesDictionary phrasesDictionary) {
		mongoTemplate.save(phrasesDictionary, collectionName);
	}

	public void delete(String collectionName, PhrasesDictionary phrasesDictionary) {
		mongoTemplate.remove(phrasesDictionary, collectionName);
	}

}
