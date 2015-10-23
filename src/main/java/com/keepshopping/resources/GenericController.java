package com.keepshopping.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.keepshopping.model.Item;
import com.keepshopping.service.KeepShoppingService;

@Path("kscontrl")
public class GenericController {

	 private ArrayList<Item> items;
	    private KeepShoppingService keepShoppingService;
	    
	    public GenericController(){
	    	keepShoppingService=new KeepShoppingService("keepshopping");
	    }
	    
	    @GET
	    @Path("{collectionName}")
	    @Produces(MediaType.APPLICATION_XML)
	    public List<Item> getIt(@PathParam("collectionName") String collectionName) {
//	    	System.out.println("In generic controller");
	        List<Item> items=new ArrayList<Item>();
	        items=keepShoppingService.fetchAllDocuments(collectionName);
	        return items;
	    }
	    
	    @POST
	    @Path("{collectionName}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public void insertCollection(@PathParam("collectionName") String collectionName,Item item){
	    	System.out.println(item.toJson());
	    	keepShoppingService.insertCollection(collectionName,item);
	    	
	    }
}
