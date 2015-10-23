package com.keepshopping.database;

import java.util.List;

import com.keepshopping.model.Item;
import com.mongodb.Mongo;

public class MongoDBDao_spare implements DataAccessObject {

	private MongoDBDao_spare mongoDbObj;
//	private String collectionName;
	private MongoDBDao mongoDBConnection;
	
	private MongoDBDao_spare() {
		
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

	@Override
	public void insertCollection(String collectionName,Item item) {
		// TODO Auto-generated method stub
		
	}

}
