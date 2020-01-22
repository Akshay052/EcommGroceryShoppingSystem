package com.app.service;

import com.app.pojos.Customer;
import com.app.pojos.Payment;

public interface IOrdersService {

	boolean addOrders(Customer customer, Payment payment) throws Exception;

	Payment makePayment(Customer customer) throws Exception;
	
}
