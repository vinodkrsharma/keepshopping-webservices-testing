package com.keepshopping.service;

import java.util.List;

import com.keepshopping.database.DataAccessObject;
import com.keepshopping.database.MongoDBDao_1;
import com.keepshopping.model.Item;

public class KeepshoppingService {

	private DataAccessObject dao;
	
	public KeepshoppingService(String databaseName){
		dao=MongoDBDao_1.getMongoDBConnection(databaseName);
	}
	
	public List<Item> fetchAllDocuments(String collectionName){
		List<Item> items=dao.fetchAllDocuments(collectionName);
		
		return items;
	}
}
