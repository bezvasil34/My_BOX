package ua.com.mybox.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.mybox.entity.Commodity;
import ua.com.mybox.entity.Producer;
import ua.com.mybox.repository.CommodityRepository;
import ua.com.mybox.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService {
	
	
	@Autowired
	private CommodityRepository commodityRepository;

	public void save(Commodity commodity) {
		commodityRepository.save(commodity);
		
	}

	public List<Commodity> findAll() {
	
		return commodityRepository.findAll();
	}

	public Commodity findOne(int id) {
		
		return commodityRepository.findOne(id);
	}

	public void delete(int id) {
		commodityRepository.delete(id);
		
	}

	@Override
	public List<Commodity> allFetch() {
	
		return commodityRepository.findAllByFetch();
	}

	@Override
	public void saveCommodityImage(MultipartFile multipartFile,String commodityID) {
		 Commodity commodity=commodityRepository.findOne(Integer.parseInt(commodityID));
		 
		 String path = System.getProperty("catalina.home")+"/resources/"
	                + commodity.getOriginNameOfCommodity() + "/" +multipartFile.getOriginalFilename();
		 
		 commodity.setPathImage("resources/"+commodity.getOriginNameOfCommodity()+ "/" + multipartFile.getOriginalFilename());

	        File file = new File(path);
	        
	        try {
	            file.mkdirs();
	           
	            try {
	                FileUtils.cleanDirectory
	                        (new File(System.getProperty("catalina.home")+"/resources/" + commodity.getOriginNameOfCommodity() + "/"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home")+"/resources/" + commodity.getOriginNameOfCommodity()+ "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	            multipartFile.transferTo(file);
	        } catch (IOException e) {
	            System.out.println("error with file");
	        }
	        commodityRepository.save(commodity);
		 
	}



}
