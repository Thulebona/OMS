package za.co.codet.configmanagementserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigManagementServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigManagementServerApplication.class, args);
    }

}
