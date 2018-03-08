package org.vaibhavi.webapps.telenotes.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vaibhavi.webapps.telenotes.model.User;
import org.vaibhavi.webapps.telenotes.service.UserService;


@Path("/data")
public class UserResource {
	
	UserService userService = new UserService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
}

