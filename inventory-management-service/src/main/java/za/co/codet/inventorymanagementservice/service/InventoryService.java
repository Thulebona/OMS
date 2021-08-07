package za.co.codet.inventorymanagementservice.service;

import org.springframework.stereotype.Service;
import za.co.codet.inventorymanagementservice.model.Inventory;
import za.co.codet.inventorymanagementservice.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService implements ServiceBase<Inventory> {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inventory findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Inventory saveOrUpdate(Inventory entity) {
        return repository.save(entity);
    }

    @Override
    public List<Inventory> findAll() {
        return (List<Inventory>) repository.findAll();
    }

    @Override
    public boolean isAvailable(String skuCode) {
        return repository.findBySkuCode(skuCode)
                .filter(value -> value.getQuantity() > 0)
                .isPresent();
    }
}
