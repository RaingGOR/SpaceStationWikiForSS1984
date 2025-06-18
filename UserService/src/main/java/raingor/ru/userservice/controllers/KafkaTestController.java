package raingor.ru.userservice.controllers;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@RestController
public class KafkaTestController {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @GetMapping("/kafka/test")
    public String testKafkaConnection() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        try (AdminClient admin = AdminClient.create(props)) {
            admin.listTopics().names().get(3, TimeUnit.SECONDS);
            return "Successfully connected to Kafka at: " + bootstrapServers;
        } catch (Exception e) {
            return "Failed to connect to Kafka at: " + bootstrapServers +
                    "\nError: " + e.getMessage();
        }
    }
}
