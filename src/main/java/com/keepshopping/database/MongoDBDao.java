package com.keepshopping.database;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.keepshopping.model.Item;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoDBDao implements DataAccessObject{

	private static MongoDBDao mongoDBDao;
	private DB db;
	private String databasename;
	private  DBCollection collection;
	private String mongoLabDatabaseURI;
	private String mongoLocalDatabaseURI;
	private Gson gson=new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	@SuppressWarnings("deprecation")
	private MongoDBDao(String databasename){
	//	mongoLabDatabaseURI="mongodb://vinod:vinod121@ds039484.mongolab.com:39484/"+databasename;
	//	mongoLocalDatabaseURI="localhost:27017/"+databasename;
	//	MongoClientURI uri  = new MongoClientURI(mongoLabDatabaseURI);
//    	MongoClient client = new MongoClient(uri);
//        db = client.getDB(uri.getDatabase());
    	MongoClient client  = new MongoClient("localhost",27017);
        db=client.getDB(databasename);
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
//		DBObject dbObject=new BasicDBObject();
		
		for(DBObject dbObject:dbObjects){
			Item item=new Item();
			/*item.setItemId((String)dbObject.get("itemId"));
			item.setItemName((String)dbObject.get("itemName"));
			item.setItemPrice(((Double)dbObject.get("itemPrice")).doubleValue());
//			item.setItemPrice(((Integer)dbObject.get("itemPrice")).intValue());
			item.setItemQuantity((String)dbObject.get("itemQuantity"));
			item.setItemQuantityLeft((String)dbObject.get("itemQuantityLeft"));
			item.setItemType((String)dbObject.get("itemType"));
//			System.out.println(item.toString());*/
			
			item=gson.fromJson(JSON.serialize(dbObject), Item.class);
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
	
	@Override
	public void insertCollection(String collectionName,Item item) {
		
		setCollection(collectionName);
		DBObject dbObject = (DBObject) JSON.parse(gson.toJson(item));
		collection.insert(dbObject);
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
