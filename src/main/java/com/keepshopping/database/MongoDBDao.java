package com.keepshopping.database;

import java.util.ArrayList;
import java.util.List;

import com.keepshopping.model.Item;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDBDao implements DataAccessObject{

	private static MongoDBDao mongoDBDao;
	private DB db;
	private String databasename;
	private  DBCollection collection;
	private String databaseURI;
	//private int i=0;
	private MongoDBDao(String databasename){
		databaseURI="mongodb://vinod:vinod121@ds039484.mongolab.com:39484/"+databasename;
		MongoClientURI uri  = new MongoClientURI(databaseURI); 
        MongoClient client = new MongoClient(uri);
        db = client.getDB(uri.getDatabase());
	}
	
	public static MongoDBDao getmongoDBDao(String databasename){
		if(mongoDBDao==null){
			mongoDBDao=new MongoDBDao(databasename);
		}
		return mongoDBDao;
	}

	public List<Item> fetchAllDocuments(String collectionName){
		setCollection(collectionName);
		DBCursor cursor = collection.find();
		List<DBObject> dbObjects=cursor.toArray();
		List<Item> items=new ArrayList<Item>();
		
		
		for(DBObject dbObject:dbObjects){
			//System.out.println(++i);
			Item item=new Item();
			item.setItemId((String)dbObject.get("itemId"));
			item.setItemName((String)dbObject.get("itemName"));
			
			//int price=(Integer)dbObject.get("itemPrice");
			item.setItemPrice(((Integer)dbObject.get("itemPrice")).intValue());
			item.setItemQuantity((String)dbObject.get("itemQuantity"));
			item.setItemQuantityLeft((String)dbObject.get("itemQuantityLeft"));
			item.setItemType((String)dbObject.get("itemType"));
			System.out.println(item.toString());
			items.add(item);
		}
		
		return items;
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
	

	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}

	public DBCollection getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = db.getCollection(collection);
	}
	
	public void setCollection(DBCollection collection) {
		this.collection = collection;
	}
	
}
