package com.lulimi.model;


import java.io.Serializable;
import java.util.List;


/**
 * I need to create multiple collections from this one blue print, 
 * so this document will not be persistent just yet.
 * 
 * @author wamalalawrence
 *
 */


public class Translation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7154769163820567896L;
	
	private String sourceLanguage;
	private String targetLanguage;
	private String sourceText; // this is the map key
	private String targetText;
	private List<PhrasesDictionary> phrases;
	

	public List<PhrasesDictionary> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<PhrasesDictionary> phrases) {
		this.phrases = phrases;
	}

	public String getSourceLanguage() {
		return sourceLanguage.toLowerCase();
	}
	
	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage.toLowerCase();
	}
	
	public String getTargetLanguage() {
		return targetLanguage.toLowerCase();
	}
	
	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage.toLowerCase();
	}

	public String getSourceText() {
		return sourceText.toLowerCase();
	}

	public void setSourceText(String sourceText) {
		this.sourceText = sourceText.toLowerCase();
	}

	public String getTargetText() {
		return targetText;
	}

	public void setTargetText(String targetText) {
		this.targetText = targetText;
	}

	@Override
	public String toString() {
		return "Translation [sourceLanguage=" + sourceLanguage + ", targetLanguage=" + targetLanguage + ", sourceText="
				+ sourceText + ", targetText=" + targetText + ", phrases=" + phrases + "]";
	}
	


}
