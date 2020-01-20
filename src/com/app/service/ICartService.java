package com.app.service;

import javax.servlet.http.HttpSession;

import com.app.pojos.Cart;
import com.app.pojos.CartItem;

public interface ICartService {

	public Cart getCartDetails(int cartId);
	
	public CartItem getCartItemDetails(int cartItemid);
	
	boolean addCartItem(int productId, Cart cart);
	
	public boolean updateCartItem(int cartItemId, int quantity);
	
	boolean deleteCart(Cart cart);
	
	public boolean deleteCartItem(int cartItemId);



	


}
