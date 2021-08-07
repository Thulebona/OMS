package za.co.codet.productcatalogmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.codet.productcatalogmanagement.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
