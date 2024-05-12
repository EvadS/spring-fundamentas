package com.se.sample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("fn");
        String lastName = request.getParameter("ln");

        response.getWriter().append("Full Name: " + firstName + " " + lastName);
    }
}
