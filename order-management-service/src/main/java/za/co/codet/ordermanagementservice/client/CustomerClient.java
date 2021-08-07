package za.co.codet.ordermanagementservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "customer-management-service" , path = "api/customer")
public interface CustomerClient {

    @GetMapping("exists/{id}")
    boolean existById(@PathVariable Long id);

}
