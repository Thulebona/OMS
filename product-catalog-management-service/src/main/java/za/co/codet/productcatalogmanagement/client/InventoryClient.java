package za.co.codet.productcatalogmanagement.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("inventory-management-service")
public interface InventoryClient {

    @GetMapping("available/{skuCode}")
    boolean isAvailable(@PathVariable String skuCode);
}
