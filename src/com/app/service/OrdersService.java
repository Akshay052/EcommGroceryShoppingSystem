package com.app.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICartDao;
import com.app.dao.IOrdersDao;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Customer;
import com.app.pojos.Orders;
import com.app.pojos.Payment;

@Service
public class OrdersService implements IOrdersService {

	@Autowired
	IOrdersDao orderDao;

	@Autowired
	ICartDao cartDao;

	@Override
	public boolean addOrders(Customer customer, Payment payment) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			Cart cart = customer.getCart();
			System.out.println("cart in addorders:" + cart);
			for (CartItem cartItem : cart.getCartItems()) {

				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date dateobj = new Date();
				String date = sdf.format(dateobj);
				System.out.println(date);

				Orders order = new Orders(date, cartItem.getProduct().getProductName(),
						cartItem.getProduct().getWeight(), cartItem.getQuantity(), cartItem.getValue(),
						customer.getBillingAddress(), customer.getShippingAddress());

				order.setCustomer(customer);
				order.setSeller(cartItem.getProduct().getSeller());
				order.setPayment(payment);
				System.out.println("Order:" + order);
				orderDao.addOrder(order);
				System.out.println("order placed:" + order);
				
			}
			System.out.println("all orders placed");
			for (CartItem cartItem : cart.getCartItems()) {
				cartDao.deleteCartItem(cartItem.getCartItemId());
			}
			cartDao.deleteCart(cart);
			System.out.println("cart cleared ");
			
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public Payment makePayment(Customer customer) throws Exception {
		Payment payment;
		try {

			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dateobj = new Date();
			String date = sdf.format(dateobj);
			System.out.println(date);
			payment = new Payment(customer.getCart().getAmount(), date);
			orderDao.makePayment(payment);

		} catch (Exception e) {
			throw e;
		}
		return payment;
	}

}
