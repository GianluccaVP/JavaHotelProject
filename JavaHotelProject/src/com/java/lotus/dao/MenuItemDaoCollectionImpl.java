package com.java.lotus.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.java.lotus.model.MenuItem;


public class MenuItemDaoCollectionImpl implements MenuItemDao {

	List<MenuItem> menuItemList = null;

	public List<MenuItem> getMenuItemListAdmin() 
	{
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() 
	{
		List<MenuItem> availableMenuItemList = new ArrayList<>();
		
		Date todayDate = new Date();
		
		for(MenuItem item : menuItemList)
		{
			if((todayDate.getDate() == item.getDateOfLaunch().getDate() || item.getDateOfLaunch().before(todayDate)) && item.isActive())
			{
				availableMenuItemList.add(item);
			}
		}
		return availableMenuItemList;
	}

	public void modifyMenuItem(MenuItem menuItem) 
	{
		for(MenuItem item : menuItemList)
		{
			if(item.equals(menuItem))
			{
				item.setId(menuItem.getId());
				item.setName(menuItem.getName());
				item.setPrice(menuItem.getPrice());
				item.setActive(menuItem.isActive());
				item.setCategory(menuItem.getCategory());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setFreeDelivery(menuItem.isFreeDelivery());
				System.out.println("Item modified!");
				return;
			}
		}
		System.out.println("The Item could not be found");
		return;
	}

	public MenuItem getMenuItem(long menuItemId) 
	{
		for(MenuItem item : menuItemList)
		{
			if(item.getId() == menuItemId)
			{
				return item;
			}
		}
		System.out.println("The Item could not be found");
		return null;
	}
	
	public MenuItemDaoCollectionImpl()
	{
		if(menuItemList == null)
		{
			menuItemList = new ArrayList<MenuItem>();
			
			MenuItem firstItem = new MenuItem();
			MenuItem secondItem = new MenuItem();
			MenuItem thirdItem = new MenuItem();
			MenuItem fourthItem = new MenuItem();
			MenuItem fifthItem = new MenuItem();
			
			Date setDate = new Date(121, 11, 5);
			
			firstItem.setId(0);
			firstItem.setName("Pineapple Pizza");
			firstItem.setPrice(149.00f);
			firstItem.setActive(true);
			firstItem.setCategory("Main Course");
			firstItem.setDateOfLaunch(setDate);
			firstItem.setFreeDelivery(false);
			
			setDate = new Date(121, 11, 9);
			
			secondItem.setId(1);
			secondItem.setName("Temaki");
			secondItem.setPrice(20.00f);
			secondItem.setActive(false);
			secondItem.setCategory("Main Course");
			secondItem.setDateOfLaunch(setDate);
			secondItem.setFreeDelivery(false);
			
			setDate = new Date(121, 11, 12);
			
			thirdItem.setId(2);
			thirdItem.setName("Bread Sticks");
			thirdItem.setPrice(10.00f);
			thirdItem.setActive(true);
			thirdItem.setCategory("Starter");
			thirdItem.setDateOfLaunch(setDate);
			thirdItem.setFreeDelivery(false);
			
			setDate = new Date(121, 11, 14);
			
			fourthItem.setId(3);
			fourthItem.setName("Hamburguer");
			fourthItem.setPrice(20.00f);
			fourthItem.setActive(true);
			fourthItem.setCategory("Main Course");
			fourthItem.setDateOfLaunch(setDate);
			fourthItem.setFreeDelivery(false);
			
			setDate = new Date(121, 11, 15);
			
			fifthItem.setId(4);
			fifthItem.setName("Chocolate Cake");
			fifthItem.setPrice(13.99f);
			fifthItem.setActive(true);
			fifthItem.setCategory("Dessert");
			fifthItem.setDateOfLaunch(setDate);
			fifthItem.setFreeDelivery(false);
			
			menuItemList.add(firstItem);
			menuItemList.add(secondItem);
			menuItemList.add(thirdItem);
			menuItemList.add(fourthItem);
			menuItemList.add(fifthItem);
		}
	}
}
