package ua.com.mybox.controller;

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

@Controller
public class CategoriesController {

	
	@Autowired
	public CategoriesService categoriesService;
	
	
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public String CategoriesHome(Model model){	
		model.addAttribute("category", new Categories());
	
		model.addAttribute("categories", categoriesService.findAll());
		
		return "categories";
	}
	
	@RequestMapping(value="/newCategory", method=RequestMethod.POST)
	public String saveuser(@RequestParam String nameOfCategories){
		
	categoriesService.save(new Categories(nameOfCategories));
		
		return "redirect:/categories";
	
	}
	
	
}
