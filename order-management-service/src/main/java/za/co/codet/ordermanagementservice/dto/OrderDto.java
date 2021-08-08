package za.co.codet.ordermanagementservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import za.co.codet.ordermanagementservice.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    @JsonProperty(required = true)
    private Long customerId;
    private OrderStatus status;
    private String orderNumber;
    @JsonProperty(required = true)
    private List<OrderItemDto> orderItems = new ArrayList<>();
    private BigDecimal totalCost ;

    public BigDecimal getTotalCost() {
        return getOrderItems().stream()
                .filter(OrderItemDto::isInStock)
                .map(OrderItemDto::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
