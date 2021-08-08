package za.co.codet.ordermanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.codet.ordermanagementservice.enums.OrderStatus;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private OrderStatus status;
    private final String orderNumber = UUID.randomUUID().toString();
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
