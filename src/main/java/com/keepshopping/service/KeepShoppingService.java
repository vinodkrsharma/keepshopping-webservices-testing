package com.keepshopping.service;

import java.util.List;

import com.keepshopping.database.DataAccessObject;
import com.keepshopping.database.MongoDBDao;
import com.keepshopping.model.Item;

public class KeepShoppingService {

	private DataAccessObject dao;
	
	public KeepShoppingService(String databaseName){
		dao=MongoDBDao.getmongoDBDao(databaseName);
	}
	
	public List<Item> fetchAllDocuments(String collectionName){
		List<Item> items=dao.fetchAllDocuments(collectionName);
		
		return items;
	}
	
	public void insertCollection(Item item){
		dao.insertCollection(item);
	}
}
