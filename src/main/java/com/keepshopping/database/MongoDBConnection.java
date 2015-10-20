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

public class MongoDBConnection {

	private static MongoDBConnection mongoDBConnection;
	private DB db;
	private String databasename;
	private  DBCollection collection;
	
	private MongoDBConnection(String databasename){
		MongoClientURI uri  = new MongoClientURI("mongodb://vinod:vinod121@ds039484.mongolab.com:39484/keepshopping"); 
        MongoClient client = new MongoClient(uri);
        db = client.getDB(uri.getDatabase());
	}
	
	public static MongoDBConnection getMongoDBConnection(String databasename){
		if(mongoDBConnection==null){
			mongoDBConnection=new MongoDBConnection(databasename);
		}
		return mongoDBConnection;
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
	
	public List<Item> getAllDocuments(){
		DBCursor cursor = collection.find();
		List<DBObject> dbObjects=cursor.toArray();
		List<Item> items=new ArrayList<Item>();
		
		
		for(DBObject dbObject:dbObjects){
		//	item.setItemId((String)dbObject.get("_id"));
			Item item=new Item();
			item.setItemName((String)dbObject.get("itemName"));
			item.setPrice((Double)dbObject.get("price"));
			item.setQuantity((double)dbObject.get("quantity"));
			item.setQuantityLeft((double)dbObject.get("quantityLeft"));
			//System.out.println(item.toString());
			items.add(item);
		}
		
		
		
		return items;
	}
}
