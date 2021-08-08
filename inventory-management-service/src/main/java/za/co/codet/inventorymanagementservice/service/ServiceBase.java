package za.co.codet.inventorymanagementservice.service;

import java.util.List;

public interface ServiceBase<T> {
    List<T> findAll();
    T findBySkuCode(String skuCode);
    void saveOrUpdate(T entity);
    boolean isAvailable(String skuCode);
}
