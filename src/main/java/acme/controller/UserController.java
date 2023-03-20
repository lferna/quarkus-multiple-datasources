package acme.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import acme.response.UserResponse;
import acme.service.UserService;

@Path(value = "/api/v1/user")
public class UserController {

	@Inject
	UserService userService;
	
	@Path(value = "/{userId}")
	@Produces(value = MediaType.APPLICATION_JSON)	
	@GET
	public UserResponse getUser(@PathParam(value = "userId") Integer userId) {
		return userService.getUser(userId);
	}
}
