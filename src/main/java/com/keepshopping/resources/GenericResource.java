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

import com.google.gson.GsonBuilder;
import com.keepshopping.model.Item;
import com.keepshopping.service.KeepShoppingService;
import com.mongodb.util.JSON;

@Path("kscontrl")
public class GenericResource {

	 private ArrayList<Item> items;
	    private KeepShoppingService keepShoppingService;
	    
	    public GenericResource(){
	    	keepShoppingService=new KeepShoppingService("keepshopping");
	    }
	    
	    @GET
	    @Path("{collectionName}")
	    @Produces(MediaType.APPLICATION_XML)
	    public List<Item> getCollectionData_XML(@PathParam("collectionName") String collectionName) {
//	    	System.out.println("In generic controller");
	        List<Item> items=new ArrayList<Item>();
	        items=keepShoppingService.fetchAllDocuments(collectionName);
	        return items;
	    }
	    
	    @GET
	    @Path("{collectionName}/json")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Item> getCollectionData_JSON(@PathParam("collectionName") String collectionName) {
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
	    	System.out.println(new GsonBuilder().setPrettyPrinting().serializeNulls().create().toJson(item));
	    	keepShoppingService.insertCollection(collectionName,item);
	    }
	    
	    @POST
	    @Path("{collectionName}/{itemId}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public void fetchDocumentbyId(@PathParam("collectionName") String collectionName,Item item){
	    		    	
	    }
}
