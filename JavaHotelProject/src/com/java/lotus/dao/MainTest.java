package com.java.lotus.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.java.lotus.model.MenuItem;

public class MainTest {
	
	public static void main(String[] args) 
	{

		MenuItemDaoCollectionImpl menuItem = new MenuItemDaoCollectionImpl();
		
		List<MenuItem> menu = new ArrayList<>();
		
		menu = menuItem.getMenuItemListAdmin();
		
		System.out.println(menu);
		
		menu = menuItem.getMenuItemListCustomer();
		
		System.out.println(menu);
		
		MenuItem item = new MenuItem();
		
		item = menuItem.getMenuItem(2);
		
		System.out.println(item);
		
		MenuItem modifyItem = new MenuItem();
		Date setDate = new Date(121, 11, 8);
		
		modifyItem.setId(0);
		modifyItem.setName("Pineapple Pizza");
		modifyItem.setPrice(155.00f);
		modifyItem.setActive(false);
		modifyItem.setCategory("Weird");
		modifyItem.setDateOfLaunch(setDate);
		modifyItem.setFreeDelivery(false);
		
		menuItem.modifyMenuItem(modifyItem);
		
		menu = menuItem.getMenuItemListCustomer();
		
		System.out.println(menu);
		
		menu = menuItem.getMenuItemListAdmin();
		
		System.out.println(menu);
		
		CartDaoCollectionImpl cart = new CartDaoCollectionImpl();
		
		cart.addCartItem(1, 1);
		cart.addCartItem(1, 0);
		
		cart.removeCartItem(1, 1);
		cart.removeCartItem(1, 0);
		
		try 
		{
			List<MenuItem> userCart = cart.getAllCartItems(1);
			
			System.out.println(userCart);
		} catch (CartEmptyExc e) 
		{

			e.printStackTrace();
		}
	}

}
