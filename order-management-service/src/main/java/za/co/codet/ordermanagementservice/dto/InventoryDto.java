package za.co.codet.ordermanagementservice.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class InventoryDto {
    private Long id;
    private String skuCode;
    private Integer quantity;
}