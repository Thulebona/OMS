package za.co.codet.ordermanagementservice.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class InventoryDto {
    private String skuCode;
    private String barCode;
    private Integer quantity;
}