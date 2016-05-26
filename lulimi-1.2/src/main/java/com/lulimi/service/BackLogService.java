package com.lulimi.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.lulimi.dao.AbstractDao;
import com.lulimi.dao.BackLogRepository;
import com.lulimi.model.BackLog;
import com.lulimi.util.Utilities;

@Service
public class BackLogService extends AbstractDao implements BackLogRepository{

	
	public void save(BackLog backLog) 
	{
		mongoTemplate.save(backLog);
	}
	
	public List<BackLog> findAll() 
	{
		return mongoTemplate.findAll(BackLog.class);
	}
	
	public BackLog findOne(String sourceText)
	{
		return mongoTemplate.findById(sourceText, BackLog.class);
	}
	
	public void delete(String sourceText) {
		Query query = Utilities.createQuery("sourceText", sourceText);
		mongoTemplate.remove(query, BackLog.class);
	}
}
