package com.se.sample.resource;



import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Simple test to check "Hello World!" is being returned from the helloworld resource.
 *
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
public class UserResourceTest extends JerseyTest {

    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(UserResource.class);
    }

    @Test
    public void tesFetchAll() {
        Response response = target("/users").request().get();
        assertEquals("should return status 200", 200, response.getStatus());
        assertNotNull("Should return user list", response.getEntity().toString());
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    @Test
    public void testGetById() {
        Response output = target("/users/user/100").request().get();
        assertEquals("Should return status 200", 200, output.getStatus());
        assertNotNull("Should return user object as json", output.getEntity());
        System.out.println(output.getStatus());
        System.out.println(output.readEntity(String.class));
    }
}