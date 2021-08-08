package za.co.codet.inventorymanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    private String skuCode;
    @Column(unique = true)
    private String barCode;
    private Integer quantity;
}