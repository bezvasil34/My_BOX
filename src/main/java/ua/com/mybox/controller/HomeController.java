package ua.com.mybox.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.mybox.entity.Commodity;
import ua.com.mybox.repository.CommodityRepository;
import ua.com.mybox.service.CommodityService;
import ua.com.mybox.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private CommodityService commodityService;
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model){
		
		 model.addAttribute("commodities", commodityService.findAll());
		return "home";
		
	}
		@RequestMapping(value="/home", method=RequestMethod.GET)
		public String register(Model model,Principal principal){
		//	model.addAttribute("userAuth", userService.findOne(Integer.parseInt(principal.getName())));
			 model.addAttribute("commodities", commodityService.findAll());
			return "home";	
		
	}
	
}
