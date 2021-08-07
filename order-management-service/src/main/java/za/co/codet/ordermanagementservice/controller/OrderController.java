package za.co.codet.ordermanagementservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.codet.ordermanagementservice.client.CustomerClient;
import za.co.codet.ordermanagementservice.client.InventoryClient;
import za.co.codet.ordermanagementservice.model.Order;
import za.co.codet.ordermanagementservice.service.ServiceBase;

import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class OrderController {

    private Order order;
//    private final OrderMapper mapper;
    private final ServiceBase<Order> orderService;
    private final InventoryClient inventoryClient;
    private final CustomerClient customerClient;

    public OrderController(ServiceBase<Order> orderService,
                           InventoryClient inventoryClient,
                           CustomerClient customerClient) {
//        this.mapper = mapper;
        this.orderService = orderService;
        this.inventoryClient = inventoryClient;
        this.customerClient = customerClient;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id);
//        return mapper.map(order);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.OK)
    public Order createOrder(@RequestBody Order orderDto) {
//        order = mapper.map(orderDto);
        customerClient.existById(1L);
        orderDto.getOrderItems()
                .stream()
                .filter(i -> inventoryClient.isAvailable(i.getSkuCode()))
                .collect(Collectors.toList());
        return orderService.saveOrUpdate(orderDto);
//        return mapper.map(order);
    }

    @PostMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@RequestBody Order orderDto) {
//        order = mapper.map(orderDto);
        return orderService.saveOrUpdate(orderDto);
//        return mapper.map(order);
    }

}
