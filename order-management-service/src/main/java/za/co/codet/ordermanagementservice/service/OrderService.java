package za.co.codet.ordermanagementservice.service;

import org.springframework.stereotype.Service;
import za.co.codet.ordermanagementservice.model.Order;
import za.co.codet.ordermanagementservice.repository.OrderRepository;

import java.util.Optional;

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
    public Order saveOrUpdate(Order entity) {
        Optional<Order> order = repository.findById(entity.getId());
        if (order.isEmpty()) {
            return repository.save(entity);
        }

        return order
                .filter(e -> !e.getStatus().equals(entity.getStatus()))
                .map(repository::save)
                .orElse(entity);
    }
}
