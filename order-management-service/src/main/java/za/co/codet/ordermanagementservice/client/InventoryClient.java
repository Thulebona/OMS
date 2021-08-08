package za.co.codet.ordermanagementservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "inventory-management-service", path = "api/inventory")
public interface InventoryClient {

    @GetMapping("available/{skuCode}")
    boolean isAvailable(@PathVariable String skuCode);

}
