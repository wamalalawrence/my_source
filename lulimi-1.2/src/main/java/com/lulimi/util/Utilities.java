package com.lulimi.util;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class Utilities {

	public static List<String> PermuteWords(String s)
	{
	    String[] ss = s.split(" ");
	    boolean[] used = new boolean[ss.length];
	    String res = "";
	    List<String> list = new ArrayList<String>();
	    permute(ss, used, res, 0, list);
	    return list;
	}

	private static void permute(String[] ss, boolean[] used, String res, int level, List<String> list)
	{
	    if (level == ss.length && res != "")
	    {
	        list.add(res.toLowerCase());
	        return;
	    }
	    for (int i = 0; i < ss.length; i++)
	    {
	        if (used[i]) continue;
	        used[i] = true;
	        permute(ss, used, res + " " + ss[i], level + 1, list);
	        used[i] = false;
	    }
	}
	
	public static Query createQuery(String fieldName, ObjectId fieldValue){
		Query query = new Query();
        query.addCriteria(Criteria.where(fieldName).is(fieldValue));
        return query;
	}
	
	public static Query createQuery(String fieldName, String fieldValue){
		Query query = new Query();
        query.addCriteria(Criteria.where(fieldName).is(fieldValue));
        return query;
	}
	
	public static String generateCollectionName(String sourceLanguage, String targetLanguage) throws IllegalArgumentException
	{
		if((sourceLanguage == null) || (targetLanguage == null)){
			throw new IllegalArgumentException("sourceLanguage or targetLanguage missing");
		}
		String collectionName = sourceLanguage+targetLanguage;
		return collectionName.replaceAll("\\s", collectionName).toLowerCase();
	}
}
