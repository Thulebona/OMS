package za.co.codet.productcatalogmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ProductCatalogManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogManagementApplication.class, args);
    }

}
