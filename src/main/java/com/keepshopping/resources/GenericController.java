package com.keepshopping.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
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
	    	System.out.println("In generic controller");
	        List<Item> items=new ArrayList<Item>();
	        items=keepShoppingService.fetchAllDocuments(collectionName);
	        return items;
	    }
}
