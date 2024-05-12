package com.se.sample.controller;


import com.se.sample.client.NasaPictureClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v2/nasa/pictures")
@RequiredArgsConstructor
public class NasaPicturesController {

    private final NasaPictureClient nasaPictureClient;
    private final HttpServletRequest request;

    @GetMapping
    public String getAllPicturesUrls(){
        var servletContext = request.getServletContext();
        System.out.println("printing servlet context attributes");

        servletContext.getAttributeNames().asIterator().forEachRemaining(System.out::println);

        return  nasaPictureClient.getAllPictures()
                .stream()
                .collect(Collectors.joining("\n"));
    }
}
