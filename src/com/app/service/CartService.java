package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICartDao;
import com.app.dao.IProductDao;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Product;

@Service
public class CartService implements ICartService {

	@Autowired
	private ICartDao cartDao;

	@Autowired
	private IProductDao productDao;

	@Override
	public Cart getCartDetails(int cartId) {
		// TODO Auto-generated method stub
		Cart cart;

		try {

			cart = cartDao.getCartDetails(cartId);

		} catch (Exception e) {
			throw e;
		}
		return cart;
	}

	@Override
	public CartItem getCartItemDetails(int cartItemId) {
		CartItem cartItem = null;
		try {
			cartItem = cartDao.getCartItemDetails(cartItemId);
		}
		catch(Exception e) {
			throw e;
		}
		return cartItem;
		
	}
	
	@Override
	public boolean addCartItem(int productId, Cart cart) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			// fetch product by id
			Product product = productDao.getProduct(productId);
			// create new cart item
			CartItem cartItem = new CartItem(1, product.getPrice());
			// add product as cartItem
			cartItem.setProduct(product);
			cart.setAmount(cart.getAmount()+cartItem.getValue());
			//add cart item to cart
			cartItem.setCart(cart);
			// persist cartItem
			cartDao.addCartItem(cartItem);
		} catch (Exception e) {

		}

		return status;
	}

	@Override
	public boolean updateCartItem(int cartItemId, int quantity) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			CartItem cartItem = cartDao.getCartItemDetails(cartItemId);
			
			cartItem.setQuantity(quantity);
			cartItem.setValue(cartItem.getValue() * quantity);
			
			cartDao.updateCartItem(cartItem);
			status = true;
		
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean deleteCart(Cart cart) {
		boolean status = false;
		try {
			cartDao.deleteCart(cart);
			status = true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}
	
	@Override
	public boolean deleteCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			
			cartDao.deleteCartItem(cartItemId);
			status = true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}

	
}
