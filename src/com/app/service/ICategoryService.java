package com.app.service;

import java.util.List;

import com.app.pojos.Category;;

public interface ICategoryService {

	public List<Category> getCategoryList();

	public Category getCategoryDetails(String categoryName);
}
