package za.co.codet.ordermanagementservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import za.co.codet.ordermanagementservice.enums.OrderStatus;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderDto {

    private Long id;
    private Long customerId;
    private OrderStatus status;
    private String orderNumber;
    private List<OrderItemDto> orderItems;
}
