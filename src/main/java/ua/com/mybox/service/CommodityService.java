package ua.com.mybox.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.mybox.entity.Commodity;
import ua.com.mybox.entity.Producer;

public interface CommodityService {


	void save(Commodity commodity);
	
	List<Commodity> findAll();
	
	Commodity findOne(int id);
	
	void delete(int id);
	
	List<Commodity> allFetch();
	
	 void saveCommodityImage(MultipartFile multipartFile,String id);
	
	
}
