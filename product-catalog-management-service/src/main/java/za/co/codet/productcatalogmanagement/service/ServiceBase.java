package za.co.codet.productcatalogmanagement.service;

import java.util.List;

public interface ServiceBase<T> {
    List<T> findAll();
    T findById(long id);
    T saveOrUpdate(T entity);
}
