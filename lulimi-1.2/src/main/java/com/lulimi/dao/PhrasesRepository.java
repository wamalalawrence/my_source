package com.lulimi.dao;


import com.lulimi.model.PhrasesDictionary;

public interface PhrasesRepository
{

	public static final String NO_RESULT = "Translation not found! ";
	public static final String NOT_SUPPORTED = "Translation not supported just yet ";

	
	public PhrasesDictionary findByCollectionNameAndKey(String collectionName, String key);
	public void saveByCollectionName(String collectionName, PhrasesDictionary phrasesDictionary);
}
