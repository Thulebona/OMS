package za.co.codet.customermanagementservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.codet.customermanagementservice.model.Address;
import za.co.codet.customermanagementservice.model.Customer;
import za.co.codet.customermanagementservice.respository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataSeed {

    @Autowired
    private CustomerRepository repository;

    @Bean
    public void seed() {
        Address address = Address.builder()
                .streetName("89")
                .streetNo("templar street")
                .cityOrTown("kuilsRiver")
                .postalCode("7580")
                .build();

        Address address2 = address.toBuilder()
                .streetName("1")
                .streetName("King shaka Street")
                .build();
        repository.saveAll(List.of(
                new Customer(null, "shaka@zulu.com", "shaka", "zulu", LocalDate.of(1893, 6, 2), address),
                new Customer(null, "dingane@zulu.com", "dingane", "zulu", LocalDate.of(1693, 12, 30), address2)
        ));
    }
}
