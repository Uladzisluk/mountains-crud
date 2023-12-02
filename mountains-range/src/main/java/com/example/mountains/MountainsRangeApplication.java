package com.example.mountains;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MountainsRangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MountainsRangeApplication.class, args);
    }

    /**
     * @param baseUrl base URL
     * @return configured endpoint for character module
     */
    @Bean
    public RestTemplate restTemplate(@Value("${mountains.peak.url}") String baseUrl) {
        return new RestTemplateBuilder().rootUri(baseUrl).build();
    }
}
