package com.se.sample;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(urlPatterns = "/uppercase", name = "uppercaseServlet")
public class UppercaseServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {

        String inputParam = Optional.ofNullable(request.getParameter("input"))
                .orElse("test");

        String inputString = inputParam.toUpperCase();

        PrintWriter out = response.getWriter();
        out.println(inputString);
    }
}