package com.java.lotus.model;

import java.util.ArrayList;
import java.util.List;


public class Cart {

private List<MenuItem> menuItemList = new ArrayList<MenuItem>();
	
	private double total;

	public String toString() 
	{
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

	public List<MenuItem> getMenuItemList() 
	{
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) 
	{
		this.menuItemList = menuItemList;
	}

	public double getTotal() 
	{
		return total;
	}

	public void setTotal(double total) 
	{
		this.total = total;
	}
}
