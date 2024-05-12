package com.se.sample.client;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
//@RequiredArgsConstructor
public class NasaPictureClient {

   // @Autowired
    private final RestTemplate restTemplate11;

    public NasaPictureClient(RestTemplate restTemplate) {
        this.restTemplate11 = restTemplate;
    }

    public List<String> getAllPictures() {
        System.out.println("calling nasa");
        JsonNode jsonNode = restTemplate11.getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=12&api_key=DEMO_KEY",
                JsonNode.class);

        return StreamSupport.stream(jsonNode.get("photos").spliterator(), false)
                .map(p -> p.get("img_src"))
                 .map(JsonNode::asText)
                .collect(Collectors.toList());
    }
}
