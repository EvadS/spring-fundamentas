package com.se.sample.resource;

import com.se.sample.model.Product;
import com.se.sample.model.ProductDAO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/products")
public class ProductResource {

    private ProductDAO dao = ProductDAO.getInstance();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        List<Product> listProducts = dao.listAll();

        if (listProducts.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(listProducts).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Product product = dao.get(id);
        if (product != null) {
            return Response.ok(product, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Product product) throws URISyntaxException {
        int newProductId = dao.add(product);
        URI uri = new URI("/products/" + newProductId);
        return Response.created(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, Product product) {
        product.setId(id);
        if (dao.update(product)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        if (dao.delete(id)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
}
