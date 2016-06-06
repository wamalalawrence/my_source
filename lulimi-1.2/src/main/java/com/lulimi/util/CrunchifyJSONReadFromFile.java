package com.lulimi.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.lulimi.model.OldTranslation;
import com.lulimi.model.PhrasesDictionary;


public class CrunchifyJSONReadFromFile {

/*	
	public static void main(String [] args) throws FileNotFoundException {
		
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.disableHtmlEscaping().create();
        
		JsonReader reader = new JsonReader(new FileReader("/Users/wamalalawrence/Documents/lulimi-resources/englis-luganda.json"));
		
		OldTranslation response = gson.fromJson(reader, OldTranslation.class);
		HashMap<String, Object> phrasesDictionary = response.getPhrasesDictionary();
		
		List<PhrasesDictionary> dictionaries = new ArrayList<PhrasesDictionary>();
		PhrasesDictionary dictionary = null;
		
		for (Map.Entry<String, Object> entry : phrasesDictionary.entrySet()) {
		    String key = entry.getKey();
		    
		    List<String> values = null;
		    
		    Object value = entry.getValue();
		    if(value instanceof String) {
		    	values = new ArrayList<String>();
		    	values.add((String)value);
		    } else if(value instanceof List) {
		    	values = new ArrayList<String>();
		    	values.addAll((List)value);
		    }
		    
		    dictionary = new PhrasesDictionary(key, values);
		    dictionaries.add(dictionary);
		}
		
//		System.out.println(dictionaries.toString());
		phrasesDictionary = null;
		
		// convert java object to JSON format,
		// and returned as JSON formatted string
		String json = gson.toJson(dictionaries);
		try {
			//write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter("/Users/wamalalawrence/Documents/lulimi-resources/englishluganda.json");
			writer.write(json);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	*/
}
