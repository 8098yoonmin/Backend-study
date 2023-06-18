package com.nhnacademy.minidooray.hellogateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("hello-service-1",
                        p -> p.path("/hello/**").and()
                                .weight("hello-service", 10)
                                .uri("http://localhost:8081")
                )
                .route("hello-service-2",
                        p -> p.path("/hello/**").and()
                                .weight("hello-service", 90)
                                .uri("http://localhost:8082")
                )
                .build();
    }


}
