package com.keepshopping.database;

import java.util.List;

import com.keepshopping.model.Item;
import com.mongodb.Mongo;

public class MongoDBDao implements DataAccessObject {

	private MongoDBDao mongoDbObj;
//	private String collectionName;
	private MongoDBDao_1 mongoDBConnection;
	
	private MongoDBDao() {
		
	}
	
	@Override
	public List<Item> fetchAllDocuments(String collectionName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item fetchDocumentbyId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item fetchDocumentbyName() {
		// TODO Auto-generated method stub
		return null;
	}

}
