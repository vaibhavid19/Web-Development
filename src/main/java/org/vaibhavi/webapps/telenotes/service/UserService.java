package org.vaibhavi.webapps.telenotes.service;

import java.util.ArrayList;
import java.util.List;

import org.vaibhavi.webapps.telenotes.model.User;

public class UserService {
	public List<User> getAllUsers() {
		User u1 = new User("vaibhavi");
		User u2 = new User("dummy-user");
		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		
		
		return list;
	}
}
