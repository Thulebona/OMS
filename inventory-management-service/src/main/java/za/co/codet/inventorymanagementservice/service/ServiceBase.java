package za.co.codet.inventorymanagementservice.service;

import java.util.List;

public interface ServiceBase<T> {
    List<T> findAll();
    T findById(Long id);
    T saveOrUpdate(T entity);
    boolean isAvailable(String skuCode);
}
