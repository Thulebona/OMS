package za.co.codet.inventorymanagementservice.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.codet.inventorymanagementservice.model.Inventory;

import java.util.Optional;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
