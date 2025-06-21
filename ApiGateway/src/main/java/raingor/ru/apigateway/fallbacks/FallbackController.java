package raingor.ru.apigateway.fallbacks;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Map;

@RestController
public class FallbackController {
    @RequestMapping("/user-fallback")
    public Mono<Map<String, Object>> userFallback() {
        return Mono.just(Map.of(
                "error", "User Service is temporarily unavailable",
                "timestamp", Instant.now(),
                "status", 503
        ));
    }

    @RequestMapping("/core-fallback")
    public Mono<Map<String, Object>> coreFallback() {
        return Mono.just(Map.of(
                "error", "Wiki Core Service is temporarily unavailable",
                "timestamp", Instant.now(),
                "status", 503
        ));
    }
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}
