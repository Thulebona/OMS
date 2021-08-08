package za.co.codet.ordermanagementservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.codet.ordermanagementservice.client.CustomerClient;
import za.co.codet.ordermanagementservice.client.InventoryClient;
import za.co.codet.ordermanagementservice.dto.OrderDto;
import za.co.codet.ordermanagementservice.dto.UpdateStatusInput;
import za.co.codet.ordermanagementservice.mapper.OrderMapper;
import za.co.codet.ordermanagementservice.model.Order;
import za.co.codet.ordermanagementservice.service.ServiceBase;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

    private Order order;
    private final OrderMapper mapper;
    private final ServiceBase<Order> orderService;
    private final InventoryClient inventoryClient;
    private final CustomerClient customerClient;

    public OrderController(OrderMapper mapper, ServiceBase<Order> orderService,
                           InventoryClient inventoryClient, CustomerClient customerClient) {
        this.mapper = mapper;
        this.orderService = orderService;
        this.inventoryClient = inventoryClient;
        this.customerClient = customerClient;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto findById(@PathVariable Long id) {
        order = orderService.findById(id);
        return mapper.map(order);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {

        if (orderDto.getOrderItems().isEmpty()) {
            throw new RuntimeException("add items to order");
        }
        if (!customerClient.existById(orderDto.getCustomerId())) {
            throw new RuntimeException(String.format("Customer ID: %s does not exist", orderDto.getCustomerId()));
        }
        order = mapper.map(orderDto);
        order.getOrderItems().forEach(item -> item.setInStock(inventoryClient.isAvailable(item.getSkuCode())));
        orderService.saveOrUpdate(order);
        return mapper.map(order);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("update/status")
    public OrderDto updateStatus(@RequestBody UpdateStatusInput statusInput) {
        order = orderService.findById(statusInput.getId());
        order.setStatus(statusInput.getStatus());
        return mapper.map(order);
    }

}
