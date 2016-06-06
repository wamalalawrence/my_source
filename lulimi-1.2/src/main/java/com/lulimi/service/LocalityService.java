package com.lulimi.service;

/**
 * @author wamalalawrence
 */


import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.lulimi.dao.AbstractDao;
import com.lulimi.dao.LocalityRepository;
import com.lulimi.model.Locality;
import com.lulimi.util.Utilities;


@Service
public class LocalityService extends AbstractDao implements LocalityRepository{

	
	public void save(Locality locality) 
	{
		mongoTemplate.save(locality);
	}
	
	public List<Locality> findAll() 
	{
		return mongoTemplate.findAll(Locality.class);
	}
	
	public Locality findOne(String country) {
		return mongoTemplate.findById(country, Locality.class);
	}
	
	public void delete(String country) {
		Query query = Utilities.createQuery("country", country);
		mongoTemplate.remove(query, Locality.class);
	}
}
