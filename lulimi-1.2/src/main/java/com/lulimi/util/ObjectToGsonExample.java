package com.lulimi.util;

/*
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.lulimi.model.PhrasesDictionary;
import com.lulimi.model.Translation;
*/

public class ObjectToGsonExample {
    
	/*
	public static void main(String[] args) {

	Translation obj = new Translation();
	obj.setSourceLanguage("english");
	obj.setTargetLanguage("luganda");
	List<PhrasesDictionary> phrases = new ArrayList<PhrasesDictionary>();
	PhrasesDictionary pd = new PhrasesDictionary();
	pd.setKey("d1");
	List<String> ls = new ArrayList<String>();
	ls.add("ls1");
	ls.add("ls2");
	pd.setValue(ls);
	phrases.add(pd);
	
	PhrasesDictionary pd2 = new PhrasesDictionary();
	pd.setKey("d12");
	List<String> ls2 = new ArrayList<String>();
	ls2.add("ls12");
	ls2.add("ls22");
	pd2.setValue(ls2);
	phrases.add(pd2);
	
	obj.setPhrases(phrases);

	Gson gson = new Gson();

	// convert java object to JSON format,
	// and returned as JSON formatted string
	String json = gson.toJson(obj);

	try {
		//write converted json data to a file named "file.json"
		FileWriter writer = new FileWriter("/Users/wamalalawrence/Documents/file.json");
		writer.write(json);
		writer.close();

	} catch (IOException e) {
		e.printStackTrace();
	}

	System.out.println(json);

    }
    */
}
