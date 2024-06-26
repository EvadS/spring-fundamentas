package com.se.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/// Important
@EnableWebMvc

@Configuration
@ComponentScan("com.se.sample")
public class DemoAppConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
