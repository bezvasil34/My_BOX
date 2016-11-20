package ua.com.mybox.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.mybox.entity.User;
import ua.com.mybox.service.CommodityService;
import ua.com.mybox.service.MailSenderService;
import ua.com.mybox.service.UserService;
import ua.com.mybox.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MailSenderService mailSenderService;
	
	@Autowired
	private CommodityService commodityService;
	
	  @InitBinder
	    protected void initBinder(WebDataBinder binder){
	        binder.setValidator(new UserValidator(userService));
	    }
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String userhome(Model model){
		model.addAttribute("users",userService.findAll());
		 model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public String saveuser(@ModelAttribute @Valid User user,  BindingResult bindingResult){
		
		String context = "ти зареєструвався на сайті";
		String mailBody = "вітаю на сайті "+"/nВаше імя";
		
		mailSenderService.sendMail(context, user.getEmail(), mailBody);
		
		   if(bindingResult.hasErrors()){
	            return "registration";
	        }
	        userService.save(user);
//		
//		 try {
//		userService.save(user);
//		 }catch (Exception e){
//	            return "error_username";
//	        }
		
		
		return "redirect:/home";
	}
	
	@RequestMapping(value="/del/{id}", method=RequestMethod.GET)
	public String delUser(@PathVariable String id){
		userService.delete(Integer.parseInt(id));
		return "redirect:/myprofile";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String updateUser(Principal principal, Model model){
		
		User user=userService.findOne(Integer.parseInt(principal.getName()));
		model.addAttribute("user", user);
		
		return "updateUser";
	}
	@RequestMapping(value="/update/home", method=RequestMethod.GET)
	public String homeee(){
		
		return "home";
	}
	@RequestMapping(value="/update/myprofile", method=RequestMethod.GET)
	public String myprofile(){
		
		return "myprofile";
	}
	
	@RequestMapping(value="/update/saveUpdateUser/{id}", method=RequestMethod.POST)
	public String update(Principal principal,@RequestParam String newName,@RequestParam String newSurname,@RequestParam String newEmail,@RequestParam String newUsername, @RequestParam String newPhone){
		
		User user=userService.findOne(Integer.parseInt(principal.getName()));
		user.setPhone(newPhone);
		user.setUsername(newUsername);
		user.setName(newName);
		user.setSurname(newSurname);
		user.setEmail(newEmail);
		
		userService.save(user);
		
		return "redirect:/myprofile";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "loginpage";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(){
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public String home(){
	
		return "redirect:/home";
	}
	
	
	
	@RequestMapping(value="/loginprocesing", method=RequestMethod.POST)
	public String loginprocesing(){
	
		return "redirect:/";
	}
	
//	  @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
//	    public String profile(Model model, Principal principal){
//	        User user = userService.findUserFetch(Integer.parseInt(principal.getName()));
//	        model.addAttribute("user", user);
//	        
//	        return "myprofile";
//	    }
//  
	  @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	    public String saveImage(Principal principal,
	                            @RequestParam MultipartFile image){

	       userService.saveImage(principal, image);

	        return "redirect:/myprofile";
	  }
	  
	  
	  
//	    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
//	    public String getOrder(Principal principal, @PathVariable String id){
//	    
//	    	userService.getOrder(principal, id);
//	    	
//	        return "redirect:/home";
//	    }
	    
//	    @RequestMapping(value = "/deleteCommodityFromUser/{id}", method = RequestMethod.GET)
//	    public String deleteCommodityFromUser(Principal principal, @PathVariable String id){
//
//	        userService.deleteCommodityFromUser(principal, id);
//
//	        return "redirect:/myprofile";
//	    }
//	
}
