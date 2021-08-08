package za.co.codet.ordermanagementservice.service;

public interface ServiceBase<T> {
    T findById(Long id);
    void saveOrUpdate(T entity);
}
