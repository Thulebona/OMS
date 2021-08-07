package za.co.codet.productcatalogmanagement.service;

import org.springframework.stereotype.Service;
import za.co.codet.productcatalogmanagement.model.Product;
import za.co.codet.productcatalogmanagement.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements ServiceBase<Product> {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public Product findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product saveOrUpdate(Product entity) {
        return repository.save(entity);
    }
}
