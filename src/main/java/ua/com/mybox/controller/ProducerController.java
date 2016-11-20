package ua.com.mybox.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.mybox.entity.Categories;
import ua.com.mybox.entity.Commodity;
import ua.com.mybox.entity.Producer;
import ua.com.mybox.service.CategoriesService;
import ua.com.mybox.service.ProducerService;

@Controller
public class ProducerController {

	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping(value="/producer", method=RequestMethod.GET)
	public String CommodityHome(Model model){
		
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("categories", categoriesService.findAll());
		return "producer";
	}
	
	@RequestMapping(value="/newProducer", method=RequestMethod.POST)
	public String saveuser(@RequestParam String nameOfProducer,@RequestParam String [] choosenCategories){
		
		 Producer producer = new Producer(nameOfProducer);
		
	List<Categories> categories= new ArrayList<Categories>();
		 
		for (int i = 0; i < choosenCategories.length; i++) {
			categories.add(categoriesService.findOne(Integer.parseInt(choosenCategories[i])));
			
		}
		producer.setCategories(categories);
		producerService.save(producer);
		
		return "redirect:/producer";
	
	}
}
