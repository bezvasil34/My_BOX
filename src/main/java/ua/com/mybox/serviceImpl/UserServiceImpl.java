package ua.com.mybox.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.mybox.entity.Categories;
import ua.com.mybox.entity.Commodity;

import ua.com.mybox.entity.Role;
import ua.com.mybox.entity.User;
import ua.com.mybox.repository.CategoriesRepository;
import ua.com.mybox.repository.CommodityRepository;

import ua.com.mybox.repository.UserRepository;
import ua.com.mybox.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private CommodityRepository commodityRepository;
	
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	
	
	
	public void save(User user) {
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}

	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	public User findOne(int id) {
		
		return userRepository.findOne(id);
	}

	public void delete(int id) {
		userRepository.delete(id);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(username);
	}



	@Override
	public void saveImage(Principal principal, MultipartFile multipartFile) {

	        User user = userRepository.findOne(Integer.parseInt(principal.getName()));

	        String path = System.getProperty("catalina.home")+"/resources/"
	                + user.getOriginUsername() + "/" +multipartFile.getOriginalFilename();

	        user.setPathImage("resources/"+user.getOriginUsername()+ "/" + multipartFile.getOriginalFilename());

	        File file = new File(path);

	        try {
	            file.mkdirs();
	           
	            try {
	                FileUtils.cleanDirectory
	                        (new File(System.getProperty("catalina.home")+"/resources/" + user.getOriginUsername() + "/"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home")+"/resources/" + user.getOriginUsername()+ "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	            multipartFile.transferTo(file);
	        } catch (IOException e) {
	            System.out.println("error with file");
	        }
	        userRepository.save(user);
		
	}


	@Override
	public void deleteCommodityFromUser(Principal principal, String id) {
		   User user = userRepository.findfetchUser(Integer.parseInt(principal.getName()));

	        Commodity commodity = commodityRepository.findOne(Integer.parseInt(id));

	        user.getCommodities().remove(commodity);

	        userRepository.save(user);
		
	}

	@Override
	public User findUserFetch(int id) {
		
		 return userRepository.findfetchUser(id);
	}

	
	@Override
	@Transactional
	public void getOrder(Principal principal, String id) {
		
		  User user = userRepository.findfetchUser(Integer.parseInt(principal.getName()));

	        Commodity commodity = commodityRepository.findOne(Integer.parseInt(id));

	        user.getCommodities().add(commodity);

	        userRepository.save(user);
	
	
		
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}




}
