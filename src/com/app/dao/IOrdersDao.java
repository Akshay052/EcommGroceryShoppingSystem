package com.app.dao;

import java.util.List;

import com.app.pojos.Orders;
import com.app.pojos.Payment;

public interface IOrdersDao {
	
	public Orders getOrderDetails(int OrderId);
	
	public List<Orders> retrieveOrdersBySeller(int sellerId);
	
	public List<Orders> retrieveOrdersByCustomer(int CustomerId);

	public List<Orders> getAllPendingOrders();

	public boolean addOrder(Orders order);

	public boolean makePayment(Payment payment);

}
