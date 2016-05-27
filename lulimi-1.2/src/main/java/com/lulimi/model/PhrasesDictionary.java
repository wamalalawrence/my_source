package com.lulimi.model;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Document(collection = "#{phrasesRepository.getCollectionName()}")

@Document
public class PhrasesDictionary implements Serializable{

	private static final long serialVersionUID = 1888898527971533156L;

//	@TextIndexed
	@Id
	private String key;
	
	private List<String> value;
	
	
	public PhrasesDictionary() {
		super();
	}

	public PhrasesDictionary(String key, List<String> value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key.trim().toLowerCase();
	}
	
	public void setKey(String key) {
		this.key = key.toLowerCase();
	}

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PhrasesDictionary [key=" + key + ", value=" + value + "]";
	}

}
