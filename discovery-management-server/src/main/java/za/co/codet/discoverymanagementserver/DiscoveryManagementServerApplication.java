package za.co.codet.discoverymanagementserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryManagementServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryManagementServerApplication.class, args);
    }

}
