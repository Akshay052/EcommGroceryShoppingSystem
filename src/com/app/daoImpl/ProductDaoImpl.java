package com.app.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.pojos.Product;

@Repository
@Transactional
public class ProductDaoImpl implements IProductDao {

	@Autowired
	SessionFactory sf;

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			sf.getCurrentSession().persist(product);
			status=true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			Session hs=sf.getCurrentSession();
			Product product=hs.get(Product.class, productId);
			hs.delete(product);
			status=true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public List<Product> retrieveProductsBySeller(int id) {
		// TODO Auto-generated method stub
	
		List<Product> products=new ArrayList<>();
		String jpql="select p from Product where p.seller.sellerId=:id";
		try {
			products=sf.getCurrentSession().createQuery(jpql,Product.class).setParameter("id", id).getResultList();
			
		} catch (Exception e) {
			throw e;
		}
		return products;
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Product product;
		try {
			product=sf.getCurrentSession().get(Product.class, productId);
		} catch (Exception e) {
			return null;
		}
		return product;
	}

	@Override
	public boolean updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			sf.getCurrentSession().update(product);
			status=true;
			
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public List<Product> retrieveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<>();
		String jpql="select p from Product where p.category.categoryId=:id";
		try {
			products=sf.getCurrentSession().createQuery(jpql,Product.class).setParameter("id", categoryId).getResultList();
			
		} catch (Exception e) {
			throw e;
		}
		return products;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<>();
		String jpql="select p from Product p";
		try {
			products=sf.getCurrentSession().createQuery(jpql,Product.class).getResultList();
			
		} catch (Exception e) {
			throw e;
		}
		return products;
	}

}