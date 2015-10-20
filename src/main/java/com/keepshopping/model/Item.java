package com.keepshopping.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item{
    
    private String itemId;
    private String itemName;
    private double price;
    private double quantity;
    private double quantityLeft;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getQuantityLeft() {
		return quantityLeft;
	}
	public void setQuantityLeft(double quantityLeft) {
		this.quantityLeft = quantityLeft;
	}
    
    public String toString(){
    	return this.itemName+" "+this.price+" "+" "+this.quantity+" "+this.quantityLeft;
    }
}