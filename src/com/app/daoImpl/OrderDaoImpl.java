package com.app.daoImpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrdersDao;
import com.app.pojos.Orders;

@Repository
@Transactional
public class OrderDaoImpl implements IOrdersDao {
	
	@Autowired
	SessionFactory sf;
	
	@Override
	public Orders getOrderDetails(int OrderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> retrieveOrdersBySeller(int sellerId) {
		// method returns list of all customers
				List<Orders> orders;
				String jpql = "select o from Orders o where o.orderId:=sellerId ";

				try {
					orders = sf.getCurrentSession().createQuery(jpql, Orders.class).setParameter("sellerId", sellerId).getResultList();
				} catch (Exception e) {
					throw e;
				}
				return orders;
	}

	@Override
	public List<Orders> retrieveOrdersByCustomer(int CustomerId) {
		List<Orders> orders;
		String jpql = "select o from Orders o where o.CustomerId:=CustomerId ";

		try {
			orders = sf.getCurrentSession().createQuery(jpql, Orders.class).setParameter("CustomerId", CustomerId).getResultList();
		} catch (Exception e) {
			throw e;
		}
		return orders;
	}

	@Override
	public List<Orders> getAllPendingOrders() {
		List<Orders> orders;
		String jpql = "select o from Orders o where o.Status:=pending ";

		try {
			orders = sf.getCurrentSession().createQuery(jpql, Orders.class).getResultList();
		} catch (Exception e) {
			throw e;
		}
		return orders;
	}

	@Override
	public boolean addOrder(Orders order) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			sf.getCurrentSession().save(order);
			status=true;
		}
		catch(Exception e) {
			throw e;
		}
		return status;
	}

}
