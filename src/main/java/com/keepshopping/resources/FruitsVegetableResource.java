package com.keepshopping.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.keepshopping.database.MongoDBDao;
import com.keepshopping.model.Item;
import com.keepshopping.service.KeepShoppingService;

@Path("fruitvegetable")
public class FruitsVegetableResource{
    
    private ArrayList<Item> items;
    private MongoDBDao mongoDBConnection;
    private KeepShoppingService keepShoppingService;
    
    public FruitsVegetableResource(){
    	keepShoppingService=new KeepShoppingService("keepshopping");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Item> getIt() {
        List<Item> items=new ArrayList<Item>();
        items=keepShoppingService.fetchAllDocuments("Confectionary");
        return items;
    }
}