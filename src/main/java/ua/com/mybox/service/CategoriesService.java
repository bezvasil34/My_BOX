package ua.com.mybox.service;

import java.util.List;

import ua.com.mybox.entity.Categories;

public interface CategoriesService {

	

	void save(Categories categories);
	
	List<Categories> findAll();
	
	Categories findOne(int id);
	
	void delete(int id);
}
