package ua.com.mybox.service;

import java.util.List;

import ua.com.mybox.entity.Producer;

public interface ProducerService {


	void save(Producer producer);
	
	List<Producer> findAll();
	
	Producer findOne(int id);
	
	void delete(int id);
	
	List<Producer> allFetch();
}
