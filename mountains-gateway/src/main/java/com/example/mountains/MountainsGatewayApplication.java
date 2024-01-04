package com.example.mountains;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

import java.util.Arrays;
import java.util.Collections;

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

    @Bean
    public CorsWebFilter corsWebFilter(){
        final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
        corsConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return new CorsWebFilter((CorsConfigurationSource) source);
    }
}
