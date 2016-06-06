package com.lulimi.dao;

/**
 * @author wamalalawrence
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class AbstractDao {

	@Autowired
	protected MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate template) {
		this.mongoTemplate = template;
	}

	public MongoTemplate getMongoTemplate() {
		return this.mongoTemplate;
	}
}
