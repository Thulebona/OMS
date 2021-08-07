package za.co.codet.customermanagementservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.codet.customermanagementservice.model.Customer;
import za.co.codet.customermanagementservice.service.ServiceBase;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final ServiceBase<Customer> customerService;

    public CustomerController(ServiceBase<Customer> customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findCustomers() {
        return customerService.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @GetMapping("exists/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean existById(@PathVariable Long id) {
        return customerService.findById(id) != null;
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveOrUpdate(customer);
    }

    @PostMapping("update")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.saveOrUpdate(customer);
    }
}
