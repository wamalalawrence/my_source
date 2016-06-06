package com.lulimi.model;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class OldTranslation implements Serializable{
	
	private static final long serialVersionUID = -7154769163820567896L;
	
	@Id
	private String translationId;
	
	@Transient
	private String sourceLanguage;
	
	@Transient
	private String targetLanguage;
	
	@Transient
	private String sourceText; // this is the map key
	
	@Transient
	private String targetText;
	
	private HashMap<String, Object> phrasesDictionary; //value can be an Object of any type
	

	public String getSourceLanguage() {
		return sourceLanguage;
	}
	
	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}
	
	public String getTargetLanguage() {
		return targetLanguage;
	}
	
	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	public String getTranslationId() {
		return translationId;
	}

	public void setTranslationId(String translationId) {
		this.translationId = translationId;
	}

	public String getSourceText() {
		return sourceText;
	}

	public void setSourceText(String sourceText) {
		this.sourceText = sourceText;
	}

	public String getTargetText() {
		return targetText;
	}

	public void setTargetText(String targetText) {
		this.targetText = targetText;
	}

	public HashMap<String, Object> getPhrasesDictionary() {
		return phrasesDictionary;
	}

	public void setPhrasesDictionary(HashMap<String, Object> phrasesDictionary) {
		this.phrasesDictionary = phrasesDictionary;
	}

	@Override
	public String toString() {
		return "OldTranslation [translationId=" + translationId + ", sourceLanguage=" + sourceLanguage
				+ ", targetLanguage=" + targetLanguage + ", sourceText=" + sourceText + ", targetText=" + targetText
				+ ", phrasesDictionary=" + phrasesDictionary + "]";
	}

	

}