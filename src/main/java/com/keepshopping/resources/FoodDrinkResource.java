package com.keepshopping.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.keepshopping.model.Item;
import com.keepshopping.service.KeepShoppingService;

public class FoodDrinkResource {
	  
    private ArrayList<Item> items;
    private KeepShoppingService keepShoppingService;
    
    public FoodDrinkResource(){
    	keepShoppingService=new KeepShoppingService("keepshopping");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Item> getIt() {
        List<Item> items=new ArrayList<Item>();
        items=keepShoppingService.fetchAllDocuments("FoodDrink");
        return items;
    }
}
