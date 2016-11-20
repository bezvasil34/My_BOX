package ua.com.mybox.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.mybox.entity.User;
import ua.com.mybox.service.CommodityService;
import ua.com.mybox.service.MailSenderService;
import ua.com.mybox.service.UserService;
import ua.com.mybox.serviceImpl.ProfileServiceImpl;

@Controller
public class ProfileController {

	
	@Autowired
    private UserService userService;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private ProfileServiceImpl basketService;
    
    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
    public String basket(HttpServletRequest request, Model model, Principal principal) {
        User user = userService.findUserFetch((Integer.parseInt(principal.getName())));
     //   user.setPathImage((user.getPathImage().substring(43)));
        model.addAttribute("user",user);
        model.addAttribute("commodities", basketService.basket(request));
        return "myprofile";
    }

    @RequestMapping(value = "/intoBasket/{id}", method = RequestMethod.GET)
    public String intoBasket(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {

        response.addCookie(basketService.intoBasket(Integer.parseInt(id), request, response));

        return "redirect:/home";
    }


    @RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
    public String getOrder(Principal principal, @PathVariable String id, HttpServletRequest request,
                           HttpServletResponse response) {
    	
    	

        basketService.getOrder(principal, id, request, response);
        

        return "redirect:/myprofile";
    }

    @RequestMapping(value = "/deleteCookie/{id}", method = RequestMethod.GET)
    public String deleteCookie(@PathVariable String id, HttpServletRequest request,
                               HttpServletResponse response) {

        basketService.deleteCookie(id, request, response);

        return "redirect:/myprofile";
    }

}
