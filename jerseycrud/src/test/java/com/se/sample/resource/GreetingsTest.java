package com.se.sample.resource;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GreetingsTest extends JerseyTest {
    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(Greetings.class);
    }


    @Test
    public void tesFetchAll() {
        Response response = target("/greetings/hi").request().get();
        assertEquals("should return status 200", 200, response.getStatus());
        assertNotNull("Should return user list", response.getEntity().toString());
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
}