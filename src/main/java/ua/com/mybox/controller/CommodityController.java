package ua.com.mybox.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.mybox.entity.Categories;
import ua.com.mybox.entity.Commodity;
import ua.com.mybox.entity.Producer;
import ua.com.mybox.service.CategoriesService;
import ua.com.mybox.service.CommodityService;
import ua.com.mybox.service.ProducerService;

@Controller
public class CommodityController {

	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping(value="/commodity", method=RequestMethod.GET)
	public String CommodityHome(Model model){
		
		model.addAttribute("commodity", new Commodity());
		model.addAttribute("commodities", commodityService.allFetch());
		model.addAttribute("producers", producerService.findAll());
		
		return "commodity";
	}
	
	@RequestMapping(value="/newCommodity", method=RequestMethod.POST)
	public String savecommodity(@RequestParam String nameOfCommodity,@RequestParam String price,@RequestParam String description,@RequestParam String [] choosenProducers){
		
		Commodity commodity= new Commodity(nameOfCommodity,price,description);
		
	
		
		List<Producer> producers = new ArrayList<Producer>();
		
		for (int i = 0; i < choosenProducers.length; i++) {
			producers.add(producerService.findOne(Integer.parseInt(choosenProducers[i])));
		}
	
		commodity.setProducers(producers);
	
		commodityService.save(commodity);
		
		return "redirect:/commodity";
	
	}
	
	@RequestMapping(value = "/sort", method = RequestMethod.POST)
	public String sort(Model model) {
		List<Commodity> commodities = commodityService.findAll();
//		commodities.sort((c1, c2) -> c1.getNameOfCommodity().compareTo(c2.getOriginNameOfCommodity()));
		
		Collections.sort(commodities, new Comparator<Commodity>() {

			@Override
			public int compare(Commodity o1, Commodity o2) {
			
				return o1.getNameOfCommodity().compareTo(o2.getNameOfCommodity());
			}
		});
		
		model.addAttribute("commoditiesSort", commodities);
		System.out.println("sort");
		return "commodity";
	}
	
	 @RequestMapping(value = "/saveCommodityImage", method = RequestMethod.POST)
	    public String saveCommodityImage(@RequestParam String commodityID,@RequestParam("image") MultipartFile image){

	      commodityService.saveCommodityImage(image, commodityID);

	        return "redirect:/commodity";
	  }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
		public String delComm(@PathVariable String id){
			commodityService.delete(Integer.parseInt(id));
			return "redirect:/commodity";
	 }
}
