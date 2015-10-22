package com.keepshopping.database;

import java.util.List;

import com.keepshopping.model.Item;

public interface DataAccessObject {

	public List<Item> fetchAllDocuments(String collectionName);
	public Item fetchDocumentbyId();
	public Item fetchDocumentbyName();
	public void insertCollection(Item item);
	
}
