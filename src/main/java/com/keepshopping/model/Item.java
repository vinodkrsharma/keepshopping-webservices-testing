package com.keepshopping.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item{

	private String itemId;
	private String itemName;
	private double itemPrice;
	private String itemQuantity;
	private String itemQuantityLeft;
	private String itemType;


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}


	public String getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public String getItemQuantityLeft() {
		return itemQuantityLeft;
	}


	public void setItemQuantityLeft(String itemQuantityLeft) {
		this.itemQuantityLeft = itemQuantityLeft;
	}


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public String toString(){
		return this.itemName+" "+this.itemPrice+" "+" "+this.itemQuantity+" "+this.itemQuantityLeft+" "+this.itemType;
	}
}