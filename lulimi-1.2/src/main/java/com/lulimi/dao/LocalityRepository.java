package com.lulimi.dao;


import java.util.List;

import com.lulimi.model.Locality;

public interface LocalityRepository 
{
	public void save(Locality locality);
	
	public List<Locality> findAll();
	
	public Locality findOne(String country);
	
	public void delete(String country);
	
}