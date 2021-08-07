package za.co.codet.ordermanagementservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    SHIPPED("shipped"),
    CANCELLED("cancelled"),
    READY_FOR_DELIVERY("ready for delivery"),
    PENDING_PAYMENT("pending client payment");
    private final String value;
}
