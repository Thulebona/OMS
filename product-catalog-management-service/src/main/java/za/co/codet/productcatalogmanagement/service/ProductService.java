package za.co.codet.productcatalogmanagement.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.codet.productcatalogmanagement.model.Product;
import za.co.codet.productcatalogmanagement.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ServiceBase<Product> {
    private final ProductRepository repository;

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
