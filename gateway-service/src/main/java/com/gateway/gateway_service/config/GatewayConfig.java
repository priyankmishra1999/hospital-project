package com.gateway.gateway_service.config;

import com.gateway.gateway_service.logging.LoggingFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

@Configuration
@Scope("singleton")
public class GatewayConfig {
    private static final Log log = LogFactory.getLog(GatewayConfig.class);
//    private static final String PATH = "/api/";
//    private static final String VERSION = "v1";

    public GatewayConfig() {
    }

    @Bean
    public RouteLocator locator(RouteLocatorBuilder builder) {
        log.info("Inside gateway routes bean");
        return builder.routes().route("doctor-service", r -> r.path("/doctors/**").filters(f -> f
                        .filter(new RemoveDuplicateHeadersFilter())
                        .filter(new LoggingFilter())
                        .filter((exchange, chain) -> {
                            // Handle preflight OPTIONS requests
                            if (exchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
                                exchange.getResponse().setStatusCode(HttpStatus.OK);
                                return exchange.getResponse().setComplete();
                            }
                            return chain.filter(exchange);
                        })).uri("http://localhost:1234"))

//                .route("doctor-service", r -> r.path("/v3/api-docs")
//                        .filters(f -> f.rewritePath("/v3/api-docs", "/v3/api-docs"))
//                        .uri("http://localhost:1234"))
                .build();

    }
}
