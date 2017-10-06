package pl.altkom.hibernatejpa.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.altkom.hibernatejpa.model.User;

@Component
public class Profile {

	@Autowired
	@Qualifier("admin")
	private User user;
	
	public User getUser() {
		return user;
	}

	public Profile() {
		System.out.println("From profile constructor.");
	}

	public void printName() {
		System.out.println("Name : " + user.getFirstName());
	}
}
	