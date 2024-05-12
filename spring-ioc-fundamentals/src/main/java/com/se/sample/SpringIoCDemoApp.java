package com.se.sample;

import com.se.sample.client.NasaPictureClient;
import com.se.sample.config.DemoAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCDemoApp {

    public static void main(String[] args) {
        // базовый вариант
        //  var context = new AnnotationConfigApplicationContext(NasaPictureClient.class, RestTemplate.class);
        var context = new AnnotationConfigApplicationContext(DemoAppConfig.class);

        var nasaClient = context.getBean(NasaPictureClient.class);

        nasaClient.getAllPictures()
                .forEach(System.out::println);
    }
}
