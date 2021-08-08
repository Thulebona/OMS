package za.co.codet.ordermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderItemDto {
    private Long id;
    @JsonProperty(required = true)
    private String skuCode;
    private boolean isInStock;
    private BigDecimal price;
}
