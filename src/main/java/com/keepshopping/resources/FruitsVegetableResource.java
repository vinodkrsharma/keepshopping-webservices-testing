package com.keepshopping.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.keepshopping.database.MongoDBConnection;
import com.keepshopping.model.Item;

@Path("fruitvegetable")
public class FruitsVegetableResource{
    
    private ArrayList<Item> items;
    private MongoDBConnection mongoDBConnection;
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Item> getIt() {
        List<Item> items=new ArrayList<Item>();
        
        mongoDBConnection=MongoDBConnection.getMongoDBConnection("keepshopping");
        
        mongoDBConnection.setCollection("Confectionary");
        
        
        return mongoDBConnection.getAllDocuments();
    }
}