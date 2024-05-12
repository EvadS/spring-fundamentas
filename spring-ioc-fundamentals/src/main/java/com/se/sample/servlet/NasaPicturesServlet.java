package com.se.sample.servlet;

import com.se.sample.client.NasaPictureClient;
import com.se.sample.config.DemoAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/nasa/pictures")
public class NasaPicturesServlet extends HttpServlet {
    private static final String ROOT_CONTEXT = "ROOT_CONTEXT";


    @Override
    public void init(ServletConfig config)   {
        var springContext = new AnnotationConfigApplicationContext(DemoAppConfig.class);
        var servletContext = config.getServletContext();
        servletContext.setAttribute(ROOT_CONTEXT, springContext);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        var springContext  = req.getServletContext().getAttribute(ROOT_CONTEXT);
        NasaPictureClient nasaPictureClient = ((ApplicationContext) springContext).getBean(NasaPictureClient.class);
        PrintWriter writer = resp.getWriter();
        nasaPictureClient.getAllPictures()
                .forEach(writer::println);
    }
}
