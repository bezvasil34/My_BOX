package ua.com.mybox.serviceImpl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.mybox.entity.Commodity;
import ua.com.mybox.entity.User;
import ua.com.mybox.service.CommodityService;
import ua.com.mybox.service.MailSenderService;
import ua.com.mybox.service.UserService;

@Service
public class ProfileServiceImpl {
    @Autowired
    private UserService userService;
    @Autowired
    private CommodityService commodityService;
    
    @Autowired
    private MailSenderService mailSenderService;

    public List<Commodity> basket(HttpServletRequest request) {
        request.getSession(false);
        ArrayList<Commodity> commodities = new ArrayList<>();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("JSESSIONID")) {
            } else {
                commodities.add(commodityService.findOne(Integer.parseInt(cookie.getValue())));
            }
        }
        return commodities;

    }

    public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {
        request.getSession(false);
        Commodity commodity = commodityService.findOne(id);
String n=commodity.getNameOfCommodity();
n=n.replaceAll("_", "_");
       
        Cookie cookieCommodity = new Cookie(n, String.valueOf(commodity.getId()));
        cookieCommodity.setMaxAge(24 * 60 * 60 * 60);
        cookieCommodity.setHttpOnly(true);
        cookieCommodity.setPath("/");
        return cookieCommodity;
    }
    @Transactional
    public void getOrder(Principal principal, String id, HttpServletRequest request,
                         HttpServletResponse response) {
        User user = userService.findUserFetch(Integer.parseInt(principal.getName()));
        Commodity commodity = commodityService.findOne(Integer.parseInt(id));
        Hibernate.initialize(user.getCommodities());
        user.getCommodities().add(commodity);
        
        String context = "Здійснено замовлення";
		String mailBody = "Ім'я"+user.getName()+" "+"n/Прізвище"+" "+user.getSurname()+" "+"n/Ел. пошта"+" "+user.getEmail()+" "+"n/Телефон "+" "+user.getPhone()+" "
        +"n/Товар"+" "+commodity.getNameOfCommodity()+" "+"n/Цена"+commodity.getPrice();
		
		mailSenderService.sendMail(context, "bezvasil34@gmail.com", mailBody);

        Cookie[] cookies = request.getCookies();
        sortCookie(cookies, id, response);

    }

    public void deleteCookie(String id, HttpServletRequest request,
                             HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        sortCookie(cookies, id, response);
    }


    public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
        for (int i = 0; i < cookies.length; i++) {
            if (id.equals(cookies[i].getValue())) {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setPath("/");
                cookie.setValue(null);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

    


}
}
