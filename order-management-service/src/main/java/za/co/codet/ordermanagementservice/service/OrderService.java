package za.co.codet.ordermanagementservice.service;

import org.springframework.stereotype.Service;
import za.co.codet.ordermanagementservice.enums.OrderStatus;
import za.co.codet.ordermanagementservice.model.Order;
import za.co.codet.ordermanagementservice.repository.OrderRepository;

import java.util.UUID;

@Service
public class OrderService implements ServiceBase<Order> {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Order id: %s not found", id)));
    }

    @Override
    public void saveOrUpdate(Order entity) {
        if (entity.getId() == null) {
            entity.setStatus(OrderStatus.CONFIRMED);
            entity.setOrderNumber(UUID.randomUUID().toString());
        }
        repository.save(entity);
    }
}
