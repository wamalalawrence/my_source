package com.lulimi.model;

/**
 * @author wamalalawrence
 */

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BackLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2474905856332849652L;
	
	@Id
	private String sourceText;
	
	private Date dateCreated;
	private String sourceLanguage;
	private String targetLanguage;
	
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
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
	public String getSourceText() {
		return sourceText;
	}
	public void setSourceText(String sourceText) {
		this.sourceText = sourceText;
	}
	@Override
	public String toString() {
		return "BackLog [dateCreated=" + dateCreated + ", sourceLanguage=" + sourceLanguage
				+ ", targetLanguage=" + targetLanguage + ", sourceText=" + sourceText + "]";
	}
	
	
	

}
