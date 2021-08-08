package za.co.codet.customermanagementservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.codet.customermanagementservice.model.Customer;
import za.co.codet.customermanagementservice.respository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ServiceBase<Customer> {

    private final CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    @Override
    public Customer saveOrUpdate(Customer entity) {
        return repository.save(entity);
    }

}
