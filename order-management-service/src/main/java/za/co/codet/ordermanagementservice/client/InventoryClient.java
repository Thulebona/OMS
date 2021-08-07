package za.co.codet.ordermanagementservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import za.co.codet.ordermanagementservice.dto.InventoryDto;

@FeignClient(value = "inventory-management-service", path = "api/inventory")
public interface InventoryClient {

    @GetMapping("available/{skuCode}")
    boolean isAvailable(@PathVariable String skuCode);

    @PostMapping("update")
    InventoryDto update(@RequestBody InventoryDto inventory);
}
