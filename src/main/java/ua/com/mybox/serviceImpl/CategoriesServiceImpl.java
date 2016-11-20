package ua.com.mybox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.mybox.entity.Categories;
import ua.com.mybox.repository.CategoriesRepository;
import ua.com.mybox.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepository;
	
	public void save(Categories categories) {
	categoriesRepository.save(categories);
		
	}

	public List<Categories> findAll() {
		
		return categoriesRepository.findAll();
	}

	public Categories findOne(int id) {
		
		return categoriesRepository.findOne(id);
	}

	public void delete(int id) {
		categoriesRepository.delete(id);
		
	}

}
