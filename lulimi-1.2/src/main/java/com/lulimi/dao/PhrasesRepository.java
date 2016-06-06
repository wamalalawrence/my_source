package com.lulimi.dao;

/**
 * @author wamalalawrence
 */

import java.util.List;

import com.lulimi.model.PhrasesDictionary;

public interface PhrasesRepository
{

	public static final String NO_RESULT = "Translation not found! ";
	public static final String NOT_SUPPORTED = "Translation not supported just yet ";

	public PhrasesDictionary find(String collectionName, String key);
	public List<PhrasesDictionary> findWithFullTextSearch(String collectionName, String key);
	public void saveByCollectionName(String collectionName, PhrasesDictionary phrasesDictionary);
	public void delete(String collectionName, PhrasesDictionary phrasesDictionary);
}
