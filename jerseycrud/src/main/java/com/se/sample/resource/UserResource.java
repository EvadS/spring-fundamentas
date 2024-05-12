package com.se.sample.resource;

import com.se.sample.model.User;
import com.se.sample.services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserResource {

    private UserService userService = new UserService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> fetchAll() {
        return userService.fetchAll();
    }


    @GET
    @Path("user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        return Response.ok().entity(new User(100, "me", "me@gmail.com")).build();
    }
}
