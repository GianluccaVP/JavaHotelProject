package com.java.lotus.dao;

import java.util.List;
import com.java.lotus.model.MenuItem;


public interface CartDao {
	
public void addCartItem(long userId, long menuItemId);
	
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyExc; 
	
	public void removeCartItem(long userId, long menuItem);

}
