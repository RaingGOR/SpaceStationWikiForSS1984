package raingor.ru.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import raingor.ru.apigateway.config.UriConfiguration;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(UriConfiguration.class)
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfig) {
        return builder.routes()
                .route("user-service", r -> r
                        .path("/users/**", "/profile/**")
                        .filters(f -> f
                                .rewritePath("/(users|profile)/(?<segment>.*)", "/api-user/$1/${segment}")
                                .circuitBreaker(cb -> cb
                                        .setName("user-cb")
                                        .setFallbackUri("forward:/user-fallback")))
                        .uri(uriConfig.userServiceUrl()))
                .route("wiki-core-service", r -> r
                        .path("/articles/**", "/wiki/**")
                        .filters(f -> f
                                .rewritePath("/(articles|wiki)/(?<segment>.*)", "/api-core/${segment}")
                                .circuitBreaker(cb -> cb
                                        .setName("core-cb")
                                        .setFallbackUri("forward:/core-fallback")))
                        .uri(uriConfig.wikiServiceUrl())
                )
                .build();
    }
}
