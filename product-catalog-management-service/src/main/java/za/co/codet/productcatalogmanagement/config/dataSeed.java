package za.co.codet.productcatalogmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.codet.productcatalogmanagement.model.Product;
import za.co.codet.productcatalogmanagement.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class dataSeed {

    @Autowired
    private ProductRepository repository;

    @Bean
    public void seed(){
        repository.saveAll( List.of(
                new Product(0L,"sim card", "5G_SIM", BigDecimal.valueOf(5) ,"5g sim card"),
                new Product(0L,"router", "5G_ROUTER", BigDecimal.valueOf(500) ,"5g home router")
        ));
    }
}
