package za.co.codet.ordermanagementservice.service;

import org.springframework.stereotype.Service;
import za.co.codet.ordermanagementservice.enums.OrderStatus;
import za.co.codet.ordermanagementservice.model.Order;
import za.co.codet.ordermanagementservice.repository.OrderRepository;

@Service
public class OrderService implements ServiceBase<Order> {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveOrUpdate(Order entity) {

        if (entity.getId() == null) {
            entity.setStatus(OrderStatus.CONFIRMED);
            repository.save(entity);
        } else {
            repository.findById(entity.getId())
                    .filter(e -> !e.getStatus().equals(entity.getStatus()))
                    .map(repository::save);
        }
    }
}
