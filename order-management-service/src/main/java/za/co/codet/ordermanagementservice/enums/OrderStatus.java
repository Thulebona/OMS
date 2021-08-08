package za.co.codet.ordermanagementservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    SHIPPED("shipped"),
    CANCELLED("cancelled"),
    CONFIRMED("confirmed"),
    PENDING_PAYMENT("pending client payment");
    private final String value;
}
