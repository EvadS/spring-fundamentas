package org.restapi.crud.crud.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.restapi.crud.crud.model.crudmodel;
import org.restapi.crud.crud.service.crudservice;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/crud")
public class crudresource {

    crudservice service = new crudservice();

    @Path("/insertion")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public crudmodel addUser(crudmodel user) {
        return service.insertUser(user);
    }

    @Path("/retrieve")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<crudmodel> getUser() throws SQLException {
        return service.getUser();
    }

    @Path("/retrieveById/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<crudmodel> getUser(@PathParam("id") int id) throws SQLException {
        return service.getUserById(id);
    }


    @Path("/updateUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public crudmodel updateUser(crudmodel user) {
        return service.updatetUser(user);
    }

    @Path("/deleteUserById/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public int deleteUser(@PathParam("id") int id) {
        return service.deletetUser(id);
    }
}
