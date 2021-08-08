package za.co.codet.customermanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String streetNo;
    private String streetName;
    private String suburb;
    private String cityOrTown;
    private String postalCode;
}
