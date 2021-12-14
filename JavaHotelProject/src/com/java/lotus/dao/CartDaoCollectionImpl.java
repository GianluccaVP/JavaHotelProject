package com.java.lotus.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.java.lotus.model.Cart;
import com.java.lotus.model.MenuItem;


public class CartDaoCollectionImpl implements CartDao {

HashMap<Long, Cart> userCarts = null;
	
	public void addCartItem(long userId, long menuItemId) 
	{
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		
		MenuItem desiredMenuItem = menuItemDao.getMenuItem(menuItemId);
		
		if(desiredMenuItem == null)
		{
			return;
		}
		
		if(userCarts.containsKey(userId))
		{
			Cart currentUserCart = userCarts.get(userId);
			
			List<MenuItem> currentUserMenuItemList = currentUserCart.getMenuItemList();

			currentUserMenuItemList.add(desiredMenuItem);
			
			System.out.println("Item added!");
			return;
		}
		else
		{
			Cart currentUserCart = new Cart();
			
			List<MenuItem> currentUserNewMenuItemList = new ArrayList<MenuItem>();
			
			currentUserNewMenuItemList.add(desiredMenuItem);
			
			currentUserCart.setMenuItemList(currentUserNewMenuItemList);
			
			userCarts.put(userId, currentUserCart);
			
			System.out.println("Item added!");
			return;
		}
	}

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyExc
	{	
		if(userCarts.containsKey(userId))
		{	
			Cart currentUserCart = userCarts.get(userId);
			if(currentUserCart.getMenuItemList().size() == 0)
			{
				throw new CartEmptyExc();
			}
			else
			{
				List<MenuItem> currentUserMenuItemList = currentUserCart.getMenuItemList();
				
				for(MenuItem item : currentUserMenuItemList)
				{
					currentUserCart.setTotal(currentUserCart.getTotal() + item.getPrice()); 
				}
				
				return currentUserMenuItemList;
			}
		}
		else
		{
			System.out.println("User not found");
			return null;
		}
	}

	public void removeCartItem(long userId, long menuItemId) 
	{
		Cart currentUserCart = userCarts.get(userId);
		
		if(userCarts.containsKey(userId))
		{
			List<MenuItem> currentUserMenuItemList = currentUserCart.getMenuItemList();
			
			for(MenuItem item : currentUserMenuItemList)
			{
				if(item.getId() == menuItemId)
				{
					currentUserMenuItemList.remove(item);
					System.out.println("Item removed!");
					return;
				}
			}
			System.out.println("Item not found");
			return;
		}
		else
		{
			System.out.println("User does not exist");
			return;
		}
	}

	public CartDaoCollectionImpl()
	{
		if(userCarts == null)
		{
			userCarts = new HashMap<Long, Cart>();
		}
	}
}
