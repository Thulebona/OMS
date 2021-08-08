package za.co.codet.inventorymanagementservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.codet.inventorymanagementservice.model.Inventory;
import za.co.codet.inventorymanagementservice.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService implements ServiceBase<Inventory> {

    private final InventoryRepository repository;

    @Override
    public Inventory findBySkuCode(String skuCode) {
        return repository.findById(skuCode).orElse(null);
    }

    @Override
    public void saveOrUpdate(Inventory entity) {
        repository.save(entity);
    }

    @Override
    public List<Inventory> findAll() {
        return (List<Inventory>) repository.findAll();
    }

    @Override
    public boolean isAvailable(String skuCode) {
        return repository.findById(skuCode)
                .filter(value -> value.getQuantity() > 0)
                .isPresent();
    }
}
