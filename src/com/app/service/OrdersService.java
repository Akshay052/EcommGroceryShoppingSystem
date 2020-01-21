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
			for (CartItem cartItem : cart.getCartItems()) {

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date dateobj = new Date();
				System.out.println(df.format(dateobj));
				// Date orderDate, String productName, double weight, int quantity, double
				// value, String billingAddress, String shippingAddress
				
				Orders order = new Orders(dateobj, cartItem.getProduct().getProductName(),
						cartItem.getProduct().getWeight(), cartItem.getQuantity(), cartItem.getValue(),
						customer.getBillingAddress(), customer.getShippingAddress());
				
				order.setCustomer(customer);
				order.setSeller(cartItem.getProduct().getSeller());
				order.setPayment(payment);
				
				orderDao.addOrder(order);
				System.out.println("order placed:"+order);

			}
			cartDao.deleteCart(cart);
			System.out.println("cart cleared orderplaced");
			status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

}
