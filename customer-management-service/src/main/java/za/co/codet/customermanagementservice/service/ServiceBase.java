package za.co.codet.customermanagementservice.service;


import java.util.List;

public interface ServiceBase<T> {
    List<T> findAll();
    T findById(Long id);
    T findByEmail(String email);
    T saveOrUpdate(T entity);
}
