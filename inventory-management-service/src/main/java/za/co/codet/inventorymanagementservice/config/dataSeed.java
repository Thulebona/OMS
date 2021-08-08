package za.co.codet.inventorymanagementservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.codet.inventorymanagementservice.model.Inventory;
import za.co.codet.inventorymanagementservice.repository.InventoryRepository;

import java.util.List;
import java.util.UUID;

@Configuration
public class dataSeed {

    @Autowired
    private InventoryRepository repository;

    @Bean
    public void seed() {
        repository.saveAll(List.of(
                new Inventory("5G_SIM", UUID.randomUUID().toString(), 10),
                new Inventory("5G_ROUTER", UUID.randomUUID().toString(), 0)
        ));
    }
}
