package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ISellerDao;
import com.app.pojos.Seller;

@Service
public class SellerService implements ISellerService {

	@Autowired
	ISellerDao sellerDao;
	
	@Override
	public List<Seller> getSellerList() {
		// TODO Auto-generated method stub
		List<Seller> sellers= sellerDao.getSellerList();
		if(sellers!=null)
			return  sellers;
		return null;
	}

	@Override
	public Seller getSellerDetails(int id) {
		// TODO Auto-generated method stub
		return sellerDao.getDetails(id);
	}

	@Override
	public boolean addSeller(Seller s) {
		// TODO Auto-generated method stub
		return sellerDao.addSeller(s);
	}

	@Override
	public boolean updateSeller(int id, Seller s) {
		// TODO Auto-generated method stub
		return sellerDao.updateSeller(id,s);
	}

	@Override
	public boolean deleteSeller(int id) {
		// TODO Auto-generated method stub
		return sellerDao.deleteSeller(id);
	}

	@Override
	public Seller authenticateSeller(String email, String password) {
		// TODO Auto-generated method stub
		
		return sellerDao.authenticateSeller(email,password);
	}

}
