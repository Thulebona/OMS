package za.co.codet.ordermanagementservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.codet.ordermanagementservice.model.Order;
import za.co.codet.ordermanagementservice.service.ServiceBase;

@RestController
@RequestMapping("order")
public class OrderController {

    private Order order;
//    private final OrderMapper mapper;
    private final ServiceBase<Order> orderService;

    public OrderController(ServiceBase<Order> orderService) {
        this.orderService = orderService;
//        this.mapper = mapper;
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
