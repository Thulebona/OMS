package za.co.codet.ordermanagementservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.codet.ordermanagementservice.client.CustomerClient;
import za.co.codet.ordermanagementservice.client.InventoryClient;
import za.co.codet.ordermanagementservice.dto.OrderDto;
import za.co.codet.ordermanagementservice.mapper.OrderMapper;
import za.co.codet.ordermanagementservice.model.Order;
import za.co.codet.ordermanagementservice.service.ServiceBase;

@RestController
@RequestMapping("order")
public class OrderController {

    private Order order;
    private final OrderMapper mapper;
    private final ServiceBase<Order> orderService;
    private final InventoryClient inventoryClient;
    private final CustomerClient customerClient;

    public OrderController(OrderMapper mapper,
                           ServiceBase<Order> orderService,
                           InventoryClient inventoryClient,
                           CustomerClient customerClient) {
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
        order = mapper.map(orderDto);
        order.getOrderItems().removeIf(o -> inventoryClient.isAvailable(o.getSkuCode()));
        orderService.saveOrUpdate(order);
        return mapper.map(order);
    }

    @PostMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        order = mapper.map(orderDto);
        orderService.saveOrUpdate(order);
        return mapper.map(order);
    }

}
