package com.app.dao;

import java.util.List;

import com.app.pojos.Orders;
import com.app.pojos.Product;

public interface IOrdersDao {
	
	public Orders getOrderDetails(int OrderId);
	
	public List<Orders> retrieveOrdersBySeller(int sellerId);
	
	public List<Orders> retrieveOrdersByCustomer(int CustomerId);

	public List<Orders> getAllPendingOrders();

	
}
