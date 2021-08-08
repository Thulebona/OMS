package za.co.codet.productcatalogmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.codet.productcatalogmanagement.client.InventoryClient;
import za.co.codet.productcatalogmanagement.model.Product;
import za.co.codet.productcatalogmanagement.service.ServiceBase;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "product")
public class ProductController {

    private final ServiceBase<Product> service;
    private final InventoryClient inventoryClient;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllProducts() {
        return service.findAll().stream()
                .filter(p -> inventoryClient.isAvailable(p.getSkuCode())) //todo avoid looping api calls
                .collect(Collectors.toList());

    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findProductById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return service.saveOrUpdate(product);
    }

    @PostMapping(value = "update")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@RequestBody Product product) {
        return service.saveOrUpdate(product);
    }

}
