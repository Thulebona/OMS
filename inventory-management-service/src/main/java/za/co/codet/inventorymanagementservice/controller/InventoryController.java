package za.co.codet.inventorymanagementservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.codet.inventorymanagementservice.model.Inventory;
import za.co.codet.inventorymanagementservice.service.ServiceBase;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("inventory")
public class InventoryController {

    private final ServiceBase<Inventory> inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> findAll() {
        return inventoryService.findAll();
    }

    @GetMapping("{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public Inventory findById(@PathVariable String skuCode) {
        return inventoryService.findBySkuCode(skuCode);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory create(@RequestBody Inventory inventory) {
        inventoryService.saveOrUpdate(inventory);
        return inventory;
    }

    @PostMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public Inventory update(@RequestBody Inventory inventory) {
        inventoryService.saveOrUpdate(inventory);
        return inventory;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("available/{skuCode}")
    public boolean isAvailable(@PathVariable String skuCode) {
        return inventoryService.isAvailable(skuCode);
    }


}
