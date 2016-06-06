package com.lulimi.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author wamalalawrence
 *
 */

@Document
public class Locality implements Serializable{

	private static final long serialVersionUID = 3266191176999421522L;
	
	@Id
	private String country;
	private List<String> languages;

	public String getCountry() {
		return country.toLowerCase();
	}
	public void setCountry(String country) {
		this.country = country.toLowerCase();
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	
	@Override
	public String toString() {
		return "Locality [country=" + country + ", languages=" + languages + "]";
	}

}
