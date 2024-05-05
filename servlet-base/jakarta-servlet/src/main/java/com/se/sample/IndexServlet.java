package com.se.sample;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * handle all request
 */
@WebServlet(urlPatterns = "/", name = "index")
public class IndexServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {

        String baseHtml  = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "  <title>HTML5 Boilerplate</title>\n" +
                "  <link rel=\"stylesheet\" href=\"styles.css\">\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "  <h1>Page Title</h1>\n" +
                "  <script src=\"scripts.js\"></script>\n" +
                "</body>\n" +
                "\n" +
                "</html>";

        PrintWriter out = response.getWriter();
        out.println(baseHtml);
    }
}