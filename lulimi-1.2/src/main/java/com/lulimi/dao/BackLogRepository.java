package com.lulimi.dao;


import java.util.List;

import com.lulimi.model.BackLog;


public interface BackLogRepository 
{
	public void save(BackLog backLog);
	
	public List<BackLog> findAll();
	
	public BackLog findOne(String sourceText);
	
	public void delete(String sourceText);
	
}