package za.co.codet.ordermanagementservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import za.co.codet.ordermanagementservice.OrderManagementServiceApplication;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("OMS-API")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(OrderManagementServiceApplication.class.getPackage().getName()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("OMS API")
                .description("OMS Springboot restful microservice")
                .contact(contact())
                .version("1.0")
                .build();
    }

    private Contact contact() {
        return new Contact("DEV", "", "test@test.com");
    }
}