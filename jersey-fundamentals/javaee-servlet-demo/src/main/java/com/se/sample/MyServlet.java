package com.se.sample;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/M")
public class MyServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(config)");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        response.getWriter().write("bla -bla-bla");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {

    }
}
