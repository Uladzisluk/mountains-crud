package com.example.mountains;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MountainsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MountainsGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${mountains.peak.url}") String peakUrl,
            @Value("${mountains.range.url}") String rangeUrl,
            @Value("${mountains.gateway.host}") String host
    ){
        return builder
                .routes()
                .route("ranges", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/ranges/{uuid}",
                                "/api/ranges"
                        )
                        .uri(rangeUrl)
                )
                .route("peaks", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/peaks",
                                "/api/peaks/**",
                                "/api/ranges/{uuid}/peaks",
                                "/api/ranges/{uuid}/peaks/**"
                        )
                        .uri(peakUrl))
                .build();
    }
}
