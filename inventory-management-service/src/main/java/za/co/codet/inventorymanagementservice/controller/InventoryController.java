package za.co.codet.inventorymanagementservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.codet.inventorymanagementservice.model.Inventory;
import za.co.codet.inventorymanagementservice.service.ServiceBase;

import java.util.List;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    private final ServiceBase<Inventory> inventoryService;

    public InventoryController(ServiceBase<Inventory> inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> findAll() {
        return inventoryService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Inventory findById(@PathVariable Long id) {
        return inventoryService.findById(id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory create(@RequestBody Inventory inventory) {
        return inventoryService.saveOrUpdate(inventory);
    }

    @PostMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public Inventory update(@RequestBody Inventory inventory) {
        return inventoryService.saveOrUpdate(inventory);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("available/{skuCode}")
    public boolean isAvailable(@PathVariable String skuCode) {
        return inventoryService.isAvailable(skuCode);
    }


}
