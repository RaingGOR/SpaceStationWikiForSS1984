package raingor.ru.apigateway.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "services")
public record UriConfiguration(
        String userServiceUrl,
        String wikiServiceUrl
) {
}
