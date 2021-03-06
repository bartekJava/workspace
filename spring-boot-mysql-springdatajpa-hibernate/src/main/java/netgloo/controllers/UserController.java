package netgloo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.models.User;
import netgloo.models.UserDao;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping("/create")
	@ResponseBody
	public String create(String email, String name) {
		String userId = "";
		try {
			User user = new User(email, name);
			userDao.save(user);
			userId = String.valueOf(user.getId());
		}
		catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			User user = new User(id);
			userDao.delete(user);
		}
		catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}
	
	
	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId = "";
		try {
			User user = userDao.findByEmail(email);
			userId = String.valueOf(user.getId());
		} 
		catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String email, String name) {
		try {
			User user = userDao.findOne(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		} 
		catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}
}
