package ua.com.mybox.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.mybox.entity.User;

public interface UserService {

	
	void save(User user);
	
	List<User> findAll();
	
	User findOne(int id);
	
	void delete(int id);
	
	 User findUserFetch(int id);
	   void saveImage(Principal principal, MultipartFile multipartFile);
	   void getOrder(Principal principal, String id);
	   void deleteCommodityFromUser(Principal principal, String id);
	
	    User findByUsername(String username);

	    User findByEmail(String email);
	
}
